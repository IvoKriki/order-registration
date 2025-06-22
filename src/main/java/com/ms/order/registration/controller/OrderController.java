package com.ms.order.registration.controller;

import com.ms.order.registration.model.OrderEntity;
import com.ms.order.registration.service.OrderService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final RabbitTemplate rabbitTemplate;

    public OrderController(OrderService orderService, RabbitTemplate rabbitTemplate) {
        this.orderService = orderService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.processing.name}")
    private String routingKey;

    @PostMapping
    public String createOrders(@RequestBody OrderEntity order){
        OrderEntity savedOrder = orderService.save(order);
        rabbitTemplate.convertAndSend(routingKey, savedOrder.getDescription());
        return "Order saved and message sent to RabbitMQ" + order.getDescription();
    }

    @GetMapping
    public List<OrderEntity> listOrders(OrderEntity order){
        return orderService.listOrderEntity(order);
    }
}

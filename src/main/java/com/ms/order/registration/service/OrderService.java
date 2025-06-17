package com.ms.order.registration.service;

import com.ms.order.registration.model.OrderEntity;
import com.ms.order.registration.model.OrderItemEntity;
import com.ms.order.registration.repository.OrderEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderEntityRepository orderEntityRepository;

    public OrderService(OrderEntityRepository orderEntityRepository) {
        this.orderEntityRepository = orderEntityRepository;
    }

    public OrderEntity save(OrderEntity orderEntity) {

        if (orderEntity.getItems() != null && orderEntity.getItems().isEmpty()) {
            for (OrderItemEntity orderItemEntity : orderEntity.getItems()) {
                orderItemEntity.setOrderEntity(orderEntity);
            }
        }
        return orderEntityRepository.save(orderEntity);
    }

    public List<OrderEntity> listOrderEntity(OrderEntity orderEntity) {
        if (orderEntity.getItems() != null && orderEntity.getItems().isEmpty()) {
            for (OrderItemEntity orderItemEntity : orderEntity.getItems()) {
                orderItemEntity.setOrderEntity(orderEntity);
            }
        }
        return orderEntityRepository.findAll();
    }
}

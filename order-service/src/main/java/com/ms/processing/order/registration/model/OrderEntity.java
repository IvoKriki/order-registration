package com.ms.processing.order.registration.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderEntityId;
    private String description;

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL)
    private List<OrderItemEntity> items;

    public long getOrderEntityId() {
        return orderEntityId;
    }

    public void setOrderEntityId(long orderEntityId) {
        this.orderEntityId = orderEntityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OrderItemEntity> getItems() {
        return items;
    }

    public void setItems(List<OrderItemEntity> items) {
        this.items = items;
    }
}

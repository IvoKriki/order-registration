package com.ms.processing.order.registration.repository;

import com.ms.processing.order.registration.model.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
}

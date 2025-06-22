package com.ms.processing.order.registration.repository;

import com.ms.processing.order.registration.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {
}

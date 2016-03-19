package org.dd.jtademo.repository.order;

import org.dd.jtademo.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}

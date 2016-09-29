package com.wsjia.jta.repository.order;

import com.wsjia.jta.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @description
 *
 * @author kayson Yang
 * @create 2016-09-22 19:22
 */

public interface OrderRepository extends JpaRepository<Order, Integer> {

}

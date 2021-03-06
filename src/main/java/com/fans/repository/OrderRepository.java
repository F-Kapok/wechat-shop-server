package com.fans.repository;

import com.fans.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

/**
 * interfaceName: OrderRepository
 *
 * @author k
 * @version 1.0
 * @description
 * @date 2020-06-07 18:34
 **/
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Page<Order> findByExpiredTimeGreaterThanAndStatusAndUserId(Date now, Integer status, Long userId, Pageable pageable);

    Page<Order> findByUserId(Long userId, Pageable pageable);

    Page<Order> findByUserIdAndStatus(Long userId, Integer status, Pageable pageable);

    Optional<Order> findFirstByUserIdAndId(Long userId, Long orderId);

    Optional<Order> findFirstByOrderNo(String orderNo);

    @Modifying
    @Query(value = "update `order` set status = :orderStatus where order_no = :orderNo", nativeQuery = true)
    int updateStatusByOrderNo(@Param("orderNo") String orderNo, @Param("orderStatus") Integer orderStatus);

    @Modifying
    @Query(value = "update `order` set status = 5 where id = :orderId and status = 1", nativeQuery = true)
    int cancelOrder(@Param("orderId") Long orderId);
}

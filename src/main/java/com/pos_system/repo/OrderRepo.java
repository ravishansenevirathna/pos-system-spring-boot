package com.pos_system.repo;

import com.pos_system.dto.paginated.PaginatedResponseOrderDetailsDto;
import com.pos_system.dto.queryInterface.OrderDetailsInterface;
import com.pos_system.dto.response.ResponseOrderDetailsDto;
import com.pos_system.entity.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {

    @Query(value = "select c.customer_name as customerName," +
            " c.phone_number as phoneNumber," +
            "c.address as address," +
            " o.order_date as date," +
            "o.total as total" +
            " from customer c,orders o where o.total = ?1 and c.customer_id = o.customer_id",nativeQuery = true)
    List<OrderDetailsInterface> getOrdersByTotal(int total, Pageable pageable);

    int countAllByTotal(int total);
}

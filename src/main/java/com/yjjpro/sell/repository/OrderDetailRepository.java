package com.yjjpro.sell.repository;

import com.yjjpro.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/2/27 19:18
 * @Description:
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    List<OrderDetail> findByOrderId(String orderId);
}

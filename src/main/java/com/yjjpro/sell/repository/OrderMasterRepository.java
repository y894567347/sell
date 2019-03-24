package com.yjjpro.sell.repository;

import com.yjjpro.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/2/27 19:14
 * @Description:
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
    Page<OrderMaster> findByBuyerOpenid (String buyerOpenId, Pageable pageable);


}

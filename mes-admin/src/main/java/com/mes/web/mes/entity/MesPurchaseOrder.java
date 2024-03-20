package com.mes.web.mes.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.mes.common.core.domain.BaseEntity;

/**
 * 采购订单对象 mes_purchase_order
 *
 * @author lixing
 * @date 2024-03-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mes_purchase_order")
public class MesPurchaseOrder extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 采购订单号
     */
    private String purchaseNo;
    /**
     * 采购物料类型
     */
    private String purchaseType;
    /**
     * 采购订单状态
     */
    private String purchaseState;
    /**
     * 发起部门
     */
    private String startDept;
    /**
     * 发起部门id
     */
    private Long startDeptId;
    /**
     * 删除标记（正常=0，删除=1）
     */
    @TableLogic
    private String delFlag;

}

package com.mes.web.mes.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

import com.mes.common.core.domain.BaseEntity;

/**
 * 采购订单明细对象 mes_purchase_detils
 *
 * @author lixing
 * @date 2024-03-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mes_purchase_detils")
public class MesPurchaseDetils extends BaseEntity {

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
     * 物料id
     */
    private String matId;
    /**
     * 物料名称
     */
    private String matName;
    /**
     * 物料大类
     */
    private String matType;
    /**
     * 物料大类编码
     */
    private String matTypeNo;
    /**
     * 规格
     */
    private String model;
    /**
     * 颜色
     */
    private String color;
    /**
     * 重量
     */
    private Double weight;
    /**
     * 长度
     */
    private Double lenth;
    /**
     * 数量
     */
    private Double num;
    /**
     * 单位
     */
    private String unit;
    /**
     * 单位单价
     */
    private BigDecimal prices;
    /**
     * 不含税单价
     */
    private BigDecimal taxFreePrice;
    /**
     * 含税总价
     */
    private BigDecimal sumPricesTax;
    /**
     * 备注
     */
    private String remark;
    /**
     * 删除标记(正常=0，删除=1)
     */
    @TableLogic
    private String delFlag;

}

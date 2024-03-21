package com.mes.web.mes.entity.bo;

import com.mes.common.core.validate.AddGroup;
import com.mes.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import java.math.BigDecimal;
import com.mes.common.core.domain.BaseEntity;

/**
 * 采购订单明细业务对象 mes_purchase_detils
 *
 * @author lixing
 * @date 2024-03-21
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class MesPurchaseDetilsBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 采购订单号
     */
    @NotBlank(message = "采购订单号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String purchaseNo;

    /**
     * 物料id
     */
    @NotBlank(message = "物料id不能为空", groups = { AddGroup.class, EditGroup.class })
    private String matId;

    /**
     * 物料名称
     */
    @NotBlank(message = "物料名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String matName;

    /**
     * 物料大类
     */
    @NotBlank(message = "物料大类不能为空", groups = { AddGroup.class, EditGroup.class })
    private String matType;

    /**
     * 物料大类编码
     */
    @NotBlank(message = "物料大类编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String matTypeNo;

    /**
     * 规格
     */
    @NotBlank(message = "规格不能为空", groups = { AddGroup.class, EditGroup.class })
    private String model;

    /**
     * 颜色
     */
    @NotBlank(message = "颜色不能为空", groups = { AddGroup.class, EditGroup.class })
    private String color;

    /**
     * 重量
     */
    @NotNull(message = "重量不能为空", groups = { AddGroup.class, EditGroup.class })
    private Double weight;

    /**
     * 长度
     */
    @NotNull(message = "长度不能为空", groups = { AddGroup.class, EditGroup.class })
    private Double lenth;

    /**
     * 数量
     */
    @NotNull(message = "数量不能为空", groups = { AddGroup.class, EditGroup.class })
    private Double num;

    /**
     * 单位
     */
    @NotBlank(message = "单位不能为空", groups = { AddGroup.class, EditGroup.class })
    private String unit;

    /**
     * 单位单价
     */
    @NotNull(message = "单位单价不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal prices;

    /**
     * 不含税单价
     */
    @NotNull(message = "不含税单价不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal taxFreePrice;

    /**
     * 含税总价
     */
    @NotNull(message = "含税总价不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal sumPricesTax;

    /**
     * 备注
     */
    @NotBlank(message = "备注不能为空", groups = { AddGroup.class, EditGroup.class })
    private String remark;


}

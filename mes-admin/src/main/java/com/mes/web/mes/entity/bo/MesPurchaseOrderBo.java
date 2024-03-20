package com.mes.web.mes.entity.bo;

import com.mes.common.core.validate.AddGroup;
import com.mes.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import com.mes.common.core.domain.BaseEntity;

/**
 * 采购订单业务对象 mes_purchase_order
 *
 * @author lixing
 * @date 2024-03-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class MesPurchaseOrderBo extends BaseEntity {

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
     * 采购物料类型
     */
    @NotBlank(message = "采购物料类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private String purchaseType;

    /**
     * 采购订单状态
     */
    @NotBlank(message = "采购订单状态不能为空", groups = { AddGroup.class, EditGroup.class })
    private String purchaseState;

    /**
     * 发起部门
     */
    @NotBlank(message = "发起部门不能为空", groups = { AddGroup.class, EditGroup.class })
    private String startDept;

    /**
     * 发起部门id
     */
    @NotNull(message = "发起部门id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long startDeptId;


}

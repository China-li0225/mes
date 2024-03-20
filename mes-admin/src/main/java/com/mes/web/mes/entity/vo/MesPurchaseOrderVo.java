package com.mes.web.mes.entity.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.mes.common.annotation.ExcelDictFormat;
import com.mes.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;

import java.io.Serializable;

/**
 * 采购订单视图对象 mes_purchase_order
 *
 * @author lixing
 * @date 2024-03-19
 */
@Data
@ExcelIgnoreUnannotated
public class MesPurchaseOrderVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 采购订单号
     */
    @ExcelProperty(value = "采购订单号")
    private String purchaseNo;

    /**
     * 采购物料类型
     */
    @ExcelProperty(value = "采购物料类型")
    private String purchaseType;

    /**
     * 采购订单状态
     */
    @ExcelProperty(value = "采购订单状态")
    private String purchaseState;

    /**
     * 发起部门
     */
    @ExcelProperty(value = "发起部门")
    private String startDept;

    /**
     * 发起部门id
     */
    @ExcelProperty(value = "发起部门id")
    private Long startDeptId;


}

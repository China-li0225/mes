package com.mes.web.mes.entity.vo;

import java.math.BigDecimal;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.mes.common.annotation.ExcelDictFormat;
import com.mes.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;

import java.io.Serializable;

/**
 * 采购订单明细视图对象 mes_purchase_detils
 *
 * @author lixing
 * @date 2024-03-21
 */
@Data
@ExcelIgnoreUnannotated
public class MesPurchaseDetilsVo implements Serializable {

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
     * 物料id
     */
    @ExcelProperty(value = "物料id")
    private String matId;

    /**
     * 物料名称
     */
    @ExcelProperty(value = "物料名称")
    private String matName;

    /**
     * 物料大类
     */
    @ExcelProperty(value = "物料大类")
    private String matType;

    /**
     * 物料大类编码
     */
    @ExcelProperty(value = "物料大类编码")
    private String matTypeNo;

    /**
     * 规格
     */
    @ExcelProperty(value = "规格")
    private String model;

    /**
     * 颜色
     */
    @ExcelProperty(value = "颜色")
    private String color;

    /**
     * 重量
     */
    @ExcelProperty(value = "重量")
    private Double weight;

    /**
     * 长度
     */
    @ExcelProperty(value = "长度")
    private Double lenth;

    /**
     * 数量
     */
    @ExcelProperty(value = "数量")
    private Double num;

    /**
     * 单位
     */
    @ExcelProperty(value = "单位")
    private String unit;

    /**
     * 单位单价
     */
    @ExcelProperty(value = "单位单价")
    private BigDecimal prices;

    /**
     * 不含税单价
     */
    @ExcelProperty(value = "不含税单价")
    private BigDecimal taxFreePrice;

    /**
     * 含税总价
     */
    @ExcelProperty(value = "含税总价")
    private BigDecimal sumPricesTax;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}

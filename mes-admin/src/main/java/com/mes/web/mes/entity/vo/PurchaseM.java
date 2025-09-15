package com.mes.web.mes.entity.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * ClassName: PurchaseM <br/>
 * Description: <br/>
 * date: 2024/9/4 17:00<br/>
 *
 * @author lixing<br />
 * @since JDK
 */
@Data
public class PurchaseM {
    //select b.id,a.psvid,a.cSVCode,a.dSVDate,a.cBusType,a.cBusType,a.cVenCode,a.iTaxRate,a.cMaker,b.cWhCode,b.cInvCode,
    // b.iSVQuantity,b.iSVCost,b.iSVPrice,b.iTax,b.iSum,b.cPIVCode,b.cBillCode from UFDATA_002_2023.dbo.PurSettleVouch a
    //	left join UFDATA_002_2023.dbo.PurSettleVouchs b on	a.psvid = b.psvid;
    /**
     * 采购结算单子表标识
     */
    @ExcelProperty("采购结算单子表标识")
    private String id;
    /**
     * 采购结算单主表标识
     */
    @ExcelProperty("采购结算单主表标识")
    private String psvid;
    /**
     * 采购结算单号
     */
    @ExcelProperty("采购结算单号")
    private String cSVCode;
    /**
     * 单据日期
     */
    @ExcelProperty("单据日期")
    private String dSVDate;
    /**
     * 业务类型
     */
    @ExcelProperty("业务类型")
    private String cBusType;
    /**
     * 供应商编码
     */
    @ExcelProperty("供应商编码")
    private String cVenCode;
    /**
     * 表头税率
     */
    @ExcelProperty("表头税率")
    private String iTaxRate;
    /**
     * 制单人
     */
    @ExcelProperty("制单人")
    private String cMaker;
    /**
     * 仓库编码
     */
    @ExcelProperty("仓库编码")
    private String cWhCode;
    /**
     * 存货编码
     */
    @ExcelProperty("存货编码")
    private String cInvCode;
    /**
     * 结算数量
     */
    @ExcelProperty("结算数量")
    private String iSVQuantity;
    /**
     * 结算单价
     */
    @ExcelProperty("结算单价")
    private String iSVCost;
    /**
     * 结算金额
     */
    @ExcelProperty("结算金额")
    private String iSVPrice;
    /**
     * 税额
     */
    @ExcelProperty("税额")
    private String iTax;
    /**
     * 本币价税合计
     */
    @ExcelProperty("本币价税合计")
    private String iSum;
    /**
     * 对应入库单号
     */
    @ExcelProperty("对应入库单号")
    private String cPIVCode;
    /**
     * 采购发票号
     */
    @ExcelProperty("采购发票号")
    private String cBillCode;
    /**
     * 公司别
     */
    @ExcelProperty("公司别")
    private String company;
}

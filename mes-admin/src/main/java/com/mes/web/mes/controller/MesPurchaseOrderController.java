package com.mes.web.mes.controller;

import java.util.List;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import cn.dev33.satoken.annotation.SaIgnore;
import lombok.RequiredArgsConstructor;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import com.mes.common.annotation.RepeatSubmit;
import com.mes.common.annotation.Log;
import com.mes.common.core.controller.BaseController;
import com.mes.common.core.domain.PageQuery;
import com.mes.common.core.domain.R;
import com.mes.common.core.validate.AddGroup;
import com.mes.common.core.validate.EditGroup;
import com.mes.common.core.validate.QueryGroup;
import com.mes.common.enums.BusinessType;
import com.mes.common.utils.poi.ExcelUtil;
import com.mes.web.mes.entity.vo.MesPurchaseOrderVo;
import com.mes.web.mes.entity.bo.MesPurchaseOrderBo;
import com.mes.web.mes.service.IMesPurchaseOrderService;
import com.mes.common.core.page.TableDataInfo;

/**
 * 采购订单
 *
 * @author lixing
 * @date 2024-03-19
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/mes/purchaseOrder")
public class MesPurchaseOrderController extends BaseController {

    private final IMesPurchaseOrderService iMesPurchaseOrderService;

    /**
     * 查询采购订单列表
     */
    @SaCheckPermission("mes:purchaseOrder:list")
    @GetMapping("/list")
    public TableDataInfo<MesPurchaseOrderVo> list(MesPurchaseOrderBo bo, PageQuery pageQuery) {
        return iMesPurchaseOrderService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出采购订单列表
     */
    @SaCheckPermission("mes:purchaseOrder:export")
    @Log(title = "采购订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MesPurchaseOrderBo bo, HttpServletResponse response) {
        List<MesPurchaseOrderVo> list = iMesPurchaseOrderService.queryList(bo);
        ExcelUtil.exportExcel(list, "采购订单", MesPurchaseOrderVo.class, response);
    }

    /**
     * 获取采购订单详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("mes:purchaseOrder:query")
    @GetMapping("/{id}")
    public R<MesPurchaseOrderVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iMesPurchaseOrderService.queryById(id));
    }

    /**
     * 新增采购订单
     */
    @SaCheckPermission("mes:purchaseOrder:add")
    @Log(title = "采购订单", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MesPurchaseOrderBo bo) {
        return toAjax(iMesPurchaseOrderService.insertByBo(bo));
    }

    /**
     * 修改采购订单
     */
    @SaCheckPermission("mes:purchaseOrder:edit")
    @Log(title = "采购订单", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MesPurchaseOrderBo bo) {
        return toAjax(iMesPurchaseOrderService.updateByBo(bo));
    }

    /**
     * 删除采购订单
     *
     * @param ids 主键串
     */
    @SaCheckPermission("mes:purchaseOrder:remove")
    @Log(title = "采购订单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iMesPurchaseOrderService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}

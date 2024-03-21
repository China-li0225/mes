package com.mes.web.mes.controller;

import java.util.List;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

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
import com.mes.web.mes.entity.vo.MesPurchaseDetilsVo;
import com.mes.web.mes.entity.bo.MesPurchaseDetilsBo;
import com.mes.web.mes.service.IMesPurchaseDetilsService;
import com.mes.common.core.page.TableDataInfo;

/**
 * 采购订单明细
 *
 * @author lixing
 * @date 2024-03-21
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/mes/purchaseDetils")
public class MesPurchaseDetilsController extends BaseController {

    private final IMesPurchaseDetilsService iMesPurchaseDetilsService;

    /**
     * 查询采购订单明细列表
     */
    @SaCheckPermission("mes:purchaseDetils:list")
    @GetMapping("/list")
    public TableDataInfo<MesPurchaseDetilsVo> list(MesPurchaseDetilsBo bo, PageQuery pageQuery) {
        return iMesPurchaseDetilsService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出采购订单明细列表
     */
    @SaCheckPermission("mes:purchaseDetils:export")
    @Log(title = "采购订单明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MesPurchaseDetilsBo bo, HttpServletResponse response) {
        List<MesPurchaseDetilsVo> list = iMesPurchaseDetilsService.queryList(bo);
        ExcelUtil.exportExcel(list, "采购订单明细", MesPurchaseDetilsVo.class, response);
    }

    /**
     * 获取采购订单明细详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("mes:purchaseDetils:query")
    @GetMapping("/{id}")
    public R<MesPurchaseDetilsVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iMesPurchaseDetilsService.queryById(id));
    }

    /**
     * 新增采购订单明细
     */
    @SaCheckPermission("mes:purchaseDetils:add")
    @Log(title = "采购订单明细", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MesPurchaseDetilsBo bo) {
        return toAjax(iMesPurchaseDetilsService.insertByBo(bo));
    }

    /**
     * 修改采购订单明细
     */
    @SaCheckPermission("mes:purchaseDetils:edit")
    @Log(title = "采购订单明细", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MesPurchaseDetilsBo bo) {
        return toAjax(iMesPurchaseDetilsService.updateByBo(bo));
    }

    /**
     * 删除采购订单明细
     *
     * @param ids 主键串
     */
    @SaCheckPermission("mes:purchaseDetils:remove")
    @Log(title = "采购订单明细", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iMesPurchaseDetilsService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}

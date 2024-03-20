package com.mes.web.mes.service;

import com.mes.web.mes.entity.MesPurchaseOrder;
import com.mes.web.mes.entity.vo.MesPurchaseOrderVo;
import com.mes.web.mes.entity.bo.MesPurchaseOrderBo;
import com.mes.common.core.page.TableDataInfo;
import com.mes.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 采购订单Service接口
 *
 * @author lixing
 * @date 2024-03-19
 */
public interface IMesPurchaseOrderService {

    /**
     * 查询采购订单
     */
    MesPurchaseOrderVo queryById(Long id);

    /**
     * 查询采购订单列表
     */
    TableDataInfo<MesPurchaseOrderVo> queryPageList(MesPurchaseOrderBo bo, PageQuery pageQuery);

    /**
     * 查询采购订单列表
     */
    List<MesPurchaseOrderVo> queryList(MesPurchaseOrderBo bo);

    /**
     * 新增采购订单
     */
    Boolean insertByBo(MesPurchaseOrderBo bo);

    /**
     * 修改采购订单
     */
    Boolean updateByBo(MesPurchaseOrderBo bo);

    /**
     * 校验并批量删除采购订单信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

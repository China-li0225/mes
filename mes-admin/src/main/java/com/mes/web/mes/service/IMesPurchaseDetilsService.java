package com.mes.web.mes.service;

import com.mes.web.mes.entity.MesPurchaseDetils;
import com.mes.web.mes.entity.vo.MesPurchaseDetilsVo;
import com.mes.web.mes.entity.bo.MesPurchaseDetilsBo;
import com.mes.common.core.page.TableDataInfo;
import com.mes.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 采购订单明细Service接口
 *
 * @author lixing
 * @date 2024-03-21
 */
public interface IMesPurchaseDetilsService {

    /**
     * 查询采购订单明细
     */
    MesPurchaseDetilsVo queryById(Long id);

    /**
     * 查询采购订单明细列表
     */
    TableDataInfo<MesPurchaseDetilsVo> queryPageList(MesPurchaseDetilsBo bo, PageQuery pageQuery);

    /**
     * 查询采购订单明细列表
     */
    List<MesPurchaseDetilsVo> queryList(MesPurchaseDetilsBo bo);

    /**
     * 新增采购订单明细
     */
    Boolean insertByBo(MesPurchaseDetilsBo bo);

    /**
     * 修改采购订单明细
     */
    Boolean updateByBo(MesPurchaseDetilsBo bo);

    /**
     * 校验并批量删除采购订单明细信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

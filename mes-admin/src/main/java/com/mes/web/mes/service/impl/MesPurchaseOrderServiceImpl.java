package com.mes.web.mes.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.mes.common.utils.StringUtils;
import com.mes.common.core.page.TableDataInfo;
import com.mes.common.core.domain.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mes.web.mes.entity.bo.MesPurchaseOrderBo;
import com.mes.web.mes.entity.vo.MesPurchaseOrderVo;
import com.mes.web.mes.entity.MesPurchaseOrder;
import com.mes.web.mes.mapper.MesPurchaseOrderMapper;
import com.mes.web.mes.service.IMesPurchaseOrderService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 采购订单Service业务层处理
 *
 * @author lixing
 * @date 2024-03-19
 */
@RequiredArgsConstructor
@Service
public class MesPurchaseOrderServiceImpl implements IMesPurchaseOrderService {

    private final MesPurchaseOrderMapper baseMapper;

    /**
     * 查询采购订单
     */
    @Override
    public MesPurchaseOrderVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询采购订单列表
     */
    @Override
    public TableDataInfo<MesPurchaseOrderVo> queryPageList(MesPurchaseOrderBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MesPurchaseOrder> lqw = buildQueryWrapper(bo);
        Page<MesPurchaseOrderVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询采购订单列表
     */
    @Override
    public List<MesPurchaseOrderVo> queryList(MesPurchaseOrderBo bo) {
        LambdaQueryWrapper<MesPurchaseOrder> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MesPurchaseOrder> buildQueryWrapper(MesPurchaseOrderBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MesPurchaseOrder> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getPurchaseNo()), MesPurchaseOrder::getPurchaseNo, bo.getPurchaseNo());
        lqw.eq(StringUtils.isNotBlank(bo.getPurchaseType()), MesPurchaseOrder::getPurchaseType, bo.getPurchaseType());
        lqw.eq(StringUtils.isNotBlank(bo.getPurchaseState()), MesPurchaseOrder::getPurchaseState, bo.getPurchaseState());
        lqw.eq(StringUtils.isNotBlank(bo.getStartDept()), MesPurchaseOrder::getStartDept, bo.getStartDept());
        lqw.eq(bo.getStartDeptId() != null, MesPurchaseOrder::getStartDeptId, bo.getStartDeptId());
        return lqw;
    }

    /**
     * 新增采购订单
     */
    @Override
    public Boolean insertByBo(MesPurchaseOrderBo bo) {
        MesPurchaseOrder add = BeanUtil.toBean(bo, MesPurchaseOrder.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改采购订单
     */
    @Override
    public Boolean updateByBo(MesPurchaseOrderBo bo) {
        MesPurchaseOrder update = BeanUtil.toBean(bo, MesPurchaseOrder.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MesPurchaseOrder entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除采购订单
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

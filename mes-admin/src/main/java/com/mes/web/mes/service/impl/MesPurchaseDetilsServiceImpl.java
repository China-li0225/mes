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
import com.mes.web.mes.entity.bo.MesPurchaseDetilsBo;
import com.mes.web.mes.entity.vo.MesPurchaseDetilsVo;
import com.mes.web.mes.entity.MesPurchaseDetils;
import com.mes.web.mes.mapper.MesPurchaseDetilsMapper;
import com.mes.web.mes.service.IMesPurchaseDetilsService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 采购订单明细Service业务层处理
 *
 * @author lixing
 * @date 2024-03-21
 */
@RequiredArgsConstructor
@Service
public class MesPurchaseDetilsServiceImpl implements IMesPurchaseDetilsService {

    private final MesPurchaseDetilsMapper baseMapper;

    /**
     * 查询采购订单明细
     */
    @Override
    public MesPurchaseDetilsVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询采购订单明细列表
     */
    @Override
    public TableDataInfo<MesPurchaseDetilsVo> queryPageList(MesPurchaseDetilsBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MesPurchaseDetils> lqw = buildQueryWrapper(bo);
        Page<MesPurchaseDetilsVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询采购订单明细列表
     */
    @Override
    public List<MesPurchaseDetilsVo> queryList(MesPurchaseDetilsBo bo) {
        LambdaQueryWrapper<MesPurchaseDetils> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MesPurchaseDetils> buildQueryWrapper(MesPurchaseDetilsBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MesPurchaseDetils> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getId() != null, MesPurchaseDetils::getId, bo.getId());
        lqw.eq(StringUtils.isNotBlank(bo.getPurchaseNo()), MesPurchaseDetils::getPurchaseNo, bo.getPurchaseNo());
        lqw.eq(StringUtils.isNotBlank(bo.getMatId()), MesPurchaseDetils::getMatId, bo.getMatId());
        lqw.like(StringUtils.isNotBlank(bo.getMatName()), MesPurchaseDetils::getMatName, bo.getMatName());
        lqw.eq(StringUtils.isNotBlank(bo.getMatType()), MesPurchaseDetils::getMatType, bo.getMatType());
        lqw.eq(StringUtils.isNotBlank(bo.getMatTypeNo()), MesPurchaseDetils::getMatTypeNo, bo.getMatTypeNo());
        lqw.eq(StringUtils.isNotBlank(bo.getModel()), MesPurchaseDetils::getModel, bo.getModel());
        lqw.eq(StringUtils.isNotBlank(bo.getColor()), MesPurchaseDetils::getColor, bo.getColor());
        lqw.eq(bo.getWeight() != null, MesPurchaseDetils::getWeight, bo.getWeight());
        lqw.eq(bo.getLenth() != null, MesPurchaseDetils::getLenth, bo.getLenth());
        lqw.eq(bo.getNum() != null, MesPurchaseDetils::getNum, bo.getNum());
        lqw.eq(StringUtils.isNotBlank(bo.getUnit()), MesPurchaseDetils::getUnit, bo.getUnit());
        lqw.eq(bo.getPrices() != null, MesPurchaseDetils::getPrices, bo.getPrices());
        lqw.eq(bo.getTaxFreePrice() != null, MesPurchaseDetils::getTaxFreePrice, bo.getTaxFreePrice());
        lqw.eq(bo.getSumPricesTax() != null, MesPurchaseDetils::getSumPricesTax, bo.getSumPricesTax());
        lqw.eq(StringUtils.isNotBlank(bo.getRemark()), MesPurchaseDetils::getRemark, bo.getRemark());
        return lqw;
    }

    /**
     * 新增采购订单明细
     */
    @Override
    public Boolean insertByBo(MesPurchaseDetilsBo bo) {
        MesPurchaseDetils add = BeanUtil.toBean(bo, MesPurchaseDetils.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改采购订单明细
     */
    @Override
    public Boolean updateByBo(MesPurchaseDetilsBo bo) {
        MesPurchaseDetils update = BeanUtil.toBean(bo, MesPurchaseDetils.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MesPurchaseDetils entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除采购订单明细
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

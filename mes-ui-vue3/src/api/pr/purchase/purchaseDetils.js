import request from '@/utils/request'

// 查询采购订单明细列表
export function listPurchaseDetils(query) {
  return request({
    url: '/mes/purchaseDetils/list',
    method: 'get',
    params: query
  })
}

// 查询采购订单明细详细
export function getPurchaseDetils(id) {
  return request({
    url: '/mes/purchaseDetils/' + id,
    method: 'get'
  })
}

// 新增采购订单明细
export function addPurchaseDetils(data) {
  return request({
    url: '/mes/purchaseDetils',
    method: 'post',
    data: data
  })
}

// 修改采购订单明细
export function updatePurchaseDetils(data) {
  return request({
    url: '/mes/purchaseDetils',
    method: 'put',
    data: data
  })
}

// 删除采购订单明细
export function delPurchaseDetils(id) {
  return request({
    url: '/mes/purchaseDetils/' + id,
    method: 'delete'
  })
}

import request from '@/utils/request'

// 查询采购订单列表
export function listPurchaseOrder(query) {
  return request({
    url: '/mes/purchaseOrder/list',
    method: 'get',
    params: query
  })
}

// 查询采购订单详细
export function getPurchaseOrder(id) {
  return request({
    url: '/mes/purchaseOrder/' + id,
    method: 'get'
  })
}

// 新增采购订单
export function addPurchaseOrder(data) {
  return request({
    url: '/mes/purchaseOrder',
    method: 'post',
    data: data
  })
}

// 修改采购订单
export function updatePurchaseOrder(data) {
  return request({
    url: '/mes/purchaseOrder',
    method: 'put',
    data: data
  })
}

// 删除采购订单
export function delPurchaseOrder(id) {
  return request({
    url: '/mes/purchaseOrder/' + id,
    method: 'delete'
  })
}

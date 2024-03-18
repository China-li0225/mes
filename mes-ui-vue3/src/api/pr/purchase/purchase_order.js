import request from '@/utils/request'

export const getRouters = (username, password, code, uuid) => {
  const data = {
    username,
    password,
    code,
    uuid
  }
  return request({
    url: '/getRouters',
    method: 'get',
    data: data
  })
}

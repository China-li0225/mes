import request from '@/utils/request'

export function loginfinereport(username, password) {
  const data = {
    username,
    password,
  }
  return request({
    url: '/finereport/login',
    method: 'get',
    data: data
  })
}

export function getLoginUrl(username) {//后台单点登录
  return request({
    url: '/finereport/fineLogin',
    method: 'get',
    params: username,
  })
}

export function getFineAuthToken(username) {//前台单点登录获取token
  return request({
    url: '/finereport/fineAuthToken',
    method: 'get',
    params: username,
  })
}

export function getDirectory(asstoken) {//决策系统目录请求
  sessionStorage.setItem("Authorization", "Bearer " + asstoken);
  return request({
    //http://localhost:8075/webroot/decision/directory
    url: '/webroot/decision/directory',
    method: 'get',
  })
}

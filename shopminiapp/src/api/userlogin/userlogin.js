import request from '@/utils/request'
import * as url from "url";
export function  wxlogin(){
    const data = {
        provider(){}
    }
    return  request({
        url: "",//请求地址
        method: "get",//请求类型
        data: data //请求数据
    })
}

//工具方法
function  provider(){
    uni.getProvider({
        service: 'oauth',
        success: function (res) {
            console.log(res.provider)
            if (~res.provider.indexOf('weixin')) {
                uni.login({
                    provider: 'weixin',
                    success: function (loginRes) {
                        console.log(JSON.stringify(loginRes));
                        return loginRes;
                    }
                });
            }
        }
    })
}

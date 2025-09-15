package com.mes.common.utils.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * 对象转换为JSON
 * ClassName: ObjectTOJSON <br/>
 * Description: <br/>
 * date: 2024/9/14 14:29<br/>
 *
 * @author lixing<br />
 * @since JDK
 */
public class ObjectTOJSON {
    public static JSONObject stringTojson(String s){
        return JSONObject.parseObject(s);
    }

    public static JSONObject mapTojson(Map s){
        return JSONObject.parseObject(JSON.toJSONString(s));
    }

    public static JSONObject objectTojson(Object s){
        return JSONObject.parseObject(JSON.toJSONString(s));
    }

}

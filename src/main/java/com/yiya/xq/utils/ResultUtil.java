package com.yiya.xq.utils;

import com.yiya.xq.bean.ResultBean;

public class ResultUtil {


    //当正确时返回的值
    public static ResultBean success(Object data){
        ResultBean result = new ResultBean();
        result.setCode(200);
        result.setMsg("OK");
        result.setData(data);
        return result;
    }

    //当正确时返回的值
    public static ResultBean success(Object data,String msg){
        ResultBean result = new ResultBean();
        result.setCode(200);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static ResultBean success(){
        return success(null);
    }

    //当错误时返回的值
    public static ResultBean error(int code,String msg){
        ResultBean result = new ResultBean();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
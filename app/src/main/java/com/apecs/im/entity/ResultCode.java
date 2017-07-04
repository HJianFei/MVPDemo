package com.apecs.im.entity;

import java.io.Serializable;

/**
 * Created by HJF on 2017/6/30.
 * 描述：
 */

public class ResultCode implements Serializable {

    public int code;
    public String msg;

    public ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultCode() {
    }

    @Override
    public String toString() {
        return "ResultCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}

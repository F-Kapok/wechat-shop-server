package com.fans.enums;

import com.fans.common.CodeEnum;

/**
 * enumName: LoginType
 *
 * @author k
 * @version 1.0
 * @description 登录类型
 * @date 2020-05-31 21:06
 **/
public enum LoginType implements CodeEnum {
    /**
     *
     */
    USER_WX(0, "微信登录"),
    USER_EMAIL(1, "邮箱登录");

    private final Integer code;
    private final String desc;

    LoginType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}

package com.seven.boot.common.exception.user;

import com.seven.boot.common.exception.BaseException;

/**
 * 用户信息异常
 */
public class UserException extends BaseException {

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }
}

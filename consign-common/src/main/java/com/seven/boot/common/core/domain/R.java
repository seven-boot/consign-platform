package com.seven.boot.common.core.domain;

import java.util.HashMap;
import java.util.Objects;

/**
 * 接口返回结果
 *
 * @author QH
 */
public class R extends HashMap<String, Object> {

    private static final long serialVersionUID = 8717998556327796155L;

    /** 状态码 */
    public static final String CODE_TAG = "code";

    /** 返回内容 */
    public static final String MSG_TAG = "msg";

    /** 数据对象 */
    public static final String DATA_TAG = "data";

    /**
     * 初始化一个新创建的 R 对象
     *
     * @param code 状态码
     * @param msg 返回内容
     * @param data 数据对象
     */
    public R(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (Objects.nonNull(data)) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg 返回内容
     * @return 警告消息
     */
    public static R error(int code, String msg) {
        return new R(code, msg, null);
    }
}

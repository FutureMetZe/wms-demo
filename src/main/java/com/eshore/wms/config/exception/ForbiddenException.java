package com.eshore.wms.config.exception;
/**
 * 处理无权限操作的异常
 * @author eshore
 * @createDate 2018年10月10日
 */
public class ForbiddenException extends BaseException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ForbiddenException(String message) {
        super(message);
    }

}

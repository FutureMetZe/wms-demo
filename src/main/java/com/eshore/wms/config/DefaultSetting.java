package com.eshore.wms.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 默认配置类
 *
 * @author lizj
 * @date 2018/9/4
 */
public final class DefaultSetting {

    private static Logger logger = LoggerFactory.getLogger(DefaultSetting.class);

    /**
     * 签名key
     */
    public static final String SIGNING_KEY = "spring-security-@Jwt!&Secret^#";

    /**
     * 需要放行的URL
     */
    public static final String[] AUTH_WHITELIST = {
            "/wms/user/signIn",
            "/portal/link/**"
    };

    /**
     * 配置过期时间(这里为了方便测试设置了10天的过期时间)
     */
    private static final Integer EXPIRATION_TIME = 10 * 24 * 60 * 60 * 1000;
    public static Long getExpirationTime() {
        return System.currentTimeMillis() + EXPIRATION_TIME;
    }

}

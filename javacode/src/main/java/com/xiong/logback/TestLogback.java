package com.xiong.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ：xiongcong
 * @date ：Created in 2019/12/30 19:58
 * @description：
 * @modified By：
 * @version: $
 */
public class TestLogback {

    private static final Logger logger = LoggerFactory.getLogger(TestLogback.class);

    public static void main(String[] args) {

        logger.error("logback error测试");
        logger.info("logback info测试");
        logger.debug("logback debug测试");
    }
}

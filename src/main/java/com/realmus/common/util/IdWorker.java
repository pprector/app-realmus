package com.realmus.common.util;

import java.util.Date;

import static org.apache.commons.lang.time.DateFormatUtils.format;

/**
 * @author hkpeng
 * @date 2021/12/24 - 14:36
 */
public class IdWorker {
    /**
     * 起始Id
     */
    private static Integer startNumber = 1000000;

    public static synchronized String getNextId() {
        String time = format(new Date(), "yyyyMMdd");
        return time + ++startNumber;
    }

    /**
     * main 测试类
     *
     * @param args
     */
    public static void main(String[] args) {

        for (int i = 0; i < 22; i++) {
            new Thread() {
                public void run() {
                    System.out.println(IdWorker.getNextId());
                }
            }.start();
        }


    }
}

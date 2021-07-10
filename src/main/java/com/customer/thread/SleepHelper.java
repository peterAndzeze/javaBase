package com.customer.thread;

import java.util.concurrent.TimeUnit;

/**
 * @className: SleepHelper
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/7/7
 **/
public class SleepHelper {
    public static void sleepSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepMilli(int i) {
        try {
            TimeUnit.MILLISECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

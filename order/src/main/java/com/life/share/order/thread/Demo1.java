package com.life.share.order.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Demo1 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                log.debug("开始打断");
                lock.lockInterruptibly();
                log.debug("打断当前线程");
            } catch (InterruptedException e) {
                log.debug("异常打断");
                e.printStackTrace();
            }
        });
        try {
            lock.lock();
            t1.start();
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            log.error("当前线程已被打断");
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

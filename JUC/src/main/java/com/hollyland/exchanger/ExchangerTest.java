package com.hollyland.exchanger;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Exchanger;

/**
 * @className: ExchangerTest
 * @author: Lesuto
 * @date: 2024/1/10/11:57
 * @description TODO
 **/
@Slf4j
public class ExchangerTest {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();

        Thread boy = new Thread(() -> {
            log.info("你开始准备礼物...");
            try {
                // 模拟准备礼物的时间
                Thread.sleep(5000);

                String gift = "礼物A";
                log.info("你送了礼物:{}", gift);
                String recGift = exchanger.exchange(gift);
                log.info("你收到了礼物:{}", recGift);
            } catch (InterruptedException e) {
                log.error("线程异常:{}", e.getMessage());
                e.printStackTrace();
            }
        });

        Thread girl = new Thread(() -> {
            log.info("我开始准备礼物...");
            try {
                // 模拟准备礼物的时间
                Thread.sleep(5000);
                String gift = "礼物B";
                log.info("我送了礼物:{}", gift);
                String recGift = exchanger.exchange(gift);
                log.info("我收到了礼物:{}", recGift);
            } catch (InterruptedException e) {
                log.error("线程异常:{}", e.getMessage());
                e.printStackTrace();
            }
        });

        boy.start();
        girl.start();

        boy.join();
        girl.join();
    }
}

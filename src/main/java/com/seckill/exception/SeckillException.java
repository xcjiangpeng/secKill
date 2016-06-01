package com.seckill.exception;

/**
 * 秒杀相关通用异常
 * Created by jp on 2016/5/15.
 */
public class SeckillException extends RuntimeException {
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}

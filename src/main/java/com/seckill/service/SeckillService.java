package com.seckill.service;

import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;
import com.seckill.exception.SeckillException;

import java.util.List;

/**
 * Created by jp on 2016/5/15.
 *
 */
public interface SeckillService {
    List<Seckill> getSeckillList();

    Seckill getById(long seckillId);

    /**
     * 秒杀是否开启， 是则输出接口地址， 否则输出系统时间和秒杀时间
     */
    Exposer exportSeckillUrl(long seckillId);

    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException;


}

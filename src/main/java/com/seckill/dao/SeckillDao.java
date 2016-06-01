package com.seckill.dao;

import com.seckill.entity.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by jp on 2016/5/9.
 *
 */
public interface SeckillDao {
    /**
     * 减库存
     * @param seckillId dd
     * @param killDate dd
     * @return dd
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killDate") Date killDate);


    /**
     *
     * @param seckillId dd
     * @return dd
     */
    Seckill queryById(long seckillId);

    /**
     *
     * @param offset dd
     * @param limit dd
     * @return dd
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}

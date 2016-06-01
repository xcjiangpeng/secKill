package com.seckill.dao;

import com.seckill.entity.SuccessKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by jp on 2016/5/12.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() throws Exception {
        long id = 1000L;
        long phone = 122151241L;
        int i = successKilledDao.insertSuccessKilled(id, phone);
        System.out.println(i);
    }

    @Test
    public void queryByIdWidthSeckill() throws Exception {
        SuccessKilled successKilled = successKilledDao.queryByIdWidthSeckill(1000L, 122151241L);
        System.out.println(successKilled);

    }

}
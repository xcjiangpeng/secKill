package com.seckill.service.impl;

import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;
import com.seckill.exception.RepeatKillException;
import com.seckill.exception.SeckillCloseException;
import com.seckill.service.SeckillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by jp on 2016/5/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class SeckillServiceImplTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> seckillList = seckillService.getSeckillList();
        logger.info("seckillList-->{}", seckillList);
    }

    @Test
    public void getById() throws Exception {
        Seckill seckill = seckillService.getById(1000L);
        logger.info("seckill-->{}", seckill);

    }

    /**
     * 整合逻辑
     * @throws Exception
     */
    @Test
    public void testSeckillLogic() throws Exception {
        long id = 1001;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            logger.info("exposer-->{}", exposer);
            long phone = 12315464421L;
            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, exposer.getMd5());
                logger.info("seckillExecution-->{}", seckillExecution);
            } catch (RepeatKillException | SeckillCloseException e) {
                logger.error(e.getMessage());
            }
        } else {
            logger.warn("exposer-->{}", exposer);
        }
        //    md5=63d4af6d5223fc9f9dc38a00453559be
    }

    @Test
    public void exportSeckillUrl() throws Exception {
        Exposer exposer = seckillService.exportSeckillUrl(1000L);
        logger.info("exposer-->{}", exposer);
        //    md5=63d4af6d5223fc9f9dc38a00453559be
    }

    @Test
    public void executeSeckill() throws Exception {

        try {
            SeckillExecution seckillExecution = seckillService.executeSeckill(1000L, 13215454L, "63d4af6d5223fc9f9dc38a00453559be");
            logger.info("seckillExecution-->{}", seckillExecution);
        } catch (RepeatKillException | SeckillCloseException e) {
            logger.error(e.getMessage());
        }

    }


}
package pers.wmx.springbootfreemarkerdemo.job;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangmingxin03
 * Created on 2021-12-28
 */
@Component
@JobHandler("mySimpleJob")
@Slf4j
public class MySimpleJob extends IJobHandler {
    private final AtomicInteger counter = new AtomicInteger();

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        log.info("MySimpleJob execute:{}", counter.incrementAndGet());
        return ReturnT.SUCCESS;
    }
}

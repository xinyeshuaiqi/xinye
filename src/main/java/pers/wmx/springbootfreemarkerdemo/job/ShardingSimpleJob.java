package pers.wmx.springbootfreemarkerdemo.job;

import org.springframework.context.annotation.Configuration;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.util.ShardingUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangmingxin03
 * Created on 2021-12-31
 */
@Configuration
@JobHandler("shardingSimpleJob")
@Slf4j
public class ShardingSimpleJob extends IJobHandler {
    public ReturnT<String> execute(String param) throws Exception {
        ShardingUtil.ShardingVO shardingVO = ShardingUtil.getShardingVo();
        log.info("分片参数：当前分片序号 = {}, 总分片数 = {}",
                shardingVO.getIndex(), shardingVO.getTotal());

        return ReturnT.SUCCESS;
    }

}

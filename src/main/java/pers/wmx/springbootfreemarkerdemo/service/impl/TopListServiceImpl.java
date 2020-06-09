package pers.wmx.springbootfreemarkerdemo.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Service;

import pers.wmx.springbootfreemarkerdemo.service.TopListService;

/**
 * 简单榜单实现
 *
 * @author: wangmingxin03
 * @date: 2020-06-09
 */
@Service
public class TopListServiceImpl implements TopListService {
    //榜单大小 10  即取榜单前十
    private static final Integer TOP_LIST_SIZE = 10;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void saveUserScore(long seasonId, long userId, long score) {
        String key = "topList_" + seasonId;
        stringRedisTemplate.opsForZSet().add(key, String.valueOf(userId), score);

        //手动处理zset，避免大key  把积分第11名到最后一名移除，保留前十名
        stringRedisTemplate.opsForZSet().removeRange(key, 0, -TOP_LIST_SIZE - 1);
    }

    @Override
    public List<Long> getTopList(long seasonId) {
        String key = "topList_" + seasonId;
        Set<TypedTuple<String>> tuples = stringRedisTemplate.opsForZSet()
                .reverseRangeByScoreWithScores(key, 0, Double.POSITIVE_INFINITY, 0, TOP_LIST_SIZE);

        return tuples.stream()
                .map(tuple -> Long.parseLong(Objects.requireNonNull(tuple.getValue())))
                .collect(Collectors.toList());
    }
}

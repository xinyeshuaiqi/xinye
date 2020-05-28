package pers.wmx.springbootfreemarkerdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import pers.wmx.springbootfreemarkerdemo.dao.UserScoreMapper;
import pers.wmx.springbootfreemarkerdemo.entity.UserScore;

/**
 * @author: wangmingxin03
 * @date: 2020-05-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CreateUserDataTest {

    @Autowired
    private UserScoreMapper userScoreMapper;

    private final Random random = new Random();

    @Test
    public void test() {
        List<UserScore> userScoreList = new ArrayList<>();
        IntStream.range(0, 50000).forEach(index -> {
            UserScore userScore = new UserScore();
            userScore.setSeasonId(1);
            userScore.setUserId(index + 1);
            userScore.setScore(random.nextInt(10000));
            userScore.setCreateTime(System.currentTimeMillis());
            int updateTime = random.nextInt(100000);
            userScore.setUpdateTime(updateTime);
            userScore.setInverseUpdateTime(Long.MIN_VALUE - updateTime); //逆序更新时间 占位 排序使用
            userScoreList.add(userScore);
        });

        userScoreMapper.batchInsert2(userScoreList);

    }

}

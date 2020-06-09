package pers.wmx.springbootfreemarkerdemo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import pers.wmx.springbootfreemarkerdemo.service.TopListService;

/**
 * @author: wangmingxin03
 * @date: 2020-06-09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TopListTest {
    @Autowired
    private TopListService topListService;

    @Test
    public void getTopList(){
        //mock数据
        topListService.saveUserScore(1, 1, 10);
        topListService.saveUserScore(1, 2, 9);
        topListService.saveUserScore(1, 3, 240);
        topListService.saveUserScore(1, 4, 240);
        topListService.saveUserScore(1, 5, 999);
        topListService.saveUserScore(1, 6, 1);
        topListService.saveUserScore(1, 7, 5);
        topListService.saveUserScore(1, 8, 110);
        topListService.saveUserScore(1, 9, 240);
        topListService.saveUserScore(1, 10, 36);
        topListService.saveUserScore(1, 11, 24);
        topListService.saveUserScore(1, 12, 19);

        List<Long> topList = topListService.getTopList(1);
        System.out.println(topList);
    }
}

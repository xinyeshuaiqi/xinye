package pers.wmx.springbootfreemarkerdemo.service;

import java.util.List;

/**
 * @author: wangmingxin03
 * @date: 2020-06-09
 */
public interface TopListService {
    //seasonId 表示赛季
    void saveUserScore(long seasonId, long userId, long score);

    //获取当前赛季榜单
    List<Long> getTopList(long seasonId);
}

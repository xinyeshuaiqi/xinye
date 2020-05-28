package pers.wmx.springbootfreemarkerdemo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import pers.wmx.springbootfreemarkerdemo.entity.UserScore;

/**
 *
 * @author: wangmingxin03
 * @date: 2020-05-28
 */
@Mapper
public interface UserScoreMapper {

    @Insert({
            "<script>",
            "insert into user_score1(season_id, user_id, score, create_time, update_time) ",
            "values ",
            "<foreach collection='userScoreList' item='item' index='index' separator=','>",
            "(#{item.seasonId}, #{item.userId}, #{item.score}, #{item.createTime}, #{item.updateTime})",
            "</foreach>",
            "</script>"
    })
    int batchInsert1(@Param("userScoreList") List<UserScore> userScoreList);

    @Insert({
            "<script>",
            "insert into user_score2(season_id, user_id, score, create_time, update_time, inverse_update_time) ",
            "values ",
            "<foreach collection='userScoreList' item='item' index='index' separator=','>",
            "(#{item.seasonId}, #{item.userId}, #{item.score}, #{item.createTime}, #{item.updateTime}, #{item.inverseUpdateTime})",
            "</foreach>",
            "</script>"
    })
    int batchInsert2(@Param("userScoreList") List<UserScore> userScoreList);

}

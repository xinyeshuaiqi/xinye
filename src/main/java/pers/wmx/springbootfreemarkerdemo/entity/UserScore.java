package pers.wmx.springbootfreemarkerdemo.entity;

/**
 * @author: wangmingxin03
 * @date: 2020-05-28
 */
public class UserScore {
    private long seasonId;

    private long userId;

    private long score;

    private long createTime;

    private long updateTime;

    private long inverseUpdateTime;

    public long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(long seasonId) {
        this.seasonId = seasonId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public long getInverseUpdateTime() {
        return inverseUpdateTime;
    }

    public void setInverseUpdateTime(long inverseUpdateTime) {
        this.inverseUpdateTime = inverseUpdateTime;
    }
}

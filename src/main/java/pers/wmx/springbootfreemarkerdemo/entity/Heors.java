package pers.wmx.springbootfreemarkerdemo.entity;

/**
 * 对象创建后禁止修改
 *
 * @author: wangmingxin03
 * @date: 2020-05-25
 */
public class Heors {

    private final long heorId;

    private final String heorName;

    private final String skill;

    public Heors(long heorId, String heorName, String skill) {
        this.heorId = heorId;
        this.heorName = heorName;
        this.skill = skill;
    }

    public long getHeorId() {
        return heorId;
    }

    public String getHeorName() {
        return heorName;
    }

    public String getSkill() {
        return skill;
    }
}

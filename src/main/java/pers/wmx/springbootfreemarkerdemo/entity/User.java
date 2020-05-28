package pers.wmx.springbootfreemarkerdemo.entity;

/**
 * @author: wangmingxin03
 * @date: 2020-05-28
 */
public class User {

    private Long userId;

    private String userName;

    private Integer age;

    private Integer sex;

    private String description;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

      //不想展示age
//    public Integer getAge() {
//        return age;
//    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    //response body 根据get方法解析
    public String getPersonalDescription() {
        return getUserName() + "个人介绍 : " + description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package pers.wmx.springbootfreemarkerdemo.json;

/**
 * @author wangmingxin03
 * Created on 2022-08-01
 */
public class MyBean {
    public String id;
    public String name;
    public Integer score;

    @Override
    public String toString() {
        return "MyBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

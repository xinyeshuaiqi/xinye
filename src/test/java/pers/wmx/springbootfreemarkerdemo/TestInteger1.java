package pers.wmx.springbootfreemarkerdemo;

/**
 * @author: wangmingxin03
 * @date: 2020-07-06
 */
public class TestInteger1 {
    public static void main(String[] args) {

        Integer i = 200;

        Integer j = 200;

        System.out.println(i == j);         //false
        System.out.println(i.equals(j));    //true
    }
}

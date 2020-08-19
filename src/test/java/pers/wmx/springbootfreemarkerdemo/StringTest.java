package pers.wmx.springbootfreemarkerdemo;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: wangmingxin03
 * @date: 2020-05-29
 */
public class StringTest {


//    如果想要将已有的字符串对象的引用加入到常量池中，可以使用 String 类中的 internal() 方法。
//    internal() 方法会在字符串常量池中寻找是否存在相同字符串的对象引用。
//    如果存在，就会返回常量池中的引用。
//    如果不存在，就将这个字符串对象的引用加入到字符串常量池中。
    public static void main(String[] args) {
        String one = "something";
        String two = new String("something");
        String three = two.intern();

        System.out.println(one == two); // false
        System.out.println(two == three); // false
        System.out.println(one == three); // true


        String str1 = "tr";
        String str2 = "ing";

        String str3 = "str" + "ing"; // 编译时拼接，保存在字符串常量池中。
        String str4 = str1 + str2; // 运行时拼接，创建一个新的字符串对象。
        System.out.println(str3 == str4); // false

        String str5 = "string";
        System.out.println(str3 == str5); // true


        boolean contains = StringUtils.contains(str5, str1);
        System.out.println(contains);

    }
}

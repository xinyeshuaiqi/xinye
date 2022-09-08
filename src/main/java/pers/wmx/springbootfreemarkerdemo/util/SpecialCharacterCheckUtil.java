package pers.wmx.springbootfreemarkerdemo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangmingxin03
 * Created on 2022-09-08
 */
public class SpecialCharacterCheckUtil {
    private static final String regex = "[\\u0009-\\u000d]|\\u2028|\\u2029|\\u00a0|\\u00ad";

    public static boolean checkSpecialCharacter(String str) {
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(str);
        return matcher.find();
    }

    public static void main(String[] args) {
        System.out.println(checkSpecialCharacter(" "));
        System.out.println(checkSpecialCharacter(""));
        System.out.println(checkSpecialCharacter(","));
        System.out.println(checkSpecialCharacter("@"));
        System.out.println(checkSpecialCharacter("#"));
        System.out.println(checkSpecialCharacter("」"));
        System.out.println(checkSpecialCharacter("\uD83C\uDDEE"));




    }
}

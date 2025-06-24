package pers.wmx.springbootfreemarkerdemo;

/**
 * @author wangmingxin03
 * Created on 2021-01-22
 */
public class DoubleTest1 {
    public static void main(String[] args) {
        int fansGroupMemberCount = 117;
        double rate = 0.1;
        int voteCount = 3;

        int threshold = (int) (fansGroupMemberCount * rate);
        System.out.println(threshold);
        System.out.println(voteCount >= threshold);
    }
}

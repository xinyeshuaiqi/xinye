package pers.wmx.springbootfreemarkerdemo.util;

/**
 * @author wangmingxin03
 * Created on 2023-06-21
 */
public class Test0621 {
    public static void main(String[] args) {
        System.out.println(0 % 1253463);

        double f = 0.6;
        System.out.println(4*f);


        long r = (long) (4 * f);
        System.out.println(r);   // 2

        long r1 = (long) (3 * f);
        System.out.println(r1);


        String redPackJumpLinkNew =
                "kwailive://krndialog?bundleid=LiveFeatRevenueAudienceRedparcel&componentname=main&height=538&place=1&transparent=1&redPackTabEntranceType=%s";
        String url = String.format(redPackJumpLinkNew, 1);
        System.out.println(url);

        String redPackJumpLinkNew1 =
                "kwailive://krndialog?bundleid=LiveFeatRevenueAudienceRedparcel&componentname=main&height=538&place=1&transparent=1";
        String url1 = String.format(redPackJumpLinkNew1, 1);
        System.out.println(url1);
    }
}

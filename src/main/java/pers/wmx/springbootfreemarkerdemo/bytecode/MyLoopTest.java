package pers.wmx.springbootfreemarkerdemo.bytecode;

/**
 * @author wangmingxin03
 * Created on 2022-06-24
 */
public class MyLoopTest {
    private static int[] nums = {1, 2, 3};

    public static void main(String[] args) {
        MyCalculator calculator = new MyCalculator();

        for (int i = 0; i < nums.length; i++) {
            calculator.record(i);
        }
    }
}

class MyCalculator {
    public void record(double score) {
    }

    public double getAverage() {
        return 0;
    }
}

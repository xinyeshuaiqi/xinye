package pers.wmx.springbootfreemarkerdemo.base.generics;

/**
 *
 * 泛型的本质是为了参数化类型（在不创建新的类型的情况下，通过泛型指定的不同类型来控制形参具体限制的类型）。
 * 也就是说在泛型使用过程中，操作的数据类型被指定为一个参数，这种参数类型可以用在类、接口和方法中，分别被称为泛型类、泛型接口、泛型方法。
 *
 * @author wangmingxin03
 * Created on 2022-02-18
 */
public class GenericsTest {
    // 泛型的意义 适用于多种数据类型执行相同的代码
    public static int add(int a, int b) {
        return a + b;
    }

    public static float add(float a, float b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static <T extends Number> double add(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }




}

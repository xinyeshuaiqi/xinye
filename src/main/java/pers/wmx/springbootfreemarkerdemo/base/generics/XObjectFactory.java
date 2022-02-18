package pers.wmx.springbootfreemarkerdemo.base.generics;

/**
 * @author wangmingxin03
 * Created on 2022-02-18
 */
public class XObjectFactory {
    /**
     * 为什么要使用泛型方法呢？因为泛型类要在实例化的时候就指明类型，如果想换一种类型，不得不重新new一次，可能不够灵活；
     * 而泛型方法可以在---[调用的时候]---指明类型，更加灵活。
     *
     *  <T> 声明泛型T
     *  T 返回对象
     **/
    public <T> T getObject(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        // 利用反射创建对象
        T instance = clazz.newInstance();
        return instance;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        XObjectFactory xObjectFactory = new XObjectFactory();
        Point object = xObjectFactory.getObject(Point.class);
        Object object1 = xObjectFactory.getObject(Class.forName("pers.wmx.springbootfreemarkerdemo.base.generics.Point"));
        System.out.println(object);  // pers.wmx.springbootfreemarkerdemo.base.generics.Point@439f5b3d
        System.out.println(object1); // pers.wmx.springbootfreemarkerdemo.base.generics.Point@1d56ce6a

    }
}

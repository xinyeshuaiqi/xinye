package pers.wmx.springbootfreemarkerdemo;

import org.springframework.core.ResolvableType;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

/**
 * @author wmx
 * @date 2020-03-30
 */
public class Temp {
    public static void main(String[] args) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        ResolvableType generic0 = ResolvableType.forInstance(hashMap)
                .getGeneric(0);
        ResolvableType generic1 = ResolvableType.forInstance(hashMap)
                .getGeneric(1);
        System.out.println(generic0.getRawClass());
        System.out.println(generic1.getRawClass());

        CustHashMap custHashMap = new CustHashMap();
        ResolvableType generic00 = ResolvableType.forInstance(custHashMap)
                .getGeneric(0);
        ResolvableType generic11 = ResolvableType.forInstance(custHashMap)
                .getGeneric(1);
        System.out.println(generic00.getRawClass());
        System.out.println(generic11.getRawClass());

        ResolvableType generic00_super = ResolvableType.forInstance(custHashMap)
                .getSuperType()
                .getGeneric(0);
        ResolvableType generic11_super = ResolvableType.forInstance(custHashMap)
                .getSuperType()
                .getGeneric(1);
        System.out.println(generic00_super);
        System.out.println(generic11_super);
        
        System.out.println("****************");

        Class clazz = custHashMap.getClass();
        Type superType = clazz.getGenericSuperclass();
        if (superType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) superType;
            Type[] actualTypes = parameterizedType.getActualTypeArguments();
            for (Type type : actualTypes) {
                System.out.println(type);
            }
        }

    }
}

class CustHashMap extends HashMap<String, List<String>> {
}
package pers.wmx.springbootfreemarkerdemo.base.generics;

/**
 * 多元泛型
 *
 * @author wangmingxin03
 * Created on 2022-02-18
 */
public class Notepad<K, V> {
    private K key;
    private V val;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getVal() {
        return val;
    }

    public void setVal(V val) {
        this.val = val;
    }

    public static void main(String[] args) {
        Notepad<Long, String> notepad = new Notepad<>();
        notepad.setKey(666L);
        notepad.setVal("xinye");

        System.out.println(notepad.getKey());
        System.out.println(notepad.getVal());
    }
}

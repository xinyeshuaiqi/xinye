package pers.wmx.springbootfreemarkerdemo.base.generics;

import org.jetbrains.annotations.NotNull;

/**
 * @author wangmingxin03
 * Created on 2022-02-23
 */
public class AComparable implements Comparable<AComparable> {
    private int val;

    public AComparable(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public int compareTo(@NotNull AComparable o) {
        return this.val > o.val ? 1 : 0;
    }
}

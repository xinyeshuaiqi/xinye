package pers.wmx.springbootfreemarkerdemo.util;

/**
 * @author wangmingxin03
 * Created on 2024-07-31
 */
public class Record {
    private long id;

    private long bizId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBizId() {
        return bizId;
    }

    public void setBizId(long bizId) {
        this.bizId = bizId;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", bizId=" + bizId +
                '}';
    }
}

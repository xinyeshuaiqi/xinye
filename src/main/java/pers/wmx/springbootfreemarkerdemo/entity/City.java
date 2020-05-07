package pers.wmx.springbootfreemarkerdemo.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: wangmingxin02
 * @create: 2019-03-26
 **/

public class City {
    Long id;
    Long provinceId;
    String cityName;
    String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

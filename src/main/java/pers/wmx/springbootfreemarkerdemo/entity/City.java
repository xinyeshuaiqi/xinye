package pers.wmx.springbootfreemarkerdemo.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: wangmingxin02
 * @create: 2019-03-26
 **/

@Getter
@Setter
public class City {
    Long id;
    Long provinceId;
    String cityName;
    String description;
}

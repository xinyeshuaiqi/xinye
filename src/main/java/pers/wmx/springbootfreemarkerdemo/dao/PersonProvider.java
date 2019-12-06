package pers.wmx.springbootfreemarkerdemo.dao;

import org.apache.ibatis.annotations.Param;
import pers.wmx.springbootfreemarkerdemo.entity.Person;

/**
 * 动态SQL
 *
 * @author wmx
 * @date 2019-12-06
 */
public class PersonProvider {

    public String updateByCondition(@Param("up") Person updatePerson, @Param("cp") Person conditionPerson) throws Exception {

        // update sql  语句
        String SQL = " update person set ";

        StringBuilder sqlBuilder = new StringBuilder(SQL);

        if(conditionPerson.getId() == null){
            throw new Exception("sql参数异常,缺少更新条件");
        }
        if(updatePerson.getAge() != null){
            sqlBuilder.append(" age = #{up.age}, ");
        }
        if(updatePerson.getName() != null){
            sqlBuilder.append(" name = #{up.name}, ");
        }

        //update  条件
        sqlBuilder.deleteCharAt(sqlBuilder.lastIndexOf(","));
        sqlBuilder.append(" where id = #{cp.id} ");
        //如果有更多的条件可以继续append
        sqlBuilder.append(" ; ");
        return sqlBuilder.toString();
    }

}

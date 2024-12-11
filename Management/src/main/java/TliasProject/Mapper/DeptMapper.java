package TliasProject.Mapper;

import org.apache.ibatis.annotations.*;
import TliasProject.POJO.Dept;

import java.util.List;

/*
 * author: Warren
 */
@Mapper
public interface DeptMapper {
    //查询全部部门数据
    @Select("select*from dept")
    List<Dept> list();

    //根据id删除
    @Delete("delete from dept where id=#{id}")
    void delete(Integer id);

    //添加数据
    @Insert("insert into dept (name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void add(Dept dept);

    //修改
    @Update("update dept set name=#{name}, update_time=#{updateTime} where id=#{id}")
    void modify(Dept dept);

    @Select("SELECT * from dept where id=#{id}")
    Dept getById(Integer id);
}

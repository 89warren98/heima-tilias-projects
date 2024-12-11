package TliasProject.Mapper;

import org.apache.ibatis.annotations.*;
import TliasProject.POJO.Emp;

import java.time.LocalDate;
import java.util.List;

/*
 * author: Warren
 */
@Mapper
public interface EmpMapper {
    //查询总记录数
//    @Select("select count(*) from emp")
//    Integer total();

    //分页查询,获取员工
//    @Select("select *from emp limit #{start},#{pageSize}")
//    List<Emp> page(Integer start, Integer pageSize);

    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);


    void delete(List<Integer> ids);

    @Insert("insert into emp  (username,name,gender,image,job,entrydate,dept_id,create_time,update_time) " +
            "values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    @Select("select *from emp where id=#{id}")
    Emp selectById(int id);



    void update(Emp emp);

    //mybatis会提取emp参数中的username和password两个字段,并查询返回一个Emp对象
    @Select("select *from emp where username=#{username} and password=#{password}")
    Emp getByUsernameAndPassword(Emp emp);

    //根据部门id删除员工数据
    @Delete("delete from emp where dept_id=#{deptId}" )
    void deleteByDeptId(Integer deptId);
}


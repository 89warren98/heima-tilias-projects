package TliasProject.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import TliasProject.Mapper.EmpMapper;
import TliasProject.POJO.Emp;
import TliasProject.POJO.PageBean;
import TliasProject.Service.EmpService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/*
 * author: Warren
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize,String name,
                         Short gender,
                         LocalDate begin,
                         LocalDate end) {
        //设置分页参数
        PageHelper.startPage(page, pageSize);
        //执行查询
        List<Emp> empList = empMapper.list(name,gender,begin,end);
        PageInfo<Emp> pageInfo = new PageInfo<>(empList);

        //封装pagebean对象
        PageBean pageBean = new PageBean(pageInfo.getTotal(), pageInfo.getList());

        return pageBean;

    }

    //删除
    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    //添加
    @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp selectById(Integer id) {

        return empMapper.selectById(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassword(emp);
    }
}
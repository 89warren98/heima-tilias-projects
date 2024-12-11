package TliasProject.Service;

import TliasProject.POJO.Emp;
import TliasProject.POJO.PageBean;

import java.time.LocalDate;
import java.util.List;

/*
 * author: Warren
 */
public interface EmpService {


   PageBean page(Integer page, Integer pageSize,String name,
                 Short gender,
                 LocalDate begin,
                 LocalDate end);

   void delete(List<Integer> ids);

   void add(Emp emp);

   Emp selectById(Integer  id);

   void update(Emp emp);

   Emp login(Emp emp);
}

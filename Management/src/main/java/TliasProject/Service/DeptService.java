package TliasProject.Service;

import TliasProject.POJO.Dept;

import java.util.List;

/*
 * author: Warren
 */
public interface DeptService {
    List<Dept> list();

    void delete(Integer id);

    void add(Dept dept);

    void modify(Dept dept);

    Dept getById(Integer id);

}

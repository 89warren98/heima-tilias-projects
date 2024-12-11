package TliasProject.POJO;

import java.util.List;

/*
 * author: Warren
 */
public class PageBean {
    private long total;//员工总数
    private List rows ;//员工信息(数据列表)

    public PageBean() {
    }

    public PageBean(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    /**
     * 获取
     * @return total
     */
    public long getTotal() {
        return total;
    }

    /**
     * 设置
     * @param total
     */
    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * 获取
     * @return rows
     */
    public List getRows() {
        return rows;
    }

    /**
     * 设置
     * @param rows
     */
    public void setRows(List rows) {
        this.rows = rows;
    }

    public String toString() {
        return "PageBean{total = " + total + ", rows = " + rows + "}";
    }
}

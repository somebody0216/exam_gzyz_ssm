package gzyz.Allmode.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author jun
 * @date 2021/1/22-10:59
 */
public class PageUtils implements Serializable {
    private int total;
    private List<?> rows;

    public PageUtils() {
    }

    public PageUtils(int total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}

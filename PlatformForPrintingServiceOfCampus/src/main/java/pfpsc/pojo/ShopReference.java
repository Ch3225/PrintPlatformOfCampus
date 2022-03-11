package pfpsc.pojo;

public class ShopReference {
    private Integer id;

    private String list;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list == null ? null : list.trim();
    }
}
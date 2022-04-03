package pfpsc.model.pojo;

public class Trade {
    private Integer id;

    private String documentMd5;

    private String methodString;

    private String state;

    private Integer userId;

    private Integer shopId;

    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentMd5() {
        return documentMd5;
    }

    public void setDocumentMd5(String documentMd5) {
        this.documentMd5 = documentMd5 == null ? null : documentMd5.trim();
    }

    public String getMethodString() {
        return methodString;
    }

    public void setMethodString(String methodString) {
        this.methodString = methodString == null ? null : methodString.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
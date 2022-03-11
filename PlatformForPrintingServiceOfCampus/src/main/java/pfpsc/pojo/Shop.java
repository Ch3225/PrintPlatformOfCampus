package pfpsc.pojo;

public class Shop {
    private Integer id;

    private String shopname;

    private Integer eState;

    private Integer pPositionId;

    private Integer uUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname == null ? null : shopname.trim();
    }

    public Integer geteState() {
        return eState;
    }

    public void seteState(Integer eState) {
        this.eState = eState;
    }

    public Integer getpPositionId() {
        return pPositionId;
    }

    public void setpPositionId(Integer pPositionId) {
        this.pPositionId = pPositionId;
    }

    public Integer getuUserId() {
        return uUserId;
    }

    public void setuUserId(Integer uUserId) {
        this.uUserId = uUserId;
    }
}
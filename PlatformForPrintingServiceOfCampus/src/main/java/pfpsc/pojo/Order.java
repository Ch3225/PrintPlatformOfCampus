package pfpsc.pojo;

public class Order {
    private Integer id;

    private Integer eState;

    private Integer uUserIdCustomer;

    private Integer uUserIdShopper;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer geteState() {
        return eState;
    }

    public void seteState(Integer eState) {
        this.eState = eState;
    }

    public Integer getuUserIdCustomer() {
        return uUserIdCustomer;
    }

    public void setuUserIdCustomer(Integer uUserIdCustomer) {
        this.uUserIdCustomer = uUserIdCustomer;
    }

    public Integer getuUserIdShopper() {
        return uUserIdShopper;
    }

    public void setuUserIdShopper(Integer uUserIdShopper) {
        this.uUserIdShopper = uUserIdShopper;
    }
}
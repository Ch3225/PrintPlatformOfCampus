package pfpsc.pojo;

public class User {
    private Integer id;

    private Integer eProperty;

    private Integer eState;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer geteProperty() {
        return eProperty;
    }

    public void seteProperty(Integer eProperty) {
        this.eProperty = eProperty;
    }

    public Integer geteState() {
        return eState;
    }

    public void seteState(Integer eState) {
        this.eState = eState;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}
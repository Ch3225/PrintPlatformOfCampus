package pfpsc.pojo;

public class UserInfo {
    private Integer id;

    private String rpcid;

    private String phonenumber;

    private String email;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRpcid() {
        return rpcid;
    }

    public void setRpcid(String rpcid) {
        this.rpcid = rpcid == null ? null : rpcid.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
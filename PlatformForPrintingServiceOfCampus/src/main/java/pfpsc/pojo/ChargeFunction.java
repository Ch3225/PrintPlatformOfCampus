package pfpsc.pojo;

public class ChargeFunction {
    private Integer id;

    private Integer referencenum;

    private String function;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReferencenum() {
        return referencenum;
    }

    public void setReferencenum(Integer referencenum) {
        this.referencenum = referencenum;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function == null ? null : function.trim();
    }
}
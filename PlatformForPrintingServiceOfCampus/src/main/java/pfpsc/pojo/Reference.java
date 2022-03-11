package pfpsc.pojo;

public class Reference {
    private Integer id;

    private Integer cChargefunctionId;

    private Integer referenceno;

    private String varname;

    private String referencename;

    private String referencedescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getcChargefunctionId() {
        return cChargefunctionId;
    }

    public void setcChargefunctionId(Integer cChargefunctionId) {
        this.cChargefunctionId = cChargefunctionId;
    }

    public Integer getReferenceno() {
        return referenceno;
    }

    public void setReferenceno(Integer referenceno) {
        this.referenceno = referenceno;
    }

    public String getVarname() {
        return varname;
    }

    public void setVarname(String varname) {
        this.varname = varname == null ? null : varname.trim();
    }

    public String getReferencename() {
        return referencename;
    }

    public void setReferencename(String referencename) {
        this.referencename = referencename == null ? null : referencename.trim();
    }

    public String getReferencedescription() {
        return referencedescription;
    }

    public void setReferencedescription(String referencedescription) {
        this.referencedescription = referencedescription == null ? null : referencedescription.trim();
    }
}
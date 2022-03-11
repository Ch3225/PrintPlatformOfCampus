package pfpsc.pojo;

public class ItemKey {
    private Integer id;

    private String keyname;

    private Integer mPrintchoiceId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname == null ? null : keyname.trim();
    }

    public Integer getmPrintchoiceId() {
        return mPrintchoiceId;
    }

    public void setmPrintchoiceId(Integer mPrintchoiceId) {
        this.mPrintchoiceId = mPrintchoiceId;
    }
}
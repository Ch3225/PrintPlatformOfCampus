package pfpsc.pojo;

public class ItemChoice {
    private Integer id;

    private Integer mPrintkeyId;

    private String choicename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getmPrintkeyId() {
        return mPrintkeyId;
    }

    public void setmPrintkeyId(Integer mPrintkeyId) {
        this.mPrintkeyId = mPrintkeyId;
    }

    public String getChoicename() {
        return choicename;
    }

    public void setChoicename(String choicename) {
        this.choicename = choicename == null ? null : choicename.trim();
    }
}
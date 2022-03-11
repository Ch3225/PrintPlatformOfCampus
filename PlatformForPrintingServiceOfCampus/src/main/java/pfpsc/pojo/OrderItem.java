package pfpsc.pojo;

public class OrderItem {
    private Integer id;

    private Integer oOrderId;

    private Integer fFileId;

    private Integer mPrintmethodId;

    private Integer eState;

    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getoOrderId() {
        return oOrderId;
    }

    public void setoOrderId(Integer oOrderId) {
        this.oOrderId = oOrderId;
    }

    public Integer getfFileId() {
        return fFileId;
    }

    public void setfFileId(Integer fFileId) {
        this.fFileId = fFileId;
    }

    public Integer getmPrintmethodId() {
        return mPrintmethodId;
    }

    public void setmPrintmethodId(Integer mPrintmethodId) {
        this.mPrintmethodId = mPrintmethodId;
    }

    public Integer geteState() {
        return eState;
    }

    public void seteState(Integer eState) {
        this.eState = eState;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
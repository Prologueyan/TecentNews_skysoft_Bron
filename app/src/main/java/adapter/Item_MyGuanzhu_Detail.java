package adapter;

/**
 * Created by test on 2016/8/8.
 */
public class Item_MyGuanzhu_Detail {
    private String name;
    private int picId;
    private String overView;

    public Item_MyGuanzhu_Detail() {
    }

    public Item_MyGuanzhu_Detail(String name, int picId, String overView) {
        this.name = name;
        this.picId = picId;
        this.overView = overView;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }
}

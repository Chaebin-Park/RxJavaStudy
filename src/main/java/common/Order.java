package common;

public class Order {
    private String mId;

    public Order(String mId) {
        this.mId = mId;
    }

    public String getId() {
        return mId;
    }

    @Override
    public String toString() {
        return "Order ID : " + mId;
    }
}

package idat.com.bar_android.models;

public class OrderStaticDetils {
    private static OrderModel orderModel;

    public OrderStaticDetils() {
    }

    public static OrderModel getOrderModel() {
        return orderModel;
    }

    public static void setOrderModel(OrderModel orderModel) {
        OrderStaticDetils.orderModel = orderModel;
    }


}

package idat.com.bar_android.models;

import java.util.ArrayList;

public class ListOrdersModel {

    private static ArrayList<OrderItemModel> orderItemModels = new ArrayList<>();

    public static ArrayList<OrderItemModel> getOrderItemModels() {
        return orderItemModels;
    }

    public static void setOrderItemModels(ArrayList<OrderItemModel> orderItemModels) {
        ListOrdersModel.orderItemModels = orderItemModels;
    }
}

package idat.com.bar_android.models;

import java.util.ArrayList;

public class ListDetailsOrders {
    public static ArrayList<DetailModel> detailModels = new ArrayList<>();

    public static ArrayList<DetailModel> getDetailModels() {
        return detailModels;
    }

    public static void setDetailModels(ArrayList<DetailModel> detailModels) {
        ListDetailsOrders.detailModels = detailModels;
    }
}

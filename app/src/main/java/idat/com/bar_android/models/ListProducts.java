package idat.com.bar_android.models;

import java.util.ArrayList;

public class ListProducts {
    public static ArrayList<ProductModel> productModels = new ArrayList<>();

    public static ArrayList<ProductModel> getProductModels() {
        return productModels;
    }

    public static void setProductModels(ArrayList<ProductModel> productModels) {
        ListProducts.productModels = productModels;
    }
}

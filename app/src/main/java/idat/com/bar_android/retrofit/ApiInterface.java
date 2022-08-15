package idat.com.bar_android.retrofit;

import java.util.ArrayList;

import idat.com.bar_android.models.OrderItemModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("pedido/all")
    Call<ArrayList<OrderItemModel>> getOrders();

}

package idat.com.bar_android.retrofit;

import java.util.ArrayList;

import idat.com.bar_android.models.OrderItemModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("pedido/all")
    Call<ArrayList<OrderItemModel>> getOrders();

    @GET("pedido/estadox/1")
    Call<ArrayList<OrderItemModel>> getOrdersPending();

    @GET("pedido/estadox/2")
    Call<ArrayList<OrderItemModel>> getOrdersPostponed();

    @GET("pedido/estadox/3")
    Call<ArrayList<OrderItemModel>> getOrdersDelivered();

    @GET("pedido/estadox/4")
    Call<ArrayList<OrderItemModel>> getOrdersCancelled();

}

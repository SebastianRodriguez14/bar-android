package idat.com.bar_android.retrofit;

import java.util.ArrayList;

import idat.com.bar_android.models.DetailModel;
import idat.com.bar_android.models.ListDetailsOrders;
import idat.com.bar_android.models.OrderItemModel;
import idat.com.bar_android.models.OrderModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("pedido/all")
    Call<ArrayList<OrderItemModel>> getOrders();

    @GET("pedido/estadox/{id}")
    Call<ArrayList<OrderItemModel>> getOrdersByState(@Path("id") String id);

    @GET("pedido/buscar/{id}")
    Call<ArrayList<OrderModel>> getOrderById(@Path("id") String id);

    @GET("detalle/order/{id}")
    Call<ArrayList<DetailModel>> getOrderDetails(@Path("id") String id);

    @PUT("pedido/actualizar/{id}")
    Call<OrderModel> updateOrder(@Path("id") String id, OrderModel order);
}

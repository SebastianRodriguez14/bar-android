package idat.com.bar_android.add_functions;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import idat.com.bar_android.models.ListOrdersModel;
import idat.com.bar_android.models.OrderItemModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FunctionsActivities {

    public Callback<ArrayList<OrderItemModel>> getCallbackRetrofit(){
        return new Callback<ArrayList<OrderItemModel>>() {
            @Override
            public void onResponse(Call<ArrayList<OrderItemModel>> call, Response<ArrayList<OrderItemModel>> response) {
                Log.i("info", "Recibimos respuesta :D");

                ArrayList<OrderItemModel> test = response.body();

                for (OrderItemModel o : test){
                    System.out.println(o.toString());
                }

                ListOrdersModel.setOrderItemModels(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<OrderItemModel>> call, Throwable t) {
                Log.e("error", "Error, mátate");
            }
        };
    }

}

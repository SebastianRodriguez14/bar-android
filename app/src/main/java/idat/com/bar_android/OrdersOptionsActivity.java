package idat.com.bar_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import idat.com.bar_android.add_functions.ChosenFragments;
import idat.com.bar_android.fragments.AllOrderFragment;
import idat.com.bar_android.fragments.CancelledOrderFragment;
import idat.com.bar_android.fragments.DeliveredOrderFragment;
import idat.com.bar_android.fragments.LoaderFragment;
import idat.com.bar_android.fragments.NotOrdersFragment;
import idat.com.bar_android.fragments.PendingOrderFragment;
import idat.com.bar_android.fragments.PostponedOrderFragment;
import idat.com.bar_android.models.ListOrdersModel;
import idat.com.bar_android.models.OrderItemModel;
import idat.com.bar_android.retrofit.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrdersOptionsActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ImageView homeImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_options);
        bottomNavigationView = findViewById(R.id.types_orders_options);
        homeImageButton = findViewById(R.id.home_button);

        homeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrdersOptionsActivity.this, MenuActivity.class));
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setItemByDefault();
        loadFragment(new LoaderFragment());
        if (ChosenFragments.getIndexFragment() == 1){
            fetchOrders(ChosenFragments.getFragment());
        } else if (ChosenFragments.getIndexFragment() > 1){
            fetchOrdersByState(ChosenFragments.getFragment(), String.valueOf(ChosenFragments.getIndexFragment()-1));
        }

    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            loadFragment(new LoaderFragment());
            switch (item.getItemId()){
                case R.id.icon_told:
                    fetchOrders(new AllOrderFragment());
                    return true;
                case R.id.icon_can:
                    fetchOrdersByState(new CancelledOrderFragment(), "4");
                    return true;
                case R.id.icon_ent:
                    fetchOrdersByState(new DeliveredOrderFragment(), "3");
                    return true;
                case R.id.icon_pend:
                    fetchOrdersByState(new PendingOrderFragment(), "1");
                    return true;
                case R.id.icon_pos:
                    fetchOrdersByState(new PostponedOrderFragment(), "2");
                    return true;
            }
            return false;
        }
    };

    private void setItemByDefault(){
        int option = 0;
        switch (ChosenFragments.getIndexFragment()){
            case 1:
                option = R.id.icon_told;
                break;
            case 2:
                option = R.id.icon_pend;
                break;
            case 3:
                option = R.id.icon_pos;
                break;
            case 4:
                option = R.id.icon_ent;
                break;
            case 5:
                option = R.id.icon_can;
                break;
        }
        bottomNavigationView.setSelectedItemId(option);

    }



    private void loadFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.commit();
    }

    private void fetchOrdersByState(Fragment fragment, String id){
        Log.i("id", "Soy el id de ordersByState: " + id);
        RetrofitClient.getRetrofitClient().getOrdersByState(id).enqueue(new Callback<ArrayList<OrderItemModel>>() {
            @Override
            public void onResponse(Call<ArrayList<OrderItemModel>> call, Response<ArrayList<OrderItemModel>> response) {
                Log.i("info", "Recibimos respuesta :D");

                ArrayList<OrderItemModel> test = response.body();

                for (OrderItemModel o : test){
                    System.out.println(o.toString());
                }
                ListOrdersModel.setOrderItemModels(response.body());
                if (response.body().size() != 0){
                    loadFragment(fragment);
                } else{
                    Log.i("aviso", "No hay pedidos xd");
                    loadFragment(new NotOrdersFragment());
                }


            }

            @Override
            public void onFailure(Call<ArrayList<OrderItemModel>> call, Throwable t) {
                Log.e("error", "Error, mátate");
            }
        });
    }

    private void fetchOrders(Fragment fragment){
        RetrofitClient.getRetrofitClient().getOrders().enqueue(new Callback<ArrayList<OrderItemModel>>() {
            @Override
            public void onResponse(Call<ArrayList<OrderItemModel>> call, Response<ArrayList<OrderItemModel>> response) {
                Log.i("info", "Recibimos respuesta :D");

                ArrayList<OrderItemModel> test = response.body();

                for (OrderItemModel o : test){
                    System.out.println(o.toString());
                }

                ListOrdersModel.setOrderItemModels(response.body());
                if (response.body().size() != 0){
                    loadFragment(fragment);
                } else{
                    loadFragment(new NotOrdersFragment());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<OrderItemModel>> call, Throwable t) {
                Log.e("error", "Error, mátate");
            }
        });
    }




}
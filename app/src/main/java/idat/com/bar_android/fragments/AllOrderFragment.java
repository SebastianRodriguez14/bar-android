package idat.com.bar_android.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import idat.com.bar_android.R;
import idat.com.bar_android.adapter.OrderItemAdapter;
import idat.com.bar_android.add_functions.FunctionsFragments;
import idat.com.bar_android.models.OrderItemModel;
import idat.com.bar_android.retrofit.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllOrderFragment extends Fragment {

    private RecyclerView recyclerView;
    private OrderItemAdapter orderItemAdapter;
    private ArrayList<OrderItemModel> orderItemModels = new ArrayList<>();

    public AllOrderFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_all_order, container, false);
        fetchOrders();

        recyclerView = root.findViewById(R.id.list_pedidos);
        orderItemAdapter = new OrderItemAdapter(orderItemModels, R.layout.item_todos);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(orderItemAdapter);

        return root;
    }


    private void fetchOrders(){
        RetrofitClient.getRetrofitClient().getOrders().enqueue(new Callback<ArrayList<OrderItemModel>>() {
            @Override
            public void onResponse(Call<ArrayList<OrderItemModel>> call, Response<ArrayList<OrderItemModel>> response) {
                Log.i("info", "Recibimos respuesta :D");

                ArrayList<OrderItemModel> test = response.body();

                for (OrderItemModel o : test){
                    System.out.println(o.toString());
                }

                orderItemModels.addAll(response.body());
                orderItemAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<OrderItemModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Error, mátate", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
package idat.com.bar_android.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import idat.com.bar_android.R;
import idat.com.bar_android.adapter.OrderItemAdapter;
import idat.com.bar_android.models.ListOrdersModel;
import idat.com.bar_android.models.OrderItemModel;
import idat.com.bar_android.retrofit.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PendingOrderFragment extends Fragment {

    private RecyclerView recyclerView;
    private OrderItemAdapter orderItemAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pending_order, container, false);

        recyclerView = root.findViewById(R.id.list_pedidos_pendientes);
        orderItemAdapter = new OrderItemAdapter(ListOrdersModel.getOrderItemModels(), R.layout.item_pendiente);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(orderItemAdapter);

        return root;
    }



}
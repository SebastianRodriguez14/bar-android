package idat.com.bar_android.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;

import idat.com.bar_android.R;
import idat.com.bar_android.adapter.OrderItemAdapter;
import idat.com.bar_android.models.OrderItemModel;


public class PendingOrderFragment extends Fragment {

    private RecyclerView recyclerView;
    private OrderItemAdapter orderItemAdapter;
    private ArrayList<OrderItemModel> orderItemModels;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pending_order, container, false);
        getData();
        recyclerView = root.findViewById(R.id.list_pedidos_pendientes);
        orderItemAdapter = new OrderItemAdapter(orderItemModels, R.layout.item_pendiente);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(orderItemAdapter);

        return root;
    }

    public void getData(){
        orderItemModels = new ArrayList<>();

        orderItemModels.add(new OrderItemModel(200, "Tatiana Taboada", "78542144", "78589845", 3000.0, new Date()));
    }
}
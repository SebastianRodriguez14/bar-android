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
import idat.com.bar_android.adapter.OrderItemAdapterTodos;
import idat.com.bar_android.models.OrderItemModel;

public class AllOrderFragment extends Fragment {

    private RecyclerView recyclerView;
    private OrderItemAdapterTodos pedidoItemAdapter;
    private ArrayList<OrderItemModel> pedidoItemModels;

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
        getData();
        recyclerView = root.findViewById(R.id.list_pedidos);
        pedidoItemAdapter = new OrderItemAdapterTodos(pedidoItemModels);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(pedidoItemAdapter);

        return root;
    }

    public void getData(){
        pedidoItemModels = new ArrayList<>();

        pedidoItemModels.add(new OrderItemModel(100, "Sebastián Rodríguez", "75684700", "74714521", 2500.0, new Date()));
    }

}
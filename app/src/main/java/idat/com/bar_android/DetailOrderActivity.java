package idat.com.bar_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import idat.com.bar_android.adapter.ProductAdapter;
import idat.com.bar_android.models.Codigo;
import idat.com.bar_android.models.ListProducts;
import idat.com.bar_android.models.OrderItemModel;
import idat.com.bar_android.models.OrderModel;
import idat.com.bar_android.models.ProductModel;
import idat.com.bar_android.retrofit.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailOrderActivity extends AppCompatActivity {

    TextView n_pedido, fecha_pedido, total_pedido, nombre_cliente, dni_cliente, telefono_cliente, dni_recibidor, fecha_envio, estado_pedido ;
    Button buttonEditarPedido;
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private ArrayList<ProductModel> productModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);
        fetchDatailOrder(Codigo.getCodigo());

        recyclerView = findViewById(R.id.detalle_lista_productos);
        productAdapter = new ProductAdapter(productModels);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DetailOrderActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(productAdapter);

        n_pedido = findViewById(R.id.detalle_n_pedido);
        fecha_pedido = findViewById(R.id.detalle_fecha_pedido);
        total_pedido = findViewById(R.id.detalle_total_pedido);
        nombre_cliente = findViewById(R.id.detalle_nombre_cliente);
        dni_cliente = findViewById(R.id.detalle_dni_cliente);
        telefono_cliente = findViewById(R.id.detalle_telefono);
        dni_recibidor = findViewById(R.id.detalle_dni_recoger);
        fecha_envio = findViewById(R.id.detalle_fecha_entrega);
        estado_pedido = findViewById(R.id.detalle_estado);

        buttonEditarPedido = findViewById(R.id.detalle_button_editar_pedido);
        buttonEditarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateOrderDialogFragment updateOrderDialogFragment = new UpdateOrderDialogFragment();
                updateOrderDialogFragment.show(getSupportFragmentManager(), "UpdateOrderDialog");

            }
        });

    }

    public void fetchDatailOrder(String id) {
        RetrofitClient.getRetrofitClient().getOrderById(id).enqueue(new Callback<ArrayList<OrderModel>>() {
            @Override
            public void onResponse(Call<ArrayList<OrderModel>> call, Response<ArrayList<OrderModel>> response) {
                if (response.isSuccessful()) {
                    ArrayList<OrderModel> orderModels = response.body();
                    for(OrderModel orderModel : orderModels){
                        n_pedido.setText("Pedido N°" + orderModel.getCod_pedido().toString());
                        fecha_pedido.setText(new SimpleDateFormat("dd/MM/yy").format(orderModel.getFecha_solicitud()));
                        total_pedido.setText("Total: S/. " + orderModel.getPrecio_total().toString());
                        nombre_cliente.setText(orderModel.getCliente().getNombre() + " " + orderModel.getCliente().getApPaterno());
                        dni_cliente.setText(orderModel.getCliente().getDni());
                        telefono_cliente.setText(orderModel.getCliente().getTelefono());
                        dni_recibidor.setText(orderModel.getDni_recibidor());
                        fecha_envio.setText(new SimpleDateFormat("dd/MM/yy").format(orderModel.getFecha_envio()));
                        estado_pedido.setText(orderModel.getEstado().getNombre());
                        ListProducts.setProductModels(orderModel.getProductos());
                        productModels.addAll(orderModel.getProductos());
                        productAdapter.notifyDataSetChanged();

                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<OrderModel>> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
            }
        });
    }


}
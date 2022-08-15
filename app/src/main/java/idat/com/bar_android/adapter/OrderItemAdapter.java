package idat.com.bar_android.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import idat.com.bar_android.R;
import idat.com.bar_android.models.OrderItemModel;

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.ViewHolder> {

    private ArrayList<OrderItemModel> pedidoItemModels;
    private int layout;

    public OrderItemAdapter(ArrayList<OrderItemModel> pedidoItemModels, int layout) {
        this.pedidoItemModels = pedidoItemModels;
        this.layout = layout;
    }

    @NonNull
    @Override
    public OrderItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull OrderItemAdapter.ViewHolder holder, int position){
        holder.n_pedido.setText(pedidoItemModels.get(position).getN_pedido().toString());
        holder.nombre_cliente.setText(pedidoItemModels.get(position).getNombre_cliente());
        holder.dni.setText(pedidoItemModels.get(position).getDni());
        holder.dni_recibidor.setText(pedidoItemModels.get(position).getDni_recibidor());
        holder.fecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(pedidoItemModels.get(position).getFecha()));
        holder.costo_total.setText(pedidoItemModels.get(position).getCosto_total().toString());
    }

    @Override
    public int getItemCount(){
        return pedidoItemModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView n_pedido, nombre_cliente, fecha, dni, dni_recibidor, costo_total;

        public ViewHolder (@NonNull View itemView){
            super(itemView);

            n_pedido = itemView.findViewById(R.id.item_n_pedido);
            nombre_cliente = itemView.findViewById(R.id.item_nombre_cliente);
            fecha = itemView.findViewById(R.id.item_fecha);
            dni = itemView.findViewById(R.id.item_dni);
            dni_recibidor = itemView.findViewById(R.id.item_dni_recibidor);
            costo_total = itemView.findViewById(R.id.item_costo_total);
        }
    }

}

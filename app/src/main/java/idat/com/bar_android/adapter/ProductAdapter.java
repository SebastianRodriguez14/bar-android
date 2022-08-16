package idat.com.bar_android.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import idat.com.bar_android.DetailOrderActivity;
import idat.com.bar_android.R;
import idat.com.bar_android.models.Codigo;
import idat.com.bar_android.models.ProductModel;

public class ProductAdapter extends  RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private ArrayList<ProductModel> productModels;

    public ProductAdapter(ArrayList<ProductModel> productModels) {
        this.productModels = productModels;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail_product_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.producto_nomrbre.setText(productModels.get(position).getDescripcion());
        holder.producto_precio.setText(productModels.get(position).getPrecio().toString());
        holder.producto_cantidad.setText("10");
        holder.producto_total.setText(productModels.get(position).getPrecio() * 10 + "");
        Glide.with(holder.itemView.getContext()).load(productModels.get(position).getImagen()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.producto_imagen);
    }

    @Override
    public int getItemCount(){
        return productModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView producto_nomrbre, producto_precio, producto_cantidad, producto_total;
        ImageView producto_imagen;

        public ViewHolder (@NonNull View itemView){
            super(itemView);

            producto_nomrbre = itemView.findViewById(R.id.detalle_producto_nombre);
            producto_precio = itemView.findViewById(R.id.detalle_producto_costo_unitario);
            producto_cantidad = itemView.findViewById(R.id.detalle_producto_cantidad);
            producto_total = itemView.findViewById(R.id.detalle_producto_subtotal);
            producto_imagen = itemView.findViewById(R.id.detalle_producto_imagen);
        }
    }
}

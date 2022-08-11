package idat.com.bar_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetailOrderActivity extends AppCompatActivity {

    Button buttonEditarPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);



        buttonEditarPedido = findViewById(R.id.detalle_button_editar_pedido);
        buttonEditarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateOrderDialogFragment updateOrderDialogFragment = new UpdateOrderDialogFragment();
                updateOrderDialogFragment.show(getSupportFragmentManager(), "UpdateOrderDialog");

            }
        });

    }


}
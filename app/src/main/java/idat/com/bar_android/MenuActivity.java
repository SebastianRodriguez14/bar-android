package idat.com.bar_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MenuActivity extends AppCompatActivity {

    CardView cardViewAll,cardViewPend,cardViewPost,cardViewEntre,cardViewCanc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        cardViewAll = findViewById(R.id.total_pedidos);
        cardViewPend= findViewById(R.id.CardPendiente);
        cardViewPost = findViewById(R.id.CardPostergado);
        cardViewEntre = findViewById(R.id.CardEntregado);
        cardViewCanc = findViewById(R.id.CardCancelado);

        cardViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,AllOrderActivity.class);
                startActivity(intent);
                finish();
            }
        });

        cardViewPend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,PendienteActivity.class);
                startActivity(intent);
                finish();
            }
        });

        cardViewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,PostergadoActivity.class);
                startActivity(intent);
                finish();
            }
        });

        cardViewEntre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,EntregadoActivity.class);
                startActivity(intent);
                finish();
            }
        });

        cardViewCanc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,CanceladoActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
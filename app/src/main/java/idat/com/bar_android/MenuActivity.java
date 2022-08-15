package idat.com.bar_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import idat.com.bar_android.add_functions.ChosenFragments;
import idat.com.bar_android.fragments.AllOrderFragment;
import idat.com.bar_android.fragments.CancelledOrderFragment;
import idat.com.bar_android.fragments.DeliveredOrderFragment;
import idat.com.bar_android.fragments.PendingOrderFragment;
import idat.com.bar_android.fragments.PostponedOrderFragment;

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


        cardViewAll.setOnClickListener(enterToFragmentOrders(new AllOrderFragment(), 1));

        cardViewPend.setOnClickListener(enterToFragmentOrders(new PendingOrderFragment(), 2));

        cardViewPost.setOnClickListener(enterToFragmentOrders(new PostponedOrderFragment(), 3));

        cardViewEntre.setOnClickListener(enterToFragmentOrders(new DeliveredOrderFragment(), 4));

        cardViewCanc.setOnClickListener(enterToFragmentOrders(new CancelledOrderFragment(), 5));
    }

    private View.OnClickListener enterToFragmentOrders(Fragment fragment, Integer id){

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MenuActivity.this, OrdersOptionsActivity.class);
                ChosenFragments.setFragment(fragment);
                ChosenFragments.setIndexFragment(id);
                startActivity(intent);
                finish();

            }
        };

        return onClickListener;

    }

}
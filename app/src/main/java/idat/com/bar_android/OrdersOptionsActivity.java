package idat.com.bar_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import idat.com.bar_android.add_functions.ChosenFragment;
import idat.com.bar_android.fragments.AllOrderFragment;
import idat.com.bar_android.fragments.CancelledOrderFragment;
import idat.com.bar_android.fragments.DeliveredOrderFragment;
import idat.com.bar_android.fragments.PendingOrderFragment;
import idat.com.bar_android.fragments.PostponedOrderFragment;

public class OrdersOptionsActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ImageView homeImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_options);
        bottomNavigationView = findViewById(R.id.types_orders_options);
        homeImageButton = findViewById(R.id.home_button);

        homeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrdersOptionsActivity.this, MenuActivity.class));
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(ChosenFragment.getFragment());

    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.icon_told:
                    loadFragment(new AllOrderFragment());
                    return true;
                case R.id.icon_can:
                    loadFragment(new CancelledOrderFragment());
                    return true;
                case R.id.icon_ent:
                    loadFragment(new DeliveredOrderFragment());
                    return true;
                case R.id.icon_pend:
                    loadFragment(new PendingOrderFragment());
                    return true;
                case R.id.icon_pos:
                    loadFragment(new PostponedOrderFragment());
                    return true;

            }
            return false;
        }
    };


    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }

}
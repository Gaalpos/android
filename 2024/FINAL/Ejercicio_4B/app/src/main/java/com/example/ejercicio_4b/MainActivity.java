package com.example.ejercicio_4b;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    boolean mDualPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainFragment masterFragment = null;
        FrameLayout frameLayout = findViewById(R.id.fl_framePortrait);
        if (frameLayout != null) {
            mDualPane = false;
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            masterFragment = (MainFragment) getSupportFragmentManager()
                    .findFragmentByTag("MAIN");
            if (masterFragment == null) {
                masterFragment = new MainFragment();
                fragmentTransaction.add(R.id.fl_framePortrait, masterFragment, "MAIN");
            }
            DetailFragment detailFragment = (DetailFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fl_detail);
            if (detailFragment != null) {
                fragmentTransaction.remove(detailFragment);
            }
            fragmentTransaction.commit();
        } else {
            mDualPane = true;
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            masterFragment = (MainFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.fl_main);
            if (masterFragment == null) {
                masterFragment = new MainFragment();
                fragmentTransaction.add(R.id.fl_main, masterFragment);
            }
            DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.fl_detail);
            if (detailFragment == null) {
                detailFragment = new DetailFragment();
                fragmentTransaction.add(R.id.fl_detail, detailFragment);
            }
            fragmentTransaction.commit();
        }
        masterFragment.setOnMasterSelectedListener(new MainFragment.OnMasterSelectedListener() {
            @Override
            public void onItemSelected(DatosElemento datosElemento) {
                sendCountryDetails(datosElemento);
            }

        });
    }
    private void sendCountryDetails(DatosElemento datosElemento) {
        DetailFragment detailFragment;
        if (mDualPane) {
//Two pane layout
            detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.fl_detail);
            detailFragment.showSelected(datosElemento.getDatosEstado());
        } else {
// Single pane layout
            detailFragment = new DetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString(DetailFragment.KEY_DATA, datosElemento.getDatosEstado());

            detailFragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fl_framePortrait, detailFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
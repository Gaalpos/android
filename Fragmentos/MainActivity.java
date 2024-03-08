package com.example.lib4a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;




/*IMPORTANTE.
* Para el landscape cuando le das al boton del emulador de tumbar el teléfono de por si solo no se me tumbaba.
* Aparece un icono en un boton de color negro con el simbolo de cambiar de posición y una vez le das ya te cambia a landscape. SI QUE FUNCIONA*/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MasterFragment masterFragment = null;
        FrameLayout frameLayout = findViewById(R.id.frameLayout);
        boolean mDualPane;
        if (frameLayout != null) {
            mDualPane = false;
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            masterFragment = (MasterFragment) getSupportFragmentManager()
                    .findFragmentByTag("MASTER");
            if (masterFragment == null) {
                masterFragment = new MasterFragment();
                fragmentTransaction.add(R.id.frameLayout, masterFragment, "MASTER");
            }
            DetailFragment detailFragment = (DetailFragment)
                    getSupportFragmentManager().findFragmentById(R.id.frameLayoutDetail);
            if (detailFragment != null) {
                fragmentTransaction.remove(detailFragment);
            }
            fragmentTransaction.commit();
        } else {

            mDualPane = true;
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            masterFragment = (MasterFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.frameLayoutMaster);
            if (masterFragment == null) {
                masterFragment = new MasterFragment();
                fragmentTransaction.add(R.id.frameLayoutMaster, masterFragment);
            }
            DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.frameLayoutDetail);
            if (detailFragment == null) {
                detailFragment = new DetailFragment();
                fragmentTransaction.add(R.id.frameLayoutDetail, detailFragment);
            }
            fragmentTransaction.commit();
        }
        masterFragment.setOnMasterSelectedListener(new MasterFragment.OnMasterSelectedListener() {
            @Override
            public void onItemSelected(String countryName) {
                sendCountryName(countryName);
            }

            private void sendCountryName(String countryName) {
                DetailFragment detailFragment;
                if (mDualPane) {
//Two pane layout
                    detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frameLayoutDetail);
                    detailFragment.showSelectedCountry(countryName);
                } else {
// Single pane layout
                    detailFragment = new DetailFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString(DetailFragment.KEY_COUNTRY_NAME, countryName);
                    detailFragment.setArguments(bundle);
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, detailFragment);

                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }

        });
    }
}
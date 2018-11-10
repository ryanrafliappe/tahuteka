package com.example.ryan.bottomnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.example.ryan.bottomnavigation.Bahans.BahanFragment;
import com.example.ryan.bottomnavigation.Laporans.LaporanFragment;
import com.example.ryan.bottomnavigation.Regist.RegistrasiFragment;
import com.example.ryan.bottomnavigation.TopUps.TopupFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //kita set default nya Home Fragment
        loadFragment(new RegistrasiFragment());

        //inisialisasi ButtomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);

        //beri listener pada saat item/menu buttomNavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    //method untuk load fragment yang sesuai
    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).commit();
            return true;
        }

        return false;
    }

    //method listener untuk logika pemilihan
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.registrasi_menu:
                fragment = new RegistrasiFragment();
                break;
            case R.id.topup_menu:
                fragment = new TopupFragment();
                break;
            case R.id.bahan_menu:
                fragment = new BahanFragment();
                break;
            case R.id.laporan_menu:
                fragment = new LaporanFragment();
                break;
        }
        return loadFragment(fragment);
    }

}

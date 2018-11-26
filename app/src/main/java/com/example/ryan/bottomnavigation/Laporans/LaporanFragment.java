package com.example.ryan.bottomnavigation.Laporans;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ryan.bottomnavigation.FragmentPesanan;
import com.example.ryan.bottomnavigation.FragmentRiwayat;
import com.example.ryan.bottomnavigation.R;
import com.example.ryan.bottomnavigation.ViewPagerAdapter;

public class LaporanFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_laporan, container, false);

        tabLayout = (TabLayout) view.findViewById(R.id.tablayout_laporan);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager_laporan);
        adapter = new ViewPagerAdapter(getChildFragmentManager());

        adapter.AddFragment(new FragmentPesanan(), "Pesanan");
        adapter.AddFragment(new FragmentRiwayat(), "Riwayat");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

}

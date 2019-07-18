package com.codeian.whmcsmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.codeian.whmcsmanager.Fragments.Address;
import com.codeian.whmcsmanager.Fragments.Domain;
import com.codeian.whmcsmanager.Fragments.Products;
import com.codeian.whmcsmanager.ViewPager.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class SingleClient extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private CardView cardView;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_client);

        tabLayout = findViewById(R.id.tabSingleClient);
        cardView = findViewById(R.id.cardViewSingleClient);
        viewPager = findViewById(R.id.viewPagerSingleClient);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Adding Frags
        viewPagerAdapter.addFrags(new Products(), "Products");
        viewPagerAdapter.addFrags(new Domain(), "Domain");
        viewPagerAdapter.addFrags(new Address(), "Address");

        //setup Adapter
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}

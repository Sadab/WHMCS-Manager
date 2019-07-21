package com.codeian.whmcsmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.codeian.whmcsmanager.Fragments.Address;
import com.codeian.whmcsmanager.Fragments.Domain;
import com.codeian.whmcsmanager.Fragments.Products;
import com.codeian.whmcsmanager.ViewPager.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.jar.Attributes;

import static android.os.Build.ID;
import static com.codeian.whmcsmanager.ClientList.CLIENT_ID;
import static com.codeian.whmcsmanager.ClientList.EMAIL;
import static com.codeian.whmcsmanager.ClientList.NAME;

public class SingleClient extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private CardView cardView;
    private ViewPagerAdapter viewPagerAdapter;
    private TextView nameID, emailID;
    private String name, id, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_client);

        //Initializing
        nameID = findViewById(R.id.nameIDSingleClient);
        emailID = findViewById(R.id.emailIDSingleClient);

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

        //Getting Data From ClientList
        Intent intent = getIntent();
        name = intent.getStringExtra(NAME);
        id = intent.getStringExtra(CLIENT_ID);
        email = intent.getStringExtra(EMAIL);
        setUpDetails();
        Toast.makeText(SingleClient.this, "Hi " + name, Toast.LENGTH_LONG).show();
        //Toast.makeText(SingleClient.this, "Id "+ ID, Toast.LENGTH_LONG).show();
        Log.d("client id", id);
    }

    private void setUpDetails(){
        nameID.setText(name);
        emailID.setText(email);
    }
}

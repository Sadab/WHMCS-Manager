package com.codeian.whmcsmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.codeian.whmcsmanager.Fragments.Address;
import com.codeian.whmcsmanager.Fragments.Domain;
import com.codeian.whmcsmanager.Fragments.Products;
import com.codeian.whmcsmanager.Model.Client.Products.ClientProductsRoot;
import com.codeian.whmcsmanager.Network.ApiHandler;
import com.codeian.whmcsmanager.Network.GetService;
import com.codeian.whmcsmanager.ViewPager.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.jar.Attributes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    public String name, id, email;
    private String accessKey = BuildConfig.accessKey;
    private String username = BuildConfig.username;
    private String password = BuildConfig.password;

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
        viewPagerAdapter.addFrags(new Address(), "Actions");

        //setup Adapter
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        //Getting Data From ClientList
        Intent intent = getIntent();
        name = intent.getStringExtra(NAME);
        id = intent.getStringExtra(CLIENT_ID);
        email = intent.getStringExtra(EMAIL);

        setUpDetails();
        clientProductList();
    }

    public String getClientId() {
        return id;
    }

    private void setUpDetails(){
        nameID.setText(name);
        emailID.setText(email);
    }

    private void clientProductList(){
        GetService service = ApiHandler.getRetrofitInstance().create(GetService.class);
        Call<ClientProductsRoot> clientProductsRootCall = service.getClientProductsService("GetClientsProducts", username, password, accessKey, "json", id);
        clientProductsRootCall.enqueue(new Callback<ClientProductsRoot>() {
            @Override
            public void onResponse(Call<ClientProductsRoot> call, Response<ClientProductsRoot> response) {
                ClientProductsRoot body = response.body();
                com.codeian.whmcsmanager.Model.Client.Products.Products productsList = body.getProducts();
            }
            @Override
            public void onFailure(Call<ClientProductsRoot> call, Throwable t) {
                //@TODO Write EdgeCase
            }
        });
    }

}

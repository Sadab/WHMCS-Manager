package com.codeian.whmcsmanager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import com.codeian.whmcsmanager.Adapters.ClientsAdapter;
import com.codeian.whmcsmanager.Model.Client.Client;
import com.codeian.whmcsmanager.Model.Client.Clients;
import com.codeian.whmcsmanager.Model.Client.DataModel;
import com.codeian.whmcsmanager.Network.ApiHandler;
import com.codeian.whmcsmanager.Network.GetService;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientList extends AppCompatActivity implements ClientsAdapter.OnClientClientClickListener {

    private RecyclerView recyclerView;
    private ClientsAdapter adapter;
    private ShimmerFrameLayout shimmerFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_list);

        //Initialize things
        shimmerFrameLayout = findViewById(R.id.shimmerIt);

        //Initialize the RecyclerView
        setRecyclerView();

        //Get Client List
        getClientList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        shimmerFrameLayout.startShimmer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        shimmerFrameLayout.stopShimmer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.actionBarSearch);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    private void setRecyclerView(){
        recyclerView = findViewById(R.id.clientListView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void getClientList(){

        GetService service = ApiHandler.getRetrofitInstance().create(GetService.class);
        Call<DataModel> dataModelClient = service.getClients();
        dataModelClient.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                DataModel body = response.body();
                if(response.isSuccessful()){
                    if(body != null){
                        Clients clientList = body.getClients();
                        adapter = new ClientsAdapter(ClientList.this, clientList.getClient(), ClientList.this);
                        shimmerFrameLayout.stopShimmer();
                        shimmerFrameLayout.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                        recyclerView.setAdapter(adapter);
                        //recyclerView.setAdapter(new ClientsAdapter(ClientList.this, clientList.getClient()));
                        clientList.getClient().size();
                    }
                }
                else {
                    //@TODO have to write some edge case codes here
                }
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

    @Override
    public void onClientClick(int position) {
        Log.d("Clicked @ ", String.valueOf(position));
        Toast.makeText(this, "Clicked @ "+ position, Toast.LENGTH_LONG).show();
        Intent singleClientIntent = new Intent(ClientList.this, SingleClient.class);
        startActivity(singleClientIntent);
    }
}

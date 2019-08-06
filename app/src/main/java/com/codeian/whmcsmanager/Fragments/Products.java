package com.codeian.whmcsmanager.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codeian.whmcsmanager.Adapters.ClientProductAdapter;
import com.codeian.whmcsmanager.BuildConfig;
import com.codeian.whmcsmanager.Model.Client.Products.ClientProductsRoot;
import com.codeian.whmcsmanager.Network.ApiHandler;
import com.codeian.whmcsmanager.Network.GetService;
import com.codeian.whmcsmanager.R;
import com.codeian.whmcsmanager.SingleClient;
import com.facebook.shimmer.ShimmerFrameLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Products extends Fragment {

    View view;
    RecyclerView recyclerView;
    ClientProductAdapter adapter;
    ShimmerFrameLayout shimmerFrameLayout;
    private String accessKey = BuildConfig.accessKey;
    private String username = BuildConfig.username;
    private String password = BuildConfig.password;
    private TextView emptyProduct;

    public Products() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.single_client_products_frag, container, false);
        shimmerFrameLayout = view.findViewById(R.id.shimmerItProduct);
        recyclerView = view.findViewById(R.id.clientProductListView);
        emptyProduct = view.findViewById(R.id.empty_view);

        setRecyclerView();
        SingleClient singleClient = (SingleClient) getActivity();
        String id = singleClient.getMyData();
        getProductList(id);
        return view;
    }


    @Override
    public void onPause() {
        super.onPause();
        shimmerFrameLayout.stopShimmer();
    }

    @Override
    public void onResume() {
        super.onResume();
        shimmerFrameLayout.startShimmer();
    }

    private void setRecyclerView() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    private void getProductList(String id){
        GetService service = ApiHandler.getRetrofitInstance().create(GetService.class);
        Call<ClientProductsRoot> clientProductsRootCall = service.getClientProductsService("GetClientsProducts", username, password, accessKey, "json", id);
        //Log.d("URL", service.getClientProductsService("GetClientsProducts", username, password, accessKey, "json", id).request().url().toString());
        clientProductsRootCall.enqueue(new Callback<ClientProductsRoot>() {
            @Override
            public void onResponse(Call<ClientProductsRoot> call, Response<ClientProductsRoot> response) {
                if(response.isSuccessful()) {
                    ClientProductsRoot body = response.body();
                    com.codeian.whmcsmanager.Model.Client.Products.Products productsList = body.getProducts();
                    adapter = new ClientProductAdapter(getContext(), productsList.getProduct());
                    shimmerFrameLayout.stopShimmer();
                    shimmerFrameLayout.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    recyclerView.setAdapter(adapter);
                    productsList.getProduct().size();
                }
            }
            @Override
            public void onFailure(Call<ClientProductsRoot> call, Throwable t) {
                recyclerView.setVisibility(View.GONE);
                shimmerFrameLayout.setVisibility(View.GONE);
                emptyProduct.setVisibility(View.VISIBLE);
            }
        });
    }


}

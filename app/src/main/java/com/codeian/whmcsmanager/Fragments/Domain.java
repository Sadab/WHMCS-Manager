package com.codeian.whmcsmanager.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codeian.whmcsmanager.Adapters.ClientDomainAdapter;
import com.codeian.whmcsmanager.BuildConfig;
import com.codeian.whmcsmanager.Model.Client.Domain.ClientDomainRoot;
import com.codeian.whmcsmanager.Model.Client.Domain.Domains;
import com.codeian.whmcsmanager.Network.ApiHandler;
import com.codeian.whmcsmanager.Network.GetService;
import com.codeian.whmcsmanager.R;
import com.codeian.whmcsmanager.SingleClient;
import com.facebook.shimmer.ShimmerFrameLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Domain extends Fragment {
    View view;
    RecyclerView recyclerView;
    ClientDomainAdapter adapter;
    ShimmerFrameLayout shimmerFrameLayout;
    private String accessKey = BuildConfig.accessKey;
    private String username = BuildConfig.username;
    private String password = BuildConfig.password;
    private TextView emptyDomain;

    public Domain() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.single_client_domain_frag, container, false);
        shimmerFrameLayout = view.findViewById(R.id.shimmerItDomain);
        recyclerView = view.findViewById(R.id.clientDomainListView);
        emptyDomain = view.findViewById(R.id.empty_view);

        setRecyclerView();
        SingleClient singleClient = (SingleClient) getActivity();
        String id = singleClient.getClientId();
        getDomainList(id);
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

    private void getDomainList(String id){
        GetService service = ApiHandler.getRetrofitInstance().create(GetService.class);
        Call<ClientDomainRoot> clientDomainRootCall = service.getClientDomainService("GetClientsDomains", username, password, accessKey, "json", true, id);

        clientDomainRootCall.enqueue(new Callback<ClientDomainRoot>() {
            @Override
            public void onResponse(Call<ClientDomainRoot> call, Response<ClientDomainRoot> response) {
                if(response.isSuccessful()) {
                    ClientDomainRoot body = response.body();
                    Domains domainsList = body.getDomains();
                    adapter = new ClientDomainAdapter(getContext(), domainsList.getDomain());
                    shimmerFrameLayout.stopShimmer();
                    shimmerFrameLayout.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ClientDomainRoot> call, Throwable t) {
                    recyclerView.setVisibility(View.GONE);
                    shimmerFrameLayout.setVisibility(View.GONE);
                    emptyDomain.setVisibility(View.VISIBLE);
            }
        });
    }
}

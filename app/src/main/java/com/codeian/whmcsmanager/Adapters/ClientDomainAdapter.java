package com.codeian.whmcsmanager.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codeian.whmcsmanager.Model.Client.Domain.Domain;
import com.codeian.whmcsmanager.R;

import java.util.List;

public class ClientDomainAdapter extends RecyclerView.Adapter<ClientDomainAdapter.ClientDomainViewHolder>{
    private Context context;
    private List<Domain> domainList;

    public ClientDomainAdapter(Context context, List<Domain> domainList) {
        this.context = context;
        this.domainList = domainList;
    }

    @NonNull
    @Override
    public ClientDomainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_client_domain, parent, false);
        return new ClientDomainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientDomainViewHolder holder, int position) {
        Domain domain = domainList.get(position);
        holder.domainName.setText(domain.getDomainname());
        holder.registrar.setText(domain.getRegistrar().toUpperCase());
    }

    @Override
    public int getItemCount() {
        return domainList.size();
    }

    public class ClientDomainViewHolder extends RecyclerView.ViewHolder{
        TextView domainName, registrar;

        public ClientDomainViewHolder(@NonNull View itemView) {
            super(itemView);
            domainName = itemView.findViewById(R.id.clientDomainNameTextView);
            registrar = itemView.findViewById(R.id.clientRegistrarTextView);
        }
    }
}

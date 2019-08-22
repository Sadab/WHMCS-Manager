package com.codeian.whmcsmanager.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codeian.whmcsmanager.Model.Client.Products.Product;
import com.codeian.whmcsmanager.R;

import java.util.List;

public class ClientProductAdapter extends RecyclerView.Adapter<ClientProductAdapter.ClientProductViewHolder>{

    private Context context;
    private List<Product> productList;

    public ClientProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ClientProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_client_products, parent, false);
        return new ClientProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.domainName.setText(product.getDomain());
        holder.productName.setText(product.getName());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ClientProductViewHolder extends RecyclerView.ViewHolder{
        TextView domainName, productName;

        public ClientProductViewHolder(@NonNull View itemView) {
            super(itemView);
            domainName = itemView.findViewById(R.id.clientDomainNameTextView);
            productName = itemView.findViewById(R.id.clientProductNameTextView);
        }
    }
}

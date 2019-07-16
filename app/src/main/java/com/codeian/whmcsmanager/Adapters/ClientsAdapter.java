package com.codeian.whmcsmanager.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codeian.whmcsmanager.Model.Client.Client;
import com.codeian.whmcsmanager.Model.Client.DataModel;
import com.codeian.whmcsmanager.R;

import java.util.List;
import java.util.zip.Inflater;

public class ClientsAdapter extends RecyclerView.Adapter<ClientsAdapter.ClientsViewHolder> {

    private Context context;
    private List<Client> dataModelList;

    public ClientsAdapter(Context context, List<Client> dataModelList) {
        this.context = context;
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public ClientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.client_item, parent, false);
        return new ClientsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientsViewHolder holder, int position) {
        Client dataModel = dataModelList.get(position);
        holder.fullName.setText(dataModel.getFirstname()+" "+dataModel.getLastname());
        holder.email.setText(dataModel.getEmail());
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }


    public class ClientsViewHolder extends RecyclerView.ViewHolder {

        TextView fullName, email;

        public ClientsViewHolder(@NonNull View itemView) {
            super(itemView);
            fullName = itemView.findViewById(R.id.clientNameTextView);
            email = itemView.findViewById(R.id.clientEmailTextView);
        }
    }
}

package com.codeian.whmcsmanager.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codeian.whmcsmanager.Model.Client.Client;
import com.codeian.whmcsmanager.R;

import java.util.ArrayList;
import java.util.List;

public class ClientsAdapter extends RecyclerView.Adapter<ClientsAdapter.ClientsViewHolder> implements Filterable{

    private Context context;
    private List<Client> clientModelList;
    private List<Client> clientListFull;
    private OnClientClientClickListener mOnClientClientClickListener;

    public ClientsAdapter(Context context, List<Client> clientModelList, OnClientClientClickListener onClientClientClickListener) {
        this.context = context;
        this.clientModelList = clientModelList;
        this.clientListFull = new ArrayList<>(clientModelList);
        this.mOnClientClientClickListener = onClientClientClickListener;
    }

    @NonNull
    @Override
    public ClientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.client_item, parent, false);
        return new ClientsViewHolder(view, mOnClientClientClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientsViewHolder holder, int position) {
        Client clientModel = clientModelList.get(position);
        holder.fullName.setText(clientModel.getFirstname()+" "+clientModel.getLastname());
        holder.email.setText(clientModel.getEmail());
    }

    @Override
    public int getItemCount() {
        return clientModelList.size();
    }

    @Override
    public Filter getFilter() {
        return clientFilter;
    }

    private Filter clientFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<Client> filteredList = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){
                filteredList.addAll(clientListFull);
            }
            else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for(Client item : clientListFull){
                    if( (item.getFirstname().toLowerCase().contains(filterPattern)) || (item.getLastname().toLowerCase().contains(filterPattern)) || (item.getEmail().toLowerCase().contains(filterPattern)) ){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clientModelList.clear();
            clientModelList.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };


    public class ClientsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView fullName, email;
        OnClientClientClickListener onClientClientClickListener;

        public ClientsViewHolder(@NonNull View itemView, OnClientClientClickListener onClientClientClickListener) {
            super(itemView);
            fullName = itemView.findViewById(R.id.clientNameTextView);
            email = itemView.findViewById(R.id.clientEmailTextView);
            this.onClientClientClickListener = onClientClientClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(onClientClientClickListener != null) {
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION){
                    onClientClientClickListener.onClientClick(position);
                }
            }

            //onClientClientClickListener.onClientClick(getAdapterPosition());
        }
    }

    public interface OnClientClientClickListener{
        void onClientClick(int position);
    }

}

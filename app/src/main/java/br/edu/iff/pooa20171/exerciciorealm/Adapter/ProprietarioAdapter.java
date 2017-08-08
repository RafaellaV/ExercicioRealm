package br.edu.iff.pooa20171.exerciciorealm.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.edu.iff.pooa20171.exerciciorealm.Model.Proprietario;
import br.edu.iff.pooa20171.exerciciorealm.R;


public class ProprietarioAdapter extends RecyclerView.Adapter {

    private List<Proprietario> proprietarios;
    private Context context;
    private static ClickRecyclerViewListener clickRecyclerViewListener;

    public ProprietarioAdapter(List<Proprietario> proprietarios, Context context,ClickRecyclerViewListener clickRecyclerViewListener) {

        this.proprietarios = proprietarios;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.activity_item_proprietario, parent, false);
        ProprietarioViewHolder proprietarioViewHolder = new ProprietarioViewHolder(view);
        return proprietarioViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                                 int position) {

        ProprietarioViewHolder holder = (ProprietarioViewHolder) viewHolder;

        Proprietario proprietario  = proprietarios.get(position) ;

        holder.nome.setText(proprietario.getNome());
        holder.endereco.setText(proprietario.getEndereco());
        holder.bairro.setText(proprietario.getBairro());
        holder.cidade.setText(proprietario.getCidade());
        holder.CNH.setText(proprietario.getCNH());
        holder.telefone.setText(proprietario.getTelefone());
        holder.email.setText(proprietario.getEmail());
        holder.latitude.setText(proprietario.getLatitude());
        holder.longitude.setText(proprietario.getLongitude());



    }

    @Override
    public int getItemCount() {

        return proprietarios.size();
    }

    private void updateItem(int position) {

    }


    private void removerItem(int position) {

    }

    public class ProprietarioViewHolder extends RecyclerView.ViewHolder {

        private final TextView nome;
        private final TextView endereco;
        private final TextView bairro;
        private final TextView cidade;
        private final TextView CNH;
        private final TextView telefone;
        private final TextView email;
        private final TextView latitude;
        private final TextView longitude;



        public ProprietarioViewHolder(View itemView) {
            super(itemView);
            nome = (TextView) itemView.findViewById(R.id.tvNome);
            endereco = (TextView) itemView.findViewById(R.id.tvEndereco);
            bairro = (TextView) itemView.findViewById(R.id.tvBairro);
            cidade =(TextView) itemView.findViewById(R.id.tvCidade);
            CNH =(TextView) itemView.findViewById(R.id.tvCNH);
            telefone =(TextView) itemView.findViewById(R.id.tvTelefone);
            email =(TextView) itemView.findViewById(R.id.tvEmail);
            latitude =(TextView) itemView.findViewById(R.id.tvLatitude);
            longitude =(TextView) itemView.findViewById(R.id.tvLongitude);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(proprietarios.get(getLayoutPosition()));

                }
            });


        }
    }
}
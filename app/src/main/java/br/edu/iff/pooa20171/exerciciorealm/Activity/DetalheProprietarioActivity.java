package br.edu.iff.pooa20171.exerciciorealm.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.iff.pooa20171.exerciciorealm.Model.Proprietario;
import io.realm.Realm;
import br.edu.iff.pooa20171.exerciciorealm.R;

public class DetalheProprietarioActivity extends AppCompatActivity {
    EditText nome, endereco, bairro, cidade, CNH, telefone, email, latitude, longitude;
    Button btsalvar,btalterar, btdeletar;

    int id;
    Proprietario proprietario;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_proprietario);

        nome = (EditText) findViewById(R.id.etNome);
        endereco = (EditText) findViewById(R.id.etEndereco);
        bairro = (EditText) findViewById(R.id.etBairro);
        cidade = (EditText) findViewById(R.id.etCidade);
        CNH = (EditText) findViewById(R.id.etCNH);
        telefone = (EditText) findViewById(R.id.etTelefone);
        email = (EditText) findViewById(R.id.etEmail);
        latitude = (EditText) findViewById(R.id.etLatitude);
        longitude = (EditText) findViewById(R.id.etLongitude);

        btsalvar = (Button) findViewById(R.id.btSalvar);
        btalterar = (Button) findViewById(R.id.btAlterar);
        btdeletar = (Button) findViewById(R.id.btDeletar);

        Intent intent    = getIntent();
        id = (int) intent.getSerializableExtra("id");
        realm = Realm.getDefaultInstance();

        if (id !=0) {
            btsalvar.setEnabled(false);
            btsalvar.setClickable(false);
            btsalvar.setVisibility(View.INVISIBLE);

            proprietario = realm.where(Proprietario.class).equalTo("id",id).findFirst();

            nome.setText(proprietario.getNome());
            endereco.setText(proprietario.getEndereco());
            bairro.setText(proprietario.getBairro());
            cidade.setText(proprietario.getCidade());
            CNH.setText(proprietario.getCNH());
            telefone.setText(proprietario.getTelefone());
            email.setText(proprietario.getEmail());
            latitude.setText(proprietario.getLatitude());
            longitude.setText(proprietario.getLongitude());

        }else{
            btalterar.setEnabled(false);
            btalterar.setClickable(false);
            btalterar.setVisibility(View.INVISIBLE);
            btdeletar.setEnabled(false);
            btdeletar.setClickable(false);
            btdeletar.setVisibility(View.INVISIBLE);

        }



        btsalvar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
            }
        });
        btalterar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                alterar();
            }
        });
        btdeletar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                deletar();
            }
        });


    }

    public void deletar(){
        realm.beginTransaction();
        proprietario.deleteFromRealm();
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Proprietario deletado",Toast.LENGTH_LONG).show();
        this.finish();

    }

    public void salvar() {


        int proximoID = 1;
        if(realm.where(Proprietario.class).max("id") !=null)
            proximoID = realm.where(Proprietario.class).max("id").intValue()+1;

        realm.beginTransaction();
        Proprietario proprietario = new Proprietario();
        proprietario.setId(proximoID);
        proprietario.setNome(nome.getText().toString());
        proprietario.setEndereco(endereco.getText().toString());
        proprietario.setBairro(bairro.getText().toString());
        proprietario.setCidade(cidade.getText().toString());
        proprietario.setCNH(CNH.getText().toString());
        proprietario.setTelefone(telefone.getText().toString());
        proprietario.setEmail(email.getText().toString());
        proprietario.setLatitude(latitude.getText().toString());
        proprietario.setLongitude(longitude.getText().toString());

        realm.copyToRealm(proprietario);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Proprietario Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();

    }
    public void alterar() {

        realm.beginTransaction();

        proprietario.setNome(nome.getText().toString());
        proprietario.setEndereco(endereco.getText().toString());
        proprietario.setBairro(bairro.getText().toString());
        proprietario.setCidade(cidade.getText().toString());
        proprietario.setCNH(CNH.getText().toString());
        proprietario.setTelefone(telefone.getText().toString());
        proprietario.setEmail(email.getText().toString());
        proprietario.setLatitude(latitude.getText().toString());
        proprietario.setLongitude(longitude.getText().toString());


        realm.copyToRealm(proprietario);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Proprietario Alterado",Toast.LENGTH_LONG).show();
        this.finish();

    }
}
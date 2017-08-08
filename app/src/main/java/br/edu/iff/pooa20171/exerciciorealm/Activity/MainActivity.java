package br.edu.iff.pooa20171.exerciciorealm.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import br.edu.iff.pooa20171.exerciciorealm.R;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button BTProprietario = (Button) findViewById(R.id.btProprietarios);

        BTProprietario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProprietarioActivity.class);
                startActivity(intent);

            }
        });


    }
    private Context getContext(){
        return this;
    }

}
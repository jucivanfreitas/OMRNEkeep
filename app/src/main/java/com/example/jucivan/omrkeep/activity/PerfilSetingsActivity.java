package com.example.jucivan.omrkeep.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.example.jucivan.omrkeep.R;
import com.example.jucivan.omrkeep.helper.ConfigureToolbar;

public class PerfilSetingsActivity extends AppCompatActivity {
    private boolean menuconfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_setings);

       // chamaToolbar();



    }

    public void chamaToolbar(){
              //  Toolbar toolbar=findViewById(R.id.toolbar2);
               // toolbar.setTitle("Configurações de Perfil");
              //  setSupportActionBar(toolbar);





            }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_geral,menu);


        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean  onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_voltar_layout:
                finish();

                break;
        }


       return super.onOptionsItemSelected(item);
    }


}

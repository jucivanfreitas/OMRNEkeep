package com.example.jucivan.omrkeep.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.example.jucivan.omrkeep.Fragment.*;
import com.example.jucivan.omrkeep.R;
import com.example.jucivan.omrkeep.helper.configuracaoFirebase;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FirebaseAuth autenticacao;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

     //   FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
     //   fab.setOnClickListener(new View.OnClickListener() {
     //       @Override
     //       public void onClick(View view) {
     //           Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
     //                   .setAction("Action", null).show();
    //        }
    //    });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //ativa uso de fragments
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.view_pager, new BemVindoFragment()).commit();

        //autenticaçoes e bd
        autenticacao = configuracaoFirebase.getFirebaseAutenticacao();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);

        return true;
    }

    @Override
    //Menu bar top
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()){
            case R.id.action_Sair: deslogarUsuario();
            case R.id.action_settings:
                Intent intent = new Intent(Main2Activity.this,PerfilSetingsActivity.class);
                startActivity(intent);
           // case

        }


        //   int id = item.getItemId();

     //   //noinspection SimplifiableIfStatement
     //   if (id == R.id.action_settings) {
      //      return true;
      //  }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        //implementa fragmento
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();


        switch  (item.getItemId()){

           // case R.id.app_bar_search_sites:
              //  fragmentTransaction.replace(R.id.view_pager,new PesquisaFragment()).commit();
              //  return true;
            case R.id.solEntrada:
                fragmentTransaction.replace(R.id.view_pager, new SolicitaAcessoFragment()).commit();
                return true;

                //menu infra
            case R.id.menu_infra_preventivas:
                Intent intent = new Intent(Main2Activity.this,PreventivaInfraActivity.class);
                startActivity(intent);
            case R.id.menu_infra_melhorias:
                fragmentTransaction.replace(R.id.view_pager,new InfraMelhoriasFragment()).commit();
                return true;
            case R.id.menu_infra_problemas:
                fragmentTransaction.replace(R.id.view_pager, new ReportarProblemaFragment()).commit();
                return true;

            case R.id.menu_OMR_melhorias:
                fragmentTransaction.replace(R.id.view_pager, new InfraMelhoriasFragment()).commit();
                return true;
            case R.id.menu_omr_problemas:
                fragmentTransaction.replace(R.id.view_pager, new ReportarProblemaFragment()).commit();
                return true;


        }

        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

            //grupo vendor operações de vendo e gerais
        }else if (id==R.id.app_bar_search_sites){

        }else if (id==R.id.solEntrada){

        }else if (id==R.id.entrada_historico){
            fragmentTransaction.replace(R.id.view_pager, new HistoricoAcessoFragment()).commit();

        }else if (id==R.id.menu_inconformidade){
            fragmentTransaction.replace(R.id.view_pager, new ReportarProblemaFragment()).commit();

        }else if (id==R.id.menu_omr_problemas){
            fragmentTransaction.replace(R.id.view_pager, new ReportarProblemaFragment()).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

// TODO: 22/01/2019 parei na cosntrução dos grupos de menu da actvity main 2 . preciso descobrir como selecionar visibilidade do grupo de menus  e como mostrar visualmente os itens clicados//



    private void deslogarUsuario(){
            try {
                autenticacao.signOut();
                Intent intent = new Intent(Main2Activity.this,LoginActivity.class);
                startActivity(intent);
                finish();

            }catch (Exception e){
                e.printStackTrace();
            }

    }
}

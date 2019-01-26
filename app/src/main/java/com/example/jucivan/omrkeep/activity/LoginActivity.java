package com.example.jucivan.omrkeep.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.jucivan.omrkeep.Model.Usuario;
import com.example.jucivan.omrkeep.R;
import com.example.jucivan.omrkeep.helper.configuracaoFirebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.EnumSet;

public class LoginActivity extends AppCompatActivity {
    private EditText email, senha;
    private ProgressBar progressBar;
    private Button btnEntrar;
    private Usuario usuario;
    private FirebaseAuth autenticacao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuariologado();
        inicializarComponentes();
        //fazer login
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                realizarLogin();
            }
        });
    }


    public void abrirCadUser(View view){

        Intent i =new Intent(LoginActivity.this,CadastroLoginActivity.class);
        startActivity(i);
    }

    public void inicializarComponentes(){


        email =findViewById(R.id.login_email);
        senha =findViewById(R.id.login_senha);

        btnEntrar =findViewById(R.id.btn_login);
        progressBar =findViewById(R.id.progressBarLogin);



    }

    public void realizarLogin(){

        String txtEmail             =email.getText().toString();
        String txtSenha             =senha.getText().toString();

        if (!txtEmail.isEmpty()){
            if (!txtSenha.isEmpty()){
                usuario =new Usuario();
                usuario.setEmail(txtEmail);
                usuario.setSenha(txtSenha);

                validarLogin(usuario);
                progressBar.setVisibility(View.VISIBLE);


            }else{Toast.makeText(LoginActivity.this,"Digite uma senha!",Toast.LENGTH_SHORT).show();}

        }else{Toast.makeText(LoginActivity.this,"Preencha o campo E-mail para acesso",Toast.LENGTH_SHORT).show();}
    }

    public void usuariologado(){
        autenticacao =configuracaoFirebase.getFirebaseAutenticacao();
        if (autenticacao.getCurrentUser()!=null) {
            startActivity(new Intent(getApplicationContext(), Main2Activity.class));

            finish();
        }

    }

    public void validarLogin(Usuario usuario){
        autenticacao    = configuracaoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(usuario.getEmail(),usuario.getSenha()).addOnCompleteListener(
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            progressBar.setVisibility(View.GONE);
                            startActivity(new Intent(getApplicationContext(),Main2Activity.class));

                            finish();


                        }else {

                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(LoginActivity.this,
                                    "Erro ao fazer login",
                                    Toast.LENGTH_LONG).show();


                        }

                    }
                }
        );


    }





}

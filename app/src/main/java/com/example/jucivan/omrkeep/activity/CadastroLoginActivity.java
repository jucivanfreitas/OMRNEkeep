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
import com.google.firebase.auth.*;

public class CadastroLoginActivity extends AppCompatActivity {
    private EditText nome, matricula, telefone, empresa, funcao,email, senha;
    private Button btncadastrar;
    private ProgressBar progressBar;

    private Usuario usuario;
    private FirebaseAuth autenticacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_login);


        inicializarComponentes();

        btncadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checarCamposCadastro();



            }
        });
    }

    public void inicializarComponentes(){

        nome =findViewById(R.id.cadNome);
        matricula =findViewById(R.id.cadMatricula);
        telefone =findViewById(R.id.cad_telefone);
        empresa =findViewById(R.id.cadEmpresa);
        funcao =findViewById(R.id.cadFunção);
        email =findViewById(R.id.cadEmail);
        senha =findViewById(R.id.cadSenha);

        btncadastrar =findViewById(R.id.btnCadastrarUsuario);
        progressBar =findViewById(R.id.progressBarcadastrousuario);



    }

    public void checarCamposCadastro(){

        String txtNome              =nome.getText().toString();
        String txtmatricula         =matricula.getText().toString();
        String txtTelefone          =telefone.getText().toString();
        String txtEmpresa           =empresa.getText().toString();
        String txtFuncao            =funcao.getText().toString();
        String txtEmail             =email.getText().toString();
        String txtSenha             =senha.getText().toString();



        if (!txtNome.isEmpty()){
            if (!txtmatricula.isEmpty()){
                if (!txtEmpresa.isEmpty()){
                    if (!txtEmail.isEmpty()){
                        if (!txtSenha.isEmpty()){

                            usuario =new Usuario();
                            usuario.setNome(txtNome);
                            usuario.setMatricula(txtmatricula);
                            usuario.setTelefone(txtTelefone);
                            usuario.setEmpresa(txtEmpresa);
                            usuario.setFuncao(txtFuncao);
                            usuario.setEmail(txtEmail);
                            usuario.setSenha(txtSenha);
                                cadastrarUsuario(usuario);



                            progressBar.setVisibility(View.VISIBLE);

                        }else{Toast.makeText(CadastroLoginActivity.this,"Preencha o Campo senha",Toast.LENGTH_SHORT).show();}

                    }else{Toast.makeText(CadastroLoginActivity.this,"Preencha o campo E-mail a ser utilizado para acesso",Toast.LENGTH_SHORT).show();}

                }else{Toast.makeText(CadastroLoginActivity.this,"Preencha o campo empresa",Toast.LENGTH_SHORT).show();}

            }else{Toast.makeText(CadastroLoginActivity.this,"Preencha o Campo Matrícula com matrícula ou CPF",Toast.LENGTH_SHORT).show();}
        }else{Toast.makeText(CadastroLoginActivity.this,"Preencha o Campo Nome",Toast.LENGTH_SHORT).show();}

    }

    public void cadastrarUsuario(Usuario usuario){
        autenticacao = configuracaoFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(),usuario.getSenha()
        ).addOnCompleteListener(
                this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){

                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(CadastroLoginActivity.this,
                                    "Usuário cadastrado com Sucesso ",
                                    Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),Main2Activity.class));
                            finish();


                        }else{ progressBar.setVisibility(View.GONE);

                        String erroExcessao="";
                        try {
                            throw task.getException();
                        }catch (FirebaseAuthWeakPasswordException e){
                            erroExcessao= "Digite uma senha mais forte";
                        }catch (FirebaseAuthInvalidCredentialsException e) {
                            erroExcessao = "Digite um E-mail válido";
                        }catch (FirebaseAuthUserCollisionException e){
                            erroExcessao= "Este Email já foi Cadastrado";
                        } catch (Exception e) {
                            erroExcessao= "Erro ao cadastrar usuário"+e.getMessage();
                            e.printStackTrace();
                        }
                            Toast.makeText(CadastroLoginActivity.this,
                                    "Erro: "+erroExcessao,
                                    Toast.LENGTH_LONG).show();

                        }

                    }
                }
        );



    }

}

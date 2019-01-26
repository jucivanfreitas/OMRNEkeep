package com.example.jucivan.omrkeep.helper;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class configuracaoFirebase {

    public static DatabaseReference referenciaFirebase;
    public static FirebaseAuth referenciaAUtenticacao;
    /// retorna instancia do firebase

    public static FirebaseAuth getFirebaseAutenticacao(){

        if (referenciaAUtenticacao==null){
            referenciaAUtenticacao      =FirebaseAuth.getInstance();

        }return referenciaAUtenticacao;

    }

    public static DatabaseReference getFirebase (){

        if (referenciaFirebase==null){
            referenciaFirebase      =FirebaseDatabase.getInstance().getReference();

        }return referenciaFirebase;

    }

}

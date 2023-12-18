/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import utiles.Utiles;

/**
 *
 * @author profesor
 */
public class ConexionDB {

    public static Firestore db;

    public static void conectarFirebase() {
        try {
            // Use a service account
            InputStream serviceAccount = new FileInputStream("serviceAccount.json");
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(credentials).build();
            FirebaseApp.initializeApp(options);

            db = FirestoreClient.getFirestore();
            System.out.println(Utiles.ANSI_GREEN+"modelo.ConexionBD.conectarFirebase(): ÉXITO AL CONECTAR A LA DB!!");
        } catch (IOException e) {
            System.err.println(Utiles.ANSI_RED+ "modelo.ConexionBD.conectarFirebase(): Error al conectar a la base de datos");
            System.err.println(Utiles.ANSI_RED+"Error: " + e.getMessage());
        }

    }

}

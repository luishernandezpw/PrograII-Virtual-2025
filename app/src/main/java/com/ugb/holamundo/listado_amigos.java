package com.ugb.holamundo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class listado_amigos extends Activity {
    Bundle parametros = new Bundle();
    FloatingActionButton fab;
    ListView lts;
    Cursor cursorAmigos;
    amigos misAmigos;
    final ArrayList<amigos> amigosArrayList = new ArrayList<amigos>();
    JSONArray jsonArray;
    JSONObject jsonObject;
    obtenerDatosServidor datosServidor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_amigos);

        fab = findViewById(R.id.fabAgregarAmigos);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parametros.putString("accion","nuevo");
                abrirActividad(parametros);
            }
        });
        obtenerDatosAmigos();
    }
    private void abrirActividad(Bundle parametros){
        Intent abrirActividad = new Intent(getApplicationContext(), MainActivity.class);
        abrirActividad.putExtras(parametros);
        startActivity(abrirActividad);
    }
    private void mostrarDatosAmigos(){
        try{
            if( jsonArray.length()>0 ){
                lts = findViewById(R.id.ltsAmigos);
                amigosArrayList.clear();

                JSONObject misDatosJsonObject;
                for (int i=0; i<jsonArray.length(); i++){
                    misDatosJsonObject = jsonArray.getJSONObject(i).getJSONObject("key");
                    misAmigos = new amigos(
                            misDatosJsonObject.getString("_id"),//_id
                            misDatosJsonObject.getString("_rev"),//_rev
                            misDatosJsonObject.getString("idAmigo"),//idAmigo
                            misDatosJsonObject.getString("nombre"),//nombre
                            misDatosJsonObject.getString("direccion"),//direccion
                            misDatosJsonObject.getString("telefono"),//telefono
                            misDatosJsonObject.getString("email"), //email
                            misDatosJsonObject.getString("dui") //email
                    );
                    amigosArrayList.add(misAmigos);
                }
                adaptadorAmigos adaterAmigos = new adaptadorAmigos(listado_amigos.this, amigosArrayList);
                lts.setAdapter(adaterAmigos);
                registerForContextMenu(lts);
            }else{
                mostrarMsg("No hay datos que mostrar...");
                parametros.putString("accion","nuevo");
                abrirActividad(parametros);
            }
        }catch (Exception e){
            mostrarMsg("Error al mostrar: "+e.getMessage());
        }
    }
    private void obtenerDatosAmigos(){
        try{
            datosServidor = new obtenerDatosServidor();
            String datos = datosServidor.execute().get();
            jsonObject = new JSONObject(datos);
            jsonArray = jsonObject.getJSONArray("rows");
            mostrarDatosAmigos();
        }catch (Exception e){
            mostrarMsg("Error al intentar obtener datos desde el servidor: "+ e.getMessage());
        }
    }
    void mostrarMsg(String msg){
        Toast.makeText(listado_amigos.this, msg, Toast.LENGTH_LONG).show();
    }
}
package com.example.pruebaandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Actividad1();
        //Actividad2();
        //Actividad3();
    }

    private void Actividad1(){
        setContentView(R.layout.actividad1_layout);

        final ProgressBar progressBar = findViewById(R.id.carga);
        final Button boton = findViewById(R.id.botonAcceder);
        final ImageView imagen = findViewById(R.id.check);

        if (progressBar.isIndeterminate()){
            Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    progressBar.setAlpha(0);
                    boton.setAlpha(1);
                    imagen.setAlpha(1f);

                }
            };
            handler.postDelayed(runnable,5*1000);
        }

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Actividad2();
            }
        });

    }



    private void Actividad2(){
        setContentView(R.layout.actividad2_layout);

        final CheckBox checkBoxRecordatorio = findViewById(R.id.checkboxRecordatorio);
        final Button botonAceptar = findViewById(R.id.botonAceptar);
        final EditText editTextNombre = findViewById(R.id.editTextNombre);
        final EditText editTextFecha = findViewById(R.id.editTextFecha);
        final TextView mensaje = findViewById(R.id.mensaje);

        final WebView gif = findViewById(R.id.gif);


        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoMensaje = "";
                String nombre = editTextNombre.getText().toString();
                String fecha = editTextFecha.getText().toString();
                if (nombre.equals("") & !fecha.equals("")){
                    textoMensaje = "ERROR: No has escrito el nombre";
                }else if (!nombre.equals("") & fecha.equals("")){
                    textoMensaje = "ERROR: No has escrito el la fecha";
                } else if (nombre.equals("") & fecha.equals("")){
                    textoMensaje = "ERROR: No has escrito ningun dato";
                    gif.loadUrl("https://i.giphy.com/media/vyTnNTrs3wqQ0UIvwE/giphy.webp");
                } else if (!checkBoxRecordatorio.isChecked()){
                    textoMensaje = "¡Hola " + nombre + "!" + "Has nacido el " + fecha + ".";
                } else  if (checkBoxRecordatorio.isChecked()){
                    textoMensaje = "¡Hola " + nombre + "!" + "Has nacido el " + fecha + "." + " Se ha creado un recordatorio";
                }

                mensaje.setText(textoMensaje);
            }
        });

    }
    private void Actividad3(){
        setContentView(R.layout.actividad3_layout);

        final RatingBar estrellas = findViewById(R.id.estrellas);
        final WebView gif = findViewById(R.id.imagen);

        gif.getSettings().setJavaScriptEnabled(true);
        gif.getSettings().setUseWideViewPort(true);
        gif.setWebViewClient(new WebViewClient());





        estrellas.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                if (v == 1){
                    gif.loadUrl("https://media.tenor.com/GIbER2Fy3UUAAAAd/spiderman-sad-spiderman.gif");
                }
                if (v == 2){
                    gif.loadUrl("https://i.giphy.com/media/4pMX5rJ4PYAEM/giphy.webp");
                }
                if (v == 3){
                    gif.loadUrl("https://www.icegif.com/wp-content/uploads/2022/01/icegif-982.gif");
                }
                if (v == 4){
                    gif.loadUrl("https://media.tenor.com/ZHEzSWSO4WsAAAAd/optimus-prime-griddy.gif");
                }
                if (v == 5){
                    gif.loadUrl("https://media.tenor.com/4yEuW6bbRo0AAAAi/gato.gif");
                }

            }
        });

    }
}
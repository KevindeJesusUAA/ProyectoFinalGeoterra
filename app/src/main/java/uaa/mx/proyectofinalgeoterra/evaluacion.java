package uaa.mx.proyectofinalgeoterra;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;
public class evaluacion extends AppCompatActivity implements OnMapReadyCallback {

    // Variable para almacenar la respuesta correcta
    private String respuestaCorrecta = "c. México";
    private String respuestaCorrecta2 = "a. Brasil";
    private String respuestaCorrecta3 = "d. Coliseo";
    private String respuestaCorrecta4 = "b. Machu Pichu";

    private String respuestaCorrecta5 = "a. Taj Mahal";
    private Button btnRespuesta1, btnRespuesta2, btnRespuesta3, btnRespuesta4, btnRespuesta5, btnRespuesta6, btnRespuesta7, btnRespuesta8;
    private Button btnRespuesta9, btnRespuesta10, btnRespuesta11, btnRespuesta12, btnRespuesta13, btnRespuesta14, btnRespuesta15, btnRespuesta16;
    private Button btnRespuesta17, btnRespuesta18, btnRespuesta19, btnRespuesta20;
    private String respuestaSeleccionada = "";
    private String respuestaSeleccionada2 = "";

    private String respuestaSeleccionada3 = "";
    private String respuestaSeleccionada4 = "";
    private String respuestaSeleccionada5 = "";
    private Button botonSeleccionado = null;
    private Button botonSeleccionado2 = null;
    private Button botonSeleccionado3 = null;
    private Button botonSeleccionado4 = null;
    private Button botonSeleccionado5 = null;

    private GoogleMap mMap;

    private MediaPlayer mediaPlayer; // Variable para el reproductor de música
    private boolean musicaReproducida = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evaluacion);

        // Inicializar el reproductor de música y cargar el archivo de música desde res/raw
        mediaPlayer = MediaPlayer.create(this, R.raw.preguntados);

        // Configurar para que la música no se repita en bucle
        mediaPlayer.setLooping(false);

        // Establecer un listener para detectar cuando la reproducción ha finalizado
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // Liberar recursos del MediaPlayer
                mediaPlayer.release();
                mediaPlayer = null;
                // Marcar la música como reproducida
                musicaReproducida = true;
            }
        });

        // Iniciar la reproducción de música de fondo
        mediaPlayer.start();

        // Obtener referencias a los botones
        btnRespuesta1 = findViewById(R.id.btnRespuesta1);
        btnRespuesta2 = findViewById(R.id.btnRespuesta2);
        btnRespuesta3 = findViewById(R.id.btnRespuesta3);
        btnRespuesta4 = findViewById(R.id.btnRespuesta4);
        btnRespuesta5 = findViewById(R.id.btnRespuesta5);
        btnRespuesta6 = findViewById(R.id.btnRespuesta6);
        btnRespuesta7 = findViewById(R.id.btnRespuesta7);
        btnRespuesta8 = findViewById(R.id.btnRespuesta8);
        btnRespuesta9 = findViewById(R.id.btnRespuesta9);
        btnRespuesta10 = findViewById(R.id.btnRespuesta10);
        btnRespuesta11 = findViewById(R.id.btnRespuesta11);
        btnRespuesta12 = findViewById(R.id.btnRespuesta12);
        btnRespuesta13 = findViewById(R.id.btnRespuesta13);
        btnRespuesta14 = findViewById(R.id.btnRespuesta14);
        btnRespuesta15 = findViewById(R.id.btnRespuesta15);
        btnRespuesta16 = findViewById(R.id.btnRespuesta16);
        btnRespuesta17 = findViewById(R.id.btnRespuesta17);
        btnRespuesta18 = findViewById(R.id.btnRespuesta18);
        btnRespuesta19 = findViewById(R.id.btnRespuesta19);
        btnRespuesta20 = findViewById(R.id.btnRespuesta20);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        // Establecer OnClickListener para cada botón
        btnRespuesta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada = "a. Brasil";
                validarRespuesta(btnRespuesta1);
            }
        });

        btnRespuesta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada = "b. Estados Unidos";
                validarRespuesta(btnRespuesta2);
            }
        });

        btnRespuesta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada = "c. México";
                validarRespuesta(btnRespuesta3);
            }
        });

        btnRespuesta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada = "d. Perú";
                validarRespuesta(btnRespuesta4);
            }
        });

        // Establecer OnClickListener para cada botón
        btnRespuesta5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada2 = "a. Brasil";
                validarRespuesta2(btnRespuesta5);
            }
        });

        btnRespuesta6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada2 = "b. Estados Unidos";
                validarRespuesta2(btnRespuesta6);
            }
        });

        btnRespuesta7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada2 = "c. México";
                validarRespuesta2(btnRespuesta7);
            }
        });

        btnRespuesta8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada2 = "d. Perú";
                validarRespuesta2(btnRespuesta8);
            }
        });


        btnRespuesta9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada3 = "a. Cristo Redentor";
                validarRespuesta3(btnRespuesta9);
            }
        });

        btnRespuesta10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada3 = "b. La Gran Muralla";
                validarRespuesta3(btnRespuesta10);
            }
        });

        btnRespuesta11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada3 = "c. Petra";
                validarRespuesta3(btnRespuesta11);
            }
        });

        btnRespuesta12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada3 = "d. Coliseo";
                validarRespuesta3(btnRespuesta12);
            }
        });

        btnRespuesta13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada4 = "a. Taj Mahal";
                validarRespuesta4(btnRespuesta13);
            }
        });

        btnRespuesta14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada4 = "b. Machu Pichu";
                validarRespuesta4(btnRespuesta14);
            }
        });

        btnRespuesta15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada4 = "c. Cristo Redentor";
                validarRespuesta4(btnRespuesta15);
            }
        });

        btnRespuesta16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada4 = "d. Chichen Itza";
                validarRespuesta4(btnRespuesta16);
            }
        });

        btnRespuesta17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada5 = "a. Taj Mahal";
                validarRespuesta5(btnRespuesta17);
            }
        });

        btnRespuesta18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada5 = "b. Machu Pichu";
                validarRespuesta5(btnRespuesta18);
            }
        });

        btnRespuesta19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada5 = "c. Cristo Redentor";
                validarRespuesta5(btnRespuesta19);
            }
        });

        btnRespuesta20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada5 = "d. Chichen Itza";
                validarRespuesta5(btnRespuesta20);
            }
        });


        // Establecer OnClickListener para el botón "Enviar"
        findViewById(R.id.btnEnviar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llamar a la función para validar la respuesta
                //validarRespuestaSeleccionada();

                // Crear un Intent para pasar a la siguiente actividad
                Intent intent = new Intent(evaluacion.this, resultados.class);

                // Poner las respuestas seleccionadas como extras en el Intent
                intent.putExtra("respuestaSeleccionada1", respuestaSeleccionada);
                intent.putExtra("respuestaSeleccionada2", respuestaSeleccionada2);
                intent.putExtra("respuestaSeleccionada3", respuestaSeleccionada3);
                intent.putExtra("respuestaSeleccionada4", respuestaSeleccionada4);
                intent.putExtra("respuestaSeleccionada5", respuestaSeleccionada5);

                // Iniciar la siguiente actividad
                startActivity(intent);
            }
        });

        WebView webView = findViewById(R.id.coliseo);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://mural.uv.es/hecesla/imagenes/anigifColiseo.gif");

        WebView webView2 = findViewById(R.id.machu_pichu);
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.loadUrl("https://i.makeagif.com/media/2-22-2016/URu7XO.gif");

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(27.1750151, 78.0421552);
        mMap.addMarker(new MarkerOptions()
                .position(sydney)
                .title("Taj Mahal"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    private void validarRespuesta(Button btnRespuesta) {
        // Restablecer el color de fondo del botón previamente seleccionado
        if (botonSeleccionado != null) {
            resetearColoresBotones();
        }
        // Cambiar el color de fondo del botón seleccionado
        btnRespuesta.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonSeleccionado)));
        // Actualizar el botón seleccionado actual
        botonSeleccionado = btnRespuesta;

    }

    private void validarRespuesta2(Button btnRespuesta2) {
        // Restablecer el color de fondo del botón previamente seleccionado
        if (botonSeleccionado2 != null) {
            resetearColoresBotones2();
        }
        btnRespuesta2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonSeleccionado)));
        // Actualizar el botón seleccionado actual
        botonSeleccionado2 = btnRespuesta2;
    }

    private void validarRespuesta3(Button btnRespuesta3) {
        // Restablecer el color de fondo del botón previamente seleccionado
        if (botonSeleccionado3 != null) {
            resetearColoresBotones3();
        }
        btnRespuesta3.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonSeleccionado)));
        // Actualizar el botón seleccionado actual
        botonSeleccionado3 = btnRespuesta3;
    }

    private void validarRespuesta4(Button btnRespuesta4) {
        // Restablecer el color de fondo del botón previamente seleccionado
        if (botonSeleccionado4 != null) {
            resetearColoresBotones4();
        }
        btnRespuesta4.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonSeleccionado)));
        // Actualizar el botón seleccionado actual
        botonSeleccionado4 = btnRespuesta4;
    }

    private void validarRespuesta5(Button btnRespuesta5) {
        // Restablecer el color de fondo del botón previamente seleccionado
        if (botonSeleccionado5 != null) {
            resetearColoresBotones5();
        }
        btnRespuesta5.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonSeleccionado)));
        // Actualizar el botón seleccionado actual
        botonSeleccionado5 = btnRespuesta5;
    }

    private void validarRespuestaSeleccionada() {
        // Comparar la respuesta seleccionada con la respuesta correcta
        if (respuestaSeleccionada.equals(respuestaCorrecta)) {
            // La respuesta es correcta
            Toast.makeText(this, "Respuesta correcta", Toast.LENGTH_SHORT).show();
        } else {
            // La respuesta es incorrecta
            Toast.makeText(this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
        }// Comparar la respuesta seleccionada con la respuesta correcta
        if (respuestaSeleccionada2.equals(respuestaCorrecta2)) {
            // La respuesta es correcta
            Toast.makeText(this, "Respuesta correcta2", Toast.LENGTH_SHORT).show();
        } else {
            // La respuesta es incorrecta
            Toast.makeText(this, "Respuesta incorrecta2", Toast.LENGTH_SHORT).show();
        }
        // Comparar la respuesta seleccionada con la respuesta correcta
        if (respuestaSeleccionada3.equals(respuestaCorrecta3)) {
            // La respuesta es correcta
            Toast.makeText(this, "Respuesta correcta3", Toast.LENGTH_SHORT).show();
        } else {
            // La respuesta es incorrecta
            Toast.makeText(this, "Respuesta incorrecta3", Toast.LENGTH_SHORT).show();
        }
        // Comparar la respuesta seleccionada con la respuesta correcta
        if (respuestaSeleccionada4.equals(respuestaCorrecta4)) {
            // La respuesta es correcta
            Toast.makeText(this, "Respuesta correcta4", Toast.LENGTH_SHORT).show();
        } else {
            // La respuesta es incorrecta
            Toast.makeText(this, "Respuesta incorrecta4", Toast.LENGTH_SHORT).show();
        }
        // Comparar la respuesta seleccionada con la respuesta correcta
        if (respuestaSeleccionada5.equals(respuestaCorrecta5)) {
            // La respuesta es correcta
            Toast.makeText(this, "Respuesta correcta5", Toast.LENGTH_SHORT).show();
        } else {
            // La respuesta es incorrecta
            Toast.makeText(this, "Respuesta incorrecta5", Toast.LENGTH_SHORT).show();
        }
    }

    // Método para restablecer el color de fondo de todos los botones
    private void resetearColoresBotones() {
        btnRespuesta1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta1)));
        btnRespuesta2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta2)));
        btnRespuesta3.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta3)));
        btnRespuesta4.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta4)));
    }
    private void resetearColoresBotones2() {
        btnRespuesta5.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta1)));
        btnRespuesta6.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta2)));
        btnRespuesta7.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta3)));
        btnRespuesta8.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta4)));
    }
    private void resetearColoresBotones3() {
        btnRespuesta9.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta1)));
        btnRespuesta10.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta2)));
        btnRespuesta11.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta3)));
        btnRespuesta12.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta4)));
    }

    private void resetearColoresBotones4() {
        btnRespuesta13.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta1)));
        btnRespuesta14.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta2)));
        btnRespuesta15.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta3)));
        btnRespuesta16.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta4)));
    }
    private void resetearColoresBotones5() {
        btnRespuesta17.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta1)));
        btnRespuesta18.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta2)));
        btnRespuesta19.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta3)));
        btnRespuesta20.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta4)));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Detener la música y liberar recursos cuando la actividad se destruye
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}

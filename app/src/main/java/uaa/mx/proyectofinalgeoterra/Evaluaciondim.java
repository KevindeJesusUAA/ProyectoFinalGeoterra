package uaa.mx.proyectofinalgeoterra;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class Evaluaciondim extends AppCompatActivity {
    private MediaPlayer mediaPlayer; // Variable para el reproductor de música
    private boolean musicaReproducida = false;
    private LinearLayout panel;
    private String[][] preg_res;
    private boolean[] vector = new boolean[10]; // Por ejemplo, un array de tamaño 10, todos los elementos inicializados en false

    private String[] resco = new String[15]; // Donde "n" es el tamaño del array
    protected void onCreate(Bundle savedInstanceState) {
        Arrays.fill(resco, "");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evaluadinamico);
        AtomicReference<Intent> intent = new AtomicReference<>(getIntent());
        String tema = intent.get().getStringExtra("Tema");
        mediaPlayer = MediaPlayer.create(this, R.raw.preguntados);
        mediaPlayer.setLooping(false);
        panel=findViewById(R.id.preguntas);


        String temas = intent.get().getStringExtra("Tema");
        System.out.println(temas);
        //Aqui ponemos las preguntas dependiendo el tema
        String[][] questionsAndAnswers=null;
        if(temas.equals("1")){//mapas
            questionsAndAnswers = new String[][]{
                    {"What animal is this?", "Dog", "Cat", "Fish", "Fish", "Dog",""},
                    {"What animal is this?", "Lion", "Cat", "Bird", "Cat", "Fish",""},
                    {"What animal is this?", "Snake", "Cat", "Fish", "Snake", "Fish",""},
                    {"What animal is this?", "Tiger", "Cat", "Fish", "Tiger", "Fish",""},
                    {"What animal is this?", "Dolphin", "Cat", "Fish", "Dolphin", "Fish",""},
                    {"What animal is this?", "Monkey", "Cat", "Fish", "Monkey", "Fish",""},
                    {"What animal is this?", "Elephant", "Cat", "Fish", "Elephant", "Fish",""},
                    {"What animal is this?", "Bear", "Cat", "Fish", "Bear", "Fish",""},
                    {"What animal is this?", "Fish", "Cat", "Fish", "Fish", "Fish",""},
                    {"What animal is this?", "Horse", "Cat", "Fish", "Horse", "Fish",""}
            };

        } else if (temas.equals("2")){//continentes
            questionsAndAnswers = new String[][]{
                    {"What animal is this?", "Dog", "Cat", "Fish", "Dog", "Tamales","https://www.cuentame.inegi.org.mx/monografias/imagenes/div/bc.gif"},
                    {"What animal is this?", "Lion", "Cat", "Bird", "Cat", "Cat",""},
                    {"What animal is this?", "Snake", "Cat", "Fish", "Snake", "Yuya",""},
                    {"What animal is this?", "Tiger", "Cat", "Fish", "Tiger", "Fish",""},
                    {"What animal is this?", "Dolphin", "Cat", "Fish", "Dolphin", "Loco",""},
                    {"What animal is this?", "Monkey", "Cat", "Fish", "Monkey", "Fish",""},
                    {"What animal is this?", "Elephant", "Cat", "Fish", "Elephant", "Fish",""},
                    {"What animal is this?", "Bear", "Cat", "Fish", "Bear", "Fish",""},
                    {"What animal is this?", "Fish", "Cat", "Fish", "Fish", "Fish",""},
                    {"What animal is this?", "Horse", "Cat", "Fish", "Horse", "Fish",""}
            };
        } else if (temas.equals("3")) {//paises
            questionsAndAnswers = new String[][]{
                    {"What animal is this?", "Dog", "Cat", "Fish", "Dog", "Fish"},
                    {"What animal is this?", "Lion", "Cat", "Bird", "Cat", "Fish"},
                    {"What animal is this?", "Snake", "Cat", "Fish", "Snake", "Fish"},
                    {"What animal is this?", "Tiger", "Cat", "Fish", "Tiger", "Fish"},
                    {"What animal is this?", "Dolphin", "Cat", "Fish", "Dolphin", "Fish"},
                    {"What animal is this?", "Monkey", "Cat", "Fish", "Monkey", "Fish"},
                    {"What animal is this?", "Elephant", "Cat", "Fish", "Elephant", "Fish"},
                    {"What animal is this?", "Bear", "Cat", "Fish", "Bear", "Fish"},
                    {"What animal is this?", "Fish", "Cat", "Fish", "Fish", "Fish"},
                    {"What animal is this?", "Horse", "Cat", "Fish", "Horse", "Fish"}
            };
        }else if (temas.equals("4")) {//Explora

        }else if (temas.equals("5")) {//Estados
                    questionsAndAnswers = new String[][]{
                            {"What animal is this?", "Dog", "Cat", "Fish", "Dog", "Fish"},
                            {"What animal is this?", "Lion", "Cat", "Bird", "Cat", "Fish"},
                            {"What animal is this?", "Snake", "Cat", "Fish", "Snake", "Fish"},
                            {"What animal is this?", "Tiger", "Cat", "Fish", "Tiger", "Fish"},
                            {"What animal is this?", "Dolphin", "Cat", "Fish", "Dolphin", "Fish"},
                            {"What animal is this?", "Monkey", "Cat", "Fish", "Monkey", "Fish"},
                            {"What animal is this?", "Elephant", "Cat", "Fish", "Elephant", "Fish"},
                            {"What animal is this?", "Bear", "Cat", "Fish", "Bear", "Fish"},
                            {"What animal is this?", "Fish", "Cat", "Fish", "Fish", "Fish"},
                            {"What animal is this?", "Horse", "Cat", "Fish", "Horse", "Fish"}
                    };
        }
        //musica
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
        mediaPlayer.start();
        //creando cuestionario
        System.out.println("tot: "+questionsAndAnswers.length);
        for(int i=0;i<questionsAndAnswers.length;i++){
            resco[i]=questionsAndAnswers[i][5];
            TextView txtPregunta1 = new TextView(this);
            txtPregunta1.setText("Pregunta "+(i+1));
            txtPregunta1.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            txtPregunta1.setTextSize(30);
            txtPregunta1.setTypeface(null, Typeface.BOLD);
            txtPregunta1.setTextColor(Color.parseColor("#020242"));
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) txtPregunta1.getLayoutParams();
            params.setMargins(20, 20, 20, 16); // left, top, right, bottom
            txtPregunta1.setLayoutParams(params);
            params.gravity = Gravity.START;
            panel.addView(txtPregunta1,params);
            //pregunta
// Crea un nuevo TextView
            TextView pregunta2 = new TextView(this);
            pregunta2.setId(R.id.pregunta1);
            pregunta2.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            pregunta2.setText(questionsAndAnswers[i][0]);
            pregunta2.setTextSize(25);
            pregunta2.setTextColor(Color.parseColor("#020242"));

            // Aplica márgenes al TextView
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pregunta2.getLayoutParams();
            layoutParams.setMargins(20, 0, 20, 16); // Izquierda, arriba, derecha, abajo
            pregunta2.setLayoutParams(layoutParams);

            // Centra horizontalmente el TextView en su contenedor
            pregunta2.setGravity(Gravity.CENTER_HORIZONTAL);
            panel.addView(pregunta2);
            //tiene imagen?
            if(!questionsAndAnswers[i][6].equals("")){
                WebView webView = new WebView(this);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl(questionsAndAnswers[i][6]);
                panel.addView(webView);
            }

            String[] colores = {
                    "#FF0000",
                    "#00FF00",
                    "#0099FF",
                    "#FF9900"

            };
            for(int p=0;p<4;p++){
                // Crea un nuevo Button
                Button btnRespuesta1 = new Button(this);
                btnRespuesta1.setText(questionsAndAnswers[i][(p+1)]);

                // Configura la apariencia del botón (bordes curvos y fondo rojo)
                GradientDrawable gd = new GradientDrawable();
                gd.setColor(Color.parseColor(colores[p]));
                gd.setCornerRadius(25); // Ajusta el radio para hacer los bordes curvos
                btnRespuesta1.setBackground(gd);

                // Crea márgenes para el Button (izquierda, arriba, derecha, abajo)
                LinearLayout.LayoutParams layoutParamss = new LinearLayout.LayoutParams(
                        300, // Ancho en píxeles
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutParamss.setMargins(20, 20, 20, 20); // Ajusta los márgenes según sea necesario
                btnRespuesta1.setLayoutParams(layoutParamss);

                //params.gravity = Gravity.CENTER;
                btnRespuesta1.setTextSize(30);
                btnRespuesta1.setTypeface(null, Typeface.BOLD);
                btnRespuesta1.setTextColor(Color.WHITE);

                // Agrega el Button al layout principal y lo centra
                /*LinearLayout layoutPrincipal = new LinearLayout(this);
                layoutPrincipal.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));
                layoutPrincipal.setOrientation(LinearLayout.VERTICAL)*/;
                // Crea un contenedor para el Button y establece la gravedad al centro solo para este contenedor
                //evento

                btnRespuesta1.setId(View.generateViewId());

// Añade el evento clic al botón
                String[][] finalQuestionsAndAnswers = questionsAndAnswers;
                int finalI = i;
                btnRespuesta1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Acción a realizar cuando se hace clic en el botón
                        String textoBoton = ((Button) v).getText().toString();
                        //questionsAndAnswers[i][6]
                        String correcta= finalQuestionsAndAnswers[0][5];
                        System.out.println("usuario: "+textoBoton+" correcta: "+correcta);
                        if(textoBoton.equals(correcta)){
                           System.out.println("correcta");
                            vector[finalI]=true;
                        }else{
                            System.out.println("incorrecta");
                            vector[finalI]=false;
                        }



                        System.out.println(textoBoton);

                    }
                });
                LinearLayout contenedorBoton = new LinearLayout(this);
                contenedorBoton.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                contenedorBoton.setGravity(Gravity.CENTER); // Esto centra solo este contenedor
                contenedorBoton.addView(btnRespuesta1);
                panel.addView(contenedorBoton);
            }

            //respuestas
            //enviar


        }
        //boton de ir a evaluacion
        Button btnEnviar = new Button(this);

        btnEnviar.setText("Enviar");
        btnEnviar.setTextColor(getResources().getColor(android.R.color.white)); // Establecer color de texto
        btnEnviar.setTextSize(30); // Establecer tamaño de texto
        btnEnviar.setTypeface(null, Typeface.BOLD); // Establecer estilo de texto a negrita
        btnEnviar.setBackgroundColor(Color.parseColor("#FF99FF")); // Establecer color de fondo

        // Configurar el evento clic del botón (puedes personalizarlo según tus necesidades)
        btnEnviar.setOnClickListener(v -> {
             intent.set(new Intent(Evaluaciondim.this,resultadosdin.class));
            System.out.println("vaya");
            // Poner las respuestas seleccionadas como extras en el Intent
            intent.get().putExtra("revision",vector);
            intent.get().putExtra("correcta",resco);
            startActivity(intent.get());
        });

        // Crear un LinearLayout
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.gravity = Gravity.CENTER;
        params.setMargins(0, 40, 0, 0); // Establecer márgenes
        panel.addView(btnEnviar);
        /*


        <TextView
                android:id="@+id/txtpregunta1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Pregunta 1"
                android:layout_marginTop="20dp"
                android:layout_marginLeft="20dp"
                android:layout_marginRight="20dp"
                android:textSize="30sp"
                android:textStyle="bold"
                android:layout_gravity="left"
                android:layout_marginBottom="16dp"
                android:textColor="#020242"/>
        */




    }
}

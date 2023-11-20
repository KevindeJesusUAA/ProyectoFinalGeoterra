package uaa.mx.proyectofinalgeoterra;

import android.content.Intent;
import android.content.res.ColorStateList;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class Evaluaciondim extends AppCompatActivity {
    private MediaPlayer mediaPlayer; // Variable para el reproductor de música
    private boolean musicaReproducida = false;
    private LinearLayout panel;
    private String[][] preg_res;
    private boolean[] vector = new boolean[20]; // Por ejemplo, un array de tamaño 10, todos los elementos inicializados en false
    private int inicio=0;
    private String[] resco = new String[15]; // Donde "n" es el tamaño del array
    private String[][] questionsAndAnswers=null;
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

        if(temas.equals("1")){//mapas
            questionsAndAnswers = new String[][]{
                    {"Representa el tipo de información que contiene el mapa ", "a. Rosa de los vientos", "b. Titulo", "c. Simbología", "d. Escala", "b. Titulo",""},
                    {"Son figuras, líneas, puntos o colores que sirven para representar información del mapa.", "a. Rosa de los vientos", "b. Titulo", "c. Simbología", "d. Escala", "c. Simbología","data:image/jpeg;base64,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","V"},
                    {"¿Cual es el símbolo que señala los cuatro puntos cardinales; Norte, Sur, Este y Oeste.", "a. Rosa de los vientos", "b. Titulo", "c. Simbología", "d. Escala", "a. Rosa de los vientos","https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Rosa_de_los_vientos.svg/2048px-Rosa_de_los_vientos.svg.png","V"},
                    {"Es denominada la relación que existe entre las medidas en un plano o mapa y las medidas en la realidad", "a. Rosa de los vientos", "b.Titulo", "c. Simbología", "d. Escala", "d. Escala",""},
                    {"Son consideradas líneas verticales denominadas meridianos y lineas horizontales llamadas paralelos .", "a. Titulo", "b. Rosa de los vientos", "c. Coordenadas geográficas", "d. Fuente", "c. Coordenadas geográficas",""},

            };

        } else if (temas.equals("2")){//continentes
            questionsAndAnswers = new String[][]{
                    {"¿Cuál continente se muestra a continuación?", "a. Oceanía", "b. Europa", "c. Asia", "d. África", "d. África","https://upload.wikimedia.org/wikipedia/commons/3/3f/Africa_in_the_world_%28red%29_%28W3%29.svg","V"},
                    {"¿Qué continente se observa en la siguiente figura?", "a. América", "b. Europa", "c. Asia", "d. África", "a. América","https://i0.wp.com/epicentrogeografico.com/wp-content/uploads/1200px-Americas_in_the_world_red_W3.svg_.png","V"},
                    {"¿Cuáles son los oceanos que se localizan alrededor del continente de América?", "a. Océanos Atlántico e Índico", "b. Oceános Ártico y Antártico", "c. Oceános Atlántico y Ártico ", "d. Oceáno Antártico", "a. Océanos Atlántico e Índico",""},
                    {"Menciona el continente que se observa en la siguiente imágen", "a. América", "b. Europa", "c. Asia", "d. África", "b. Europa",""},
                    {"Selecciona el continente que tiene alrededor los Mares Mediterráneo y Rojo ", "a. América", "b. Europa", "c. Asia", "d. África", "d. África",""},
                    {"¿Cuál continente se visualiza en la imagen?", "a. América", "b. Oceanía", "c. Asia", "d. África", "c. Asia",""},
                    {"¿Cuál es el continente que se muestra en la siguiente imagen?", "a. Oceanía", "b. Europa", "c. Asia", "d. África", "a. Oceanía",""}

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
                /*WebView webView = new WebView(this);
                webView.getSettings().setJavaScriptEnabled(true);
                int anchoEnPixeles=0,altoEnPixeles=0;
                if(questionsAndAnswers[i][7].equals("H")){
                     anchoEnPixeles = 700;
                     altoEnPixeles = 500;
                }else{
                     anchoEnPixeles = 500;
                     altoEnPixeles = 700;
                }


                ViewGroup.LayoutParams layoutParamss = new ViewGroup.LayoutParams(anchoEnPixeles, altoEnPixeles);
                webView.setLayoutParams(layoutParamss);

                webView.loadUrl(questionsAndAnswers[i][6]);

                panel.addView(webView);*/
                ImageView imageView = new ImageView(this);

                // Definir el ancho y alto del ImageView
                int widthPixels = 600; // Ancho en píxeles
                int heightPixels = 600; // Alto en píxeles

                // Asignar las dimensiones al ImageView
                imageView.setLayoutParams(new LinearLayout.LayoutParams(widthPixels, heightPixels));

                // URL de la imagen en Internet que deseas cargar
                String imageUrl =questionsAndAnswers[i][6] ;

                // Usar Glide para cargar la imagen desde Internet y asignarla al ImageView
                Glide.with(this)
                        .load(imageUrl)
                        .into(imageView);
                LinearLayout.LayoutParams layoutParamsx = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,  // Ancho
                        LinearLayout.LayoutParams.WRAP_CONTENT   // Alto
                );

                layoutParams.gravity = Gravity.CENTER;  // Centra el ImageView en el LinearLayout

                imageView.setLayoutParams(layoutParams);
                panel.addView(imageView);
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
                        600, // Ancho en píxeles
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
                int id=View.generateViewId();
                if(p==0&&i==0){
                    inicio=id;
                }
                btnRespuesta1.setId(id);
                System.out.println("id:   "+id);

// Añade el evento clic al botón
                String[][] finalQuestionsAndAnswers = questionsAndAnswers;
                int finalI = i;
                btnRespuesta1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Acción a realizar cuando se hace clic en el botón
                        String textoBoton = ((Button) v).getText().toString();
                        //questionsAndAnswers[i][6]
                        String correcta= finalQuestionsAndAnswers[finalI][5];
                        System.out.println("usuario: "+textoBoton+" correcta: "+correcta);
                        limpiar(btnRespuesta1);
                        validarRespuesta( btnRespuesta1);

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
    private void validarRespuesta(Button btnRespuesta) {
        // Restablecer el color de fondo del botón previamente seleccionado

        // Cambiar el color de fondo del botón seleccionado
        btnRespuesta.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonSeleccionado)));


    }
    public  void limpiar(Button btnRespuesta){
        int id = btnRespuesta.getId();
        System.out.println("que: "+id);
        int ini = id/4;
        if(id%4!=0){
            ini++;
        }

        ini*=4;
        System.out.println("final "+ini);



        Button btnRespuesta5 = findViewById(ini);
        btnRespuesta5.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta4)));
        ini--;
        btnRespuesta5 = findViewById(ini);
        btnRespuesta5.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta3)));
        ini--;
        btnRespuesta5 = findViewById(ini);
        btnRespuesta5.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta2)));
        ini--;
        btnRespuesta5 = findViewById(ini);
        btnRespuesta5.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta1)));







    }
}

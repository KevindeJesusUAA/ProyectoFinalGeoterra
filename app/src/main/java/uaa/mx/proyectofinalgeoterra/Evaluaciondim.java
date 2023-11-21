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
    private String Nombre,id;
    protected void onCreate(Bundle savedInstanceState) {
        Arrays.fill(resco, "");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evaluadinamico);
        AtomicReference<Intent> intent = new AtomicReference<>(getIntent());
        String tema = intent.get().getStringExtra("Tema");
        Bundle recibeIngreso = getIntent().getExtras();
        Nombre = recibeIngreso.getString("Nombre"); //Para recoger los datos, utilizamos la variable de bundle y con el metodo getstring obtenemos la clave de parametro
        id= recibeIngreso.getString("Idusu");
        mediaPlayer = MediaPlayer.create(this, R.raw.preguntados);
        mediaPlayer.setLooping(false);
        panel=findViewById(R.id.preguntas);
        System.out.println("dinamico:::: "+Nombre+" "+id);

        String temas = intent.get().getStringExtra("Tema");
        System.out.println(temas);
        //Aqui ponemos las preguntas dependiendo el tema

        if(temas.equals("1")){//mapas
            questionsAndAnswers = new String[][]{
                    {"Representa el tipo de información que contiene el mapa ", "a. Rosa de los vientos", "b. Titulo", "c. Simbología", "d. Escala", "b. Titulo",""},
                    {"Son figuras, líneas, puntos o colores que sirven para representar información del mapa.", "a. Rosa de los vientos", "b. Titulo", "c. Simbología", "d. Escala", "c. Simbología", "https://catedu.github.io/cartografia-para-montaneros/img/Leyenda%20del%20mapa2.jpg"},
                    {"¿Cual es el símbolo que señala los cuatro puntos cardinales; Norte, Sur, Este y Oeste.", "a. Rosa de los vientos", "b. Titulo", "c. Simbología", "d. Escala", "a. Rosa de los vientos","https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Rosa_de_los_vientos.svg/2048px-Rosa_de_los_vientos.svg.png","V"},
                    {"Es denominada la relación que existe entre las medidas en un plano o mapa y las medidas en la realidad", "a. Rosa de los vientos", "b.Titulo", "c. Simbología", "d. Escala", "d. Escala","https://d127nz7k4leq8b.cloudfront.net/uploads/editor/1657825155_2.escala-gr%C3%A1fica.jpg"},
                    {"Son consideradas líneas verticales denominadas meridianos y lineas horizontales llamadas paralelos .", "a. Titulo", "b. Rosa de los vientos", "c. Coordenadas geográficas", "d. Fuente", "c. Coordenadas geográficas","https://aprendeencasa.sep.gob.mx/multimedia/B64images/202110/B64-IMG-zKS0oz04Sm-eu971aO6HE.png"},
            };

        } else if (temas.equals("2")){//continentes
            questionsAndAnswers = new String[][]{
                    {"¿Cuál continente se muestra a continuación?", "a. Oceanía", "b. Europa", "c. Asia", "d. África", "d. África","https://www.freeworldmaps.net/africa/location.gif"},
                    {"¿Qué continente se observa en la siguiente figura?", "a. América", "b. Europa", "c. Asia", "d. África", "a. América","https://i0.wp.com/epicentrogeografico.com/wp-content/uploads/1200px-Americas_in_the_world_red_W3.svg_.png"},
                    {"¿Cuáles son los oceanos que se localizan alrededor del continente de América?", "a. Océanos Atlántico e Índico", "b. Oceános Ártico y Antártico", "c. Oceános Atlántico y Ártico ", "d. Oceáno Antártico", "a. Océanos Atlántico e Índico",""},
                    {"Menciona el continente que se observa en la siguiente imágen", "a. América", "b. Europa", "c. Asia", "d. África", "b. Europa","https://1.bp.blogspot.com/-WE7Fi07zeeY/UmMkJBhn4BI/AAAAAAAACg0/6M9kbqNA9rg/s1600/Europa_no_mundo.png"},
                    {"Selecciona el continente que tiene alrededor los Mares Mediterráneo y Rojo ", "a. América", "b. Europa", "c. Asia", "d. África", "d. África",""},
                    {"¿Cuál continente se visualiza en la imagen?", "a. América", "b. Oceanía", "c. Asia", "d. África", "c. Asia","https://2.bp.blogspot.com/-oBupmWjgm6Q/WW4lmoZy0qI/AAAAAAABdC4/uHyqZY_SCbAFMDSRTBIzh6b6HoJ6EichwCLcBGAs/w1200-h630-p-k-no-nu/800px-asia_in_the_world_red_w3-svg.png"},
                    {"¿Cuál es el continente que se muestra en la siguiente imagen?", "a. Oceanía", "b. Europa", "c. Asia", "d. África", "a. Oceanía","https://www.absolutviajes.com/wp-content/uploads/2012/06/australia-en-el-mapa.gif"}

            };
        } else if (temas.equals("3")) {//paises
            questionsAndAnswers = new String[][]{
                    {"¿Cuál país se muestra en la siguiente imagen?", "a. Francia", "b. Brasil", "c. China", "d. Argentina", "d. Argentina","https://ichef.bbci.co.uk/news/640/cpsprodpb/D348/production/_95588045_178392703.jpg"},
                    {"Selecciona el nombre del país que se muestra en la figura siguiente:", "a. México", "b. Francia", "c. Estados Unidos", "d. Argentina", "a. México", "https://conecta.tec.mx/sites/default/files/styles/header_full/public/2022-02/historia-y-curiosidades-de-la-bandera-de-mexico.jpg?h=920929c4&itok=WrnA2D_j"},
                    {"¿Qué país se observa a continuación?", "a. España", "b. Brasil", "c. China", "d. Francia", "c. China", "https://marxismo.mx/wp-content/uploads/2017/12/bandera-china.jpg"},
                    {"En la siguiente figura se puede visualizar la bandera de un país, ¿de cuál país es la bandera?", "a. Estados Unidos", "b. Brasil", "c, Alemania", "d. China", "a. Estados Unidos", "https://banderas.top/wp-content/webp-express/webp-images/doc-root/wp-content/uploads/2020/07/Estadounidense-de-15-estados-01.png.webp"},
                    {"¿Cuál es el país que se puede observar en la siguiente imagen?", "a. Francia", "b. Brasil", "c. China", "d. Argentina", "b. Brasil","https://img.freepik.com/vector-premium/bandera-brasil-fondo_19426-622.jpg"},
                    {"¿Cuál país se muestra en la siguiente imagen?", "a. Francia", "b. España", "c. Alemania", "d. Argentina", "a. Francia","https://media.istockphoto.com/id/510973709/es/foto/primer-plano-de-bandera-de-francia.jpg?s=612x612&w=0&k=20&c=Vs_MA_7swdlmWksg0QbobTnjFdADt5yMAooZ22nHXiM="},
                    {"Selecciona el nombre del país que se muestra en la figura siguiente:", "a. Argentina", "b. Francia", "c. Estados Unidos", "d. Alemania", "d. Alemania", "https://media.istockphoto.com/id/475988677/es/foto/bandera-alemania.jpg?s=612x612&w=0&k=20&c=QhnSh5z96fGvYMMhl0-xWod4PrdS59eSsQN6vE6FegA="},
                    {"¿Qué país se observa a continuación?", "a. México", "b. Brasil", "c. España", "d. Francia", "c. España", "https://imagenes.20minutos.es/files/image_1920_1080/uploads/imagenes/2023/08/23/bandera-espana-freepik-1.jpeg"},

            };
        }else if (temas.equals("4")) {//Explora

        }else if (temas.equals("5")) {//Estados
            questionsAndAnswers = new String[][]{
                    {"¿Cuál es el siguiente estado de México?", "a. Aguascalientes", "b. Zacatecas", "c. Sonora", "d.Colima", "b. Zacatecas", "https://mr.travelbymexico.com/imgBase/2012/04/zacatecas_edo.jpg"},
                    {"¿Cuál estado de México se observa en la siguiente imagen?", "a. Chihuahua", "b. Oaxaca", "c. Aguascalientes", "d.CDMX", "c. Aguascalientes","https://mr.travelbymexico.com/imgBase/2012/04/aguascalientes_edo.jpg"},
                    {"¿De qué estado de México se trata la siguiente figura?", "a. CDMX", "b. Quintana Roo", "c. Veracruz", "d. Colima", "d. Colima", "https://mr.travelbymexico.com/imgBase/2012/04/colima_edo.jpg"},
                    {"Selecciona la opción que corresponda al estado de México que se visualiza en la imagen", "a. Quintana Roo", "b. Oaxaca", "c. CDMX", "d. Durango", "c. CDMX", "https://mr.travelbymexico.com/imgBase/2012/04/distritofederal.jpg"},
                    {"¿Cuál es el siguiente estado de México?", "a. Oaxaca", "b. Durango", "c. Coahuila", "d.Colima", "a. Oaxaca", "https://mr.travelbymexico.com/imgBase/2012/04/oaxaca_edo.jpg"},
                    {"¿Cuál estado de México se observa en la siguiente imagen?", "a. Sinaloa", "b. Guerrero", "c. Baja California Norte", "d. Baja California Sur", "d. Baja California Sur","https://upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Baja_California_Sur_in_Mexico.svg/2029px-Baja_California_Sur_in_Mexico.svg.png"},
                    {"¿De qué estado de México se trata la siguiente figura?", "a. Chihuahua", "b. Quintana Roo", "c. Nayarit", "d. Durango", "a. Chihuahua", "https://mr.travelbymexico.com/imgBase/2012/04/chihuahua_edo.jpg"},
                    {"Selecciona la opción que corresponda al estado de México que se visualiza en la imagen", "a. Durango", "b. Quintana Roo", "c. Tabasco", "d. Jalisco", "b. Quintana Roo", "https://mr.travelbymexico.com/imgBase/2012/04/quintanaroo.jpg"},
                    {"¿Cuál estado de México se observa en la siguiente imagen?", "a. Veracruz", "b. Sonora", "c. CDMX", "d. Durango", "d. Durango","https://mr.travelbymexico.com/imgBase/2012/04/durango.jpg"},
                    {"¿De qué estado de México se trata la siguiente figura?", "a. Nuevo Leoin", "b. Coahuila", "c. Durango", "d. Puebla", "b. Coahuila", "https://mr.travelbymexico.com/imgBase/2012/04/coahuila.jpg"},

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
            intent.get().putExtra("Nombre",Nombre);
            intent.get().putExtra("Idusu",id);
            intent.get().putExtra("Tema",tema);
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

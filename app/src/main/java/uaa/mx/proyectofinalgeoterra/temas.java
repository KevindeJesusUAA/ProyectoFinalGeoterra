package uaa.mx.proyectofinalgeoterra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class temas extends AppCompatActivity {
    private String cadena="";
    private int longitud=0;
    private  ArrayList<ArrayList<String>> separado = new ArrayList<>();
    LinearLayout linearLayout ;
    private String para;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data);

        Bundle recibeIngreso = getIntent().getExtras(); //Vamos a recibir los datos del parametro, obteniendo el intento y llamamos al método de getExtras
        // para obtener un objeto Bundle que contiene los datos

        para = recibeIngreso.getString("parametro"); //Para recoger los datos, utilizamos la variable de bundle y con el metodo getstring obtenemos la clave de parametro
        // y vamos a almacenarlos en una variable de tipo string

        linearLayout= findViewById(R.id.preguntas);
        inicializa();

    }
    public void inicializa(){
        if(para.equals("1")){
            cadena="(TI,Título:) (TE,Dice qué tipo de información contiene el mapa o el lugar que se representa.\n" +
                    "El título de este mapa es: “Carreteras y principales ciudades de México”.\n" +
                    "Rosa de los vientos: Es el símbolo que señala los cuatro puntos cardinales; Norte,\n" +
                    "Sur, Este y Oeste. En los mapas, la rosa de los vientos siempre orientará\n" +
                    "geográficamente señalando el norte hacia arriba. )(IM,https://i0.wp.com/alpoma.net/carto/wp-content/uploads/2019/07/An_Animated_Map_of_the_Earth.gif?ssl=1)";
            longitud=cadena.length();
            muestra();
        }
        if(para.equals("2")){
            cadena="(TI,Chicos niños:) (TE,1. ASIA\n" +
                    "2. AMÉRICA\n" +
                    "3. ÁFRICA\n" +
                    "4. ANTÁRTIDA\n" +
                    "5. EUROPA )(IM,https://1.bp.blogspot.com/-9Fcfflux1n8/X6J9mXHatVI/AAAAAAAATe8/VnjnhxUe3MIBwCgY2xGwulmXUAjSXlLUACLcBGAsYHQ/s16000/Planisferio-Colores-85891.gif)" +
                    "(VI,https://www.youtube.com/watch?v=VHUbhnjxGrw)";
            longitud=cadena.length();
            muestra();
        }


    }
    public void muestra(){
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;
        int divide=longitud;
        Pattern pattern = Pattern.compile("\\(([^)]+)\\)");
        Matcher matcher = pattern.matcher(cadena);
        int index=1;
        while (matcher.find()) {
            // Obtiene el código encontrado
            String codigo = matcher.group(1);
            System.out.println(  codigo);
            if(codigo.substring(0, 2).contains("TE")){
                /*TextView textView = new TextView(this);
                textView.setText(codigo.substring(3));
                // Cambia el color del texto
                textView.setTextColor(Color.argb(255,2,2,66));
                textView.setTextSize(26);
                textView.setTypeface(Typeface.DEFAULT);
                textView.setId(index);
                linearLayout.addView(textView);*/
                TextView textView = new TextView(this);
                textView.setText(codigo.substring(3));
                textView.setTextColor(Color.argb(255, 255, 255, 255));
                textView.setTextSize(26);
                textView.setTypeface(Typeface.DEFAULT);
                textView.setId(index);

// Crear parámetros de diseño con márgenes
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

// Ajustar márgenes (left, top, right, bottom)
                layoutParams.setMargins(20, 20, 20, 20);

// Establecer gravedad para justificar el texto
                textView.setGravity(Gravity.LEFT | Gravity.RIGHT | Gravity.START | Gravity.END);

// Aplicar parámetros de diseño al TextView
                textView.setLayoutParams(layoutParams);

// Agregar el TextView al LinearLayout
                linearLayout.addView(textView);



            }else if (codigo.substring(0, 2).contains("TI")){
                /*System.out.println("ES TITULO");
                TextView textView = new TextView(this);
                textView.setText(codigo.substring(3)); // Configura el texto del TextView
                textView.setTextSize(32);
                textView.setTextColor(Color.argb(255,2,2,66));
                textView.setTypeface(null, Typeface.BOLD);
                textView.setGravity(Gravity.CENTER);
                textView.setId(index);
                linearLayout.addView(textView);*/
                TextView textView = new TextView(this);
                textView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                textView.setText(codigo.substring(3));
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 50);
                textView.setTypeface(null, Typeface.BOLD);
                textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                textView.setTextColor(Color.WHITE);
                textView.setGravity(Gravity.CENTER);
                textView.setPadding(40, 40, 40, 40);
                //textView.setBackgroundResource(R.drawable.fondo_textview);
                textView.setBackgroundColor(Color.parseColor("#3465E0"));
                linearLayout.addView(textView);
            }else if (codigo.substring(0, 2).contains("IM")){
                System.out.println("ES IMAGENES");
                //https://assets.stickpng.com/images/584df3ad6a5ae41a83ddee08.png
                ImageView imageView = new ImageView(this);

                // Definir el ancho y alto del ImageView
                int widthPixels = 600; // Ancho en píxeles
                int heightPixels = 600; // Alto en píxeles

                // Asignar las dimensiones al ImageView
                imageView.setLayoutParams(new LinearLayout.LayoutParams(widthPixels, heightPixels));

                // URL de la imagen en Internet que deseas cargar
                String imageUrl = codigo.substring(3);

                // Usar Glide para cargar la imagen desde Internet y asignarla al ImageView
                Glide.with(this)
                        .load(imageUrl)
                        .into(imageView);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,  // Ancho
                        LinearLayout.LayoutParams.WRAP_CONTENT   // Alto
                );

                layoutParams.gravity = Gravity.CENTER;  // Centra el ImageView en el LinearLayout
                imageView.setId(index);
                imageView.setLayoutParams(layoutParams);
                linearLayout.addView(imageView);
            }else if (codigo.substring(0, 2).contains("VI")) {

                WebView webView = new WebView(this);

                // Configurar el WebViewClient para gestionar las URL cargadas dentro del WebView
                webView.setWebViewClient(new MyWebViewClient());

                // Habilitar JavaScript (opcional)
                webView.getSettings().setJavaScriptEnabled(true);

                // Cargar la URL deseada
                webView.loadUrl("https://www.dailymotion.com/video/x7jfgjd");
                linearLayout.addView(webView);

            }
            index++;
        }
        //boton de ir a evaluacion
        Button btnEnviar = new Button(this);

        btnEnviar.setText("Ir A Evaluacion");
        btnEnviar.setTextColor(getResources().getColor(android.R.color.white)); // Establecer color de texto
        btnEnviar.setTextSize(30); // Establecer tamaño de texto
        btnEnviar.setTypeface(null, Typeface.BOLD); // Establecer estilo de texto a negrita
        btnEnviar.setBackgroundColor(Color.parseColor("#FF99FF")); // Establecer color de fondo

        // Configurar el evento clic del botón (puedes personalizarlo según tus necesidades)
        btnEnviar.setOnClickListener(v -> {
            Intent intent = new Intent(temas.this, Evaluaciondim.class);

            // Poner las respuestas seleccionadas como extras en el Intent
            intent.putExtra("Tema", para);
            startActivity(intent);
        });

        // Crear un LinearLayout
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.gravity = Gravity.CENTER;
        params.setMargins(0, 40, 0, 0); // Establecer márgenes
        linearLayout.addView(btnEnviar);

    }
    // Clase personalizada WebViewClient
    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            // Obtener la URL cargada
            Uri uri = request.getUrl();

            // Verificar si la URL es de Google
            if (uri.getHost() != null && uri.getHost().contains("google.com")) {
                // Permitir la carga normal de la URL
                return false;
            } else {
                // Abrir la URL externamente en el navegador
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                return true;
            }
        }
    }
}

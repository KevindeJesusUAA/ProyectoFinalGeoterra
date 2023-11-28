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
    private String para,Nombre,id;

    private CustomScrollView customScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data);

        customScrollView = findViewById(R.id.customScrollView);

        Bundle recibeIngreso = getIntent().getExtras(); //Vamos a recibir los datos del parametro, obteniendo el intento y llamamos al método de getExtras
        // para obtener un objeto Bundle que contiene los datos

        para = recibeIngreso.getString("parametro"); //Para recoger los datos, utilizamos la variable de bundle y con el metodo getstring obtenemos la clave de parametro
        // y vamos a almacenarlos en una variable de tipo string


        Nombre = recibeIngreso.getString("Nombre"); //Para recoger los datos, utilizamos la variable de bundle y con el metodo getstring obtenemos la clave de parametro
        id= recibeIngreso.getString("Idusu");
        System.out.println("temas: "+Nombre+" "+id);
        linearLayout= findViewById(R.id.preguntas);
        inicializa();

    }
    public void inicializa(){
        if(para.equals("1")){
            cadena="(TI,Título) (TE,Dice qué tipo de información contiene el mapa o el lugar que se representa.\n" +
                    "El título de este mapa es: “Carreteras y principales ciudades de México”.)\n" +
                    "geográficamente señalando el norte hacia arriba. )(IM,https://aprendeencasa.sep.gob.mx/multimedia/B64images/202110/B64-IMG-iCV3qwx8Hn-4KgTRkk5pO.png)\n" +
                    "(TI,Rosa de los vientos) (TE,Es el símbolo que señala los cuatro puntos cardinales; Norte, Sur, Este y Oeste. En los mapas, la rosa de los vientos siempre orientará " +
                    "geográficamente señalando el norte hacia arriba)(IM,https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Rosa_de_los_vientos.svg/2048px-Rosa_de_los_vientos.svg.png)\n\n" +
                    "(VI,https://www.youtube.com/watch?v=Mad8refpcw4&ab_channel=Tipseducativosmx)\n\n" +
                    "(TI,Simbología) (TE,Son figuras, líneas, puntos o colores que sirven para representar la información del mapa)(IM,https://catedu.github.io/cartografia-para-montaneros/img/Leyenda%20del%20mapa2.jpg)\n" +
                    "(TI,Escala) (TE,Representa la relación que existe entre las medidas en un plano o mapa y las medidas en la realidad. Las escalas se representan en dos tipos, numérica y gráfica.)\n" +
                    "(TE,En el mapa que estás analizando de “Carreteras y principales ciudades de México”, tiene los dos tipos de escala, la numérica es de 1: 15 463 917)(IM,https://aprendeencasa.sep.gob.mx/multimedia/B64images/202110/B64-IMG-ZIF8boVWdt-sVYX1cYMjF.png)\n" +
                    "(TI,Coordenadas Geográficas) (TE, Son líneas imaginarias verticales y horizontales. En el siguiente planisferio se pueden visualizar mejor. )(IM,https://aprendeencasa.sep.gob.mx/multimedia/B64images/202110/B64-IMG-zKS0oz04Sm-eu971aO6HE.png)(AT,https://wordwall.net/es/resource/5253844/elementos-de-los-mapas)\n";

            longitud=cadena.length();
            muestra();
        }
        if(para.equals("2")) {
            cadena = "(TI,América) (TE,Este continente es el segundo continente más extenso y lo forma dos conjuntos América del Norte y América del Sur, bien diferenciados y unidos por América Central.)\n\n\n+ " +
                    "(TE,Océanos)\n\n\n" +
                    "(TE,Océanos Atlántico, Pacífico, G. Ártico y G. Antártico.)\n\n\n" +
                    "(TE,Mares)\n\n\n" +
                    "(TE,Mares principales: Mar del Caribe y Mar del Labrador) \n\n\n" +
                    "(IM,https://i0.wp.com/www3.gobiernodecanarias.org/medusa/ecoblog/msuaump/files/2012/11/mapa-fisico-america.jpg?w=887&ssl=1)" +
                    "(TI,África) (TE,África es el tercer continente más extenso, tras Asia y América. )\n\n\n+ " +
                    "(TE,Océanos)\n\n\n" +
                    "(TE,Océanos Atlántico e Índico (este y oeste).)\n\n\n" +
                    "(TE,Mares)\n\n\n" +
                    "(TE,Mares Mediterráneo y Rojo (al norte).) \n\n\n" +
                    "(IM,https://i0.wp.com/www3.gobiernodecanarias.org/medusa/ecoblog/msuaump/files/2012/11/africa.jpg?ssl=1)" +

                    "(TI,Europa) (TE,Europa es el segundo continente más pequeño. )\n\n\n+ " +
                    "(TE,Océanos)\n\n\n" +
                    "(TE,Océano Glacial Ártico y al este el Océano Atlántico)\n\n\n" +
                    "(TE,Mares)\n\n\n" +
                    "(TE,Mares Blanco, de Barents, Noruega, Báltico, del Norte, Cantábrico, Mediterráneo, Tirreno, Adriático, Jónico, Mármara, Negro, Azov y Caspio) \n\n\n" +
                    "(IM,https://i0.wp.com/www3.gobiernodecanarias.org/medusa/ecoblog/msuaump/files/2012/11/mapa-fc3adsico-de-europa.jpg?resize=1024%2C723&ssl=1)" +

                    "(TI,Asia) (TE,Asia es el continente más grande y poblado de la Tierra.)\n\n\n+ " +
                    "(TE,Océanos)\n\n\n" +
                    "(TE,Océano Índico, Océano Pacífico y Océano Glacial Ártico)\n\n\n" +
                    "(TE,Mares)\n\n\n" +
                    "(TE,Mar Rojo, Mar Arábigo, Mar de Japón, Mar de Bering y Mar de Aral.) \n\n\n" +
                    "(IM,https://i0.wp.com/www3.gobiernodecanarias.org/medusa/ecoblog/msuaump/files/2012/11/asia-fisica.jpg?w=961&ssl=1)" +

                    "(TI,Oceanía) (TE,Oceanía es un continente insular de la Tierra constituido por la plataforma continental de Australia, las islas de Nueva Guinea, Nueva Zelanda " +
                    "y los archipiélagos coralinos y volcánicos de Melanesia, Micronesia y Polinesia. )\n\n\n+ " +
                    "(TE,Océanos)\n\n\n" +
                    "(TE,El Océano Índico, Océano Pacífico, Océano Glaciar Antártico)\n\n\n" +
                    "(TE,Mares)\n\n\n" +
                    "(TE,Mares de Arafura, de Bismarck, de Coral, de Filipinas, de Halmahera, de Salomón, de Tasmania y de Timor) \n\n\n" +
                    "(IM,https://i0.wp.com/www3.gobiernodecanarias.org/medusa/ecoblog/msuaump/files/2012/11/asia-fisica.jpg?w=961&ssl=1)" +


                    "(VI,https://www.youtube.com/watch?v=YC76paJ1_Zs&ab_channel=SmileandLearn-Espa%C3%B1ol)";
            longitud = cadena.length();
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
            webView.loadUrl(codigo.substring(3));
                /*webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                        customScrollView.setEnableScrolling(false);
                        return super.shouldOverrideUrlLoading(view, request);
                    }
                });*/
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    1200));
            linearLayout2.setOrientation(LinearLayout.VERTICAL);

                /*webView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        customScrollView.setEnableScrolling(false);
                        Log.d("MapClick", "Map clicked");
                    }
                });*/

            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    customScrollView.setEnableScrolling(true);

                    return super.shouldOverrideUrlLoading(view, request);
                }
            });

            linearLayout2.addView(webView);

            linearLayout.addView(linearLayout2);

        }else if (codigo.substring(0, 2).contains("AT")) {

            WebView webView = new WebView(this);



            // Configurar el WebViewClient para gestionar las URL cargadas dentro del WebView
            webView.setWebViewClient(new MyWebViewClient());

            // Habilitar JavaScript (opcional)
            webView.getSettings().setJavaScriptEnabled(true);

            // Cargar la URL deseada
            webView.loadUrl(codigo.substring(3));
                /*webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                        customScrollView.setEnableScrolling(false);
                        return super.shouldOverrideUrlLoading(view, request);
                    }
                });*/
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            linearLayout2.setOrientation(LinearLayout.VERTICAL);

                /*webView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        customScrollView.setEnableScrolling(false);
                        Log.d("MapClick", "Map clicked");
                    }
                });*/

            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    customScrollView.setEnableScrolling(false);

                    return super.shouldOverrideUrlLoading(view, request);
                }
            });

            linearLayout2.addView(webView);

            linearLayout.addView(linearLayout2);

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
            intent.putExtra("Nombre", Nombre);
            intent.putExtra("Idusu",""+id);
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

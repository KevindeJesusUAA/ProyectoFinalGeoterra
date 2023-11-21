package uaa.mx.proyectofinalgeoterra;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class memorama extends AppCompatActivity {
    private String para;
    private int antes[] =new int[17],conta=0,pasos=0, index=0;
    private int aux=-1;
    private  List<Integer> Listos = new ArrayList<>();
    private  int llevado=0;
    @SuppressLint("ResourceType")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memorama);
        inicia();

        Bundle recibeIngreso = getIntent().getExtras(); //Vamos a recibir los datos del parametro, obteniendo el intento y llamamos al método de getExtras
        // para obtener un objeto Bundle que contiene los datos

        para = recibeIngreso.getString("parametro"); //Para recoger los datos, utilizamos la variable de bundle y con el metodo getstring obtenemos la clave de parametro
        // y vamos a almacenarlos en una variable de tipo string

        //mis imagenes  varios memoramas

        if(para.contains("3")){
            index=0;
        }else if (para.contains("continentes")) {
            index=1;
        }

        int[][] imagenes = {
                {R.drawable.c_alemania, R.drawable.china},//primeras 8
                {R.drawable.c_argentina, R.drawable.china},
                {R.drawable.c_brasil, R.drawable.china},
                {R.drawable.c_china, R.drawable.china},
                {R.drawable.c_cmexico, R.drawable.china},
                {R.drawable.c_espana, R.drawable.china},
                {R.drawable.c_estados, R.drawable.china},
                {R.drawable.c_francia, R.drawable.china},
                {R.drawable.c_alemania, R.drawable.china},//pares 8
                {R.drawable.c_argentina, R.drawable.china},
                {R.drawable.c_brasil, R.drawable.china},
                {R.drawable.c_china, R.drawable.china},
                {R.drawable.c_cmexico, R.drawable.china},
                {R.drawable.c_espana, R.drawable.china},
                {R.drawable.c_estados, R.drawable.china},
                {R.drawable.c_francia, R.drawable.china}
        };
        Random random = new Random();
        //mostrar las targetas
        List<ImageView> tarjetas = new ArrayList<>();
        //crear las targetas
        for (int i = 0; i < 16; i++) {
            ImageView tarjeta = new ImageView(this); // Cambia "this" por el contexto adecuado si estás en un fragmento.
            int indiceAleatorio=0;
            while (true){
                 indiceAleatorio = random.nextInt(16);
                 if(!ver(indiceAleatorio)){
                     break;
                 }
            }
            //System.out.println("numero ele "+indiceAleatorio);
            int imagenId = imagenes[indiceAleatorio][index];


            tarjeta.setId(indiceAleatorio);
            System.out.println(indiceAleatorio);
            tarjeta.setImageResource(R.drawable.imgagen);
            tarjeta.setLayoutParams(new GridLayout.LayoutParams());
            tarjeta.getLayoutParams().width = 0;
            tarjeta.getLayoutParams().height = 0;
            ((GridLayout.LayoutParams) tarjeta.getLayoutParams()).columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1f);
            ((GridLayout.LayoutParams) tarjeta.getLayoutParams()).rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1f);
            tarjeta.setScaleType(ImageView.ScaleType.FIT_CENTER);
            tarjetas.add(tarjeta);

            // Agrega un Listener para manejar la lógica de selección de tarjetas aquí.
            tarjeta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int idDeLaTarjeta = view.getId();
                    if(pasos<2){
                        ImageView tarjeta = (ImageView) view; // Convierte la vista a un ImageView
                        int nuevaImagenId =imagenes[idDeLaTarjeta][index]; // Reemplaza con la imagen que desees
                        tarjeta.setImageResource(nuevaImagenId);
                        //aqui crea la pausa

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // El código aquí se ejecutará después de la pausa
                                if(!busca(idDeLaTarjeta)){
                                    if (pasos == 0) {
                                        aux = idDeLaTarjeta;
                                        System.out.println("ver aux: " + aux);
                                    }
                                    if (pasos == 1) {
                                        if (aux == idDeLaTarjeta - 8 || aux - 8 == idDeLaTarjeta) {
                                            System.out.println("cool men:::" + aux + "  " + idDeLaTarjeta);
                                            Listos.add(aux);Listos.add(idDeLaTarjeta);
                                            llevado+=2;
                                            if(llevado==16){
                                                //ganasete
                                                Toast.makeText(memorama.this, "Felicidades Ganaste", Toast.LENGTH_SHORT).show();
                                                Bundle parametro = new Bundle(); //Se crea una instancia de la clase Bundle
                                                parametro.putString("Tema", para);//Vamos a asignar el tipo de dato que queremos compartir,
                                                // asignamos una llave o identificador para posteriormente recibirlo en la otra actividad
                                                // y por último, agregamos el texto que queremos compartir, que será la infomración del EditText

                                                // Inicia la nueva actividad cuando se hace clic en el botón
                                                Intent intent = new Intent(memorama.this, Evaluaciondim.class); // Reemplaza "NuevaActividad" con el nombre de tu nueva actividad
                                                intent.putExtras(parametro); //Ahora vamos a agregar los datos del ingreso que proporcionó el usuario, al objeto intent
                                                startActivity(intent);
                                            }
                                        } else {
                                            System.out.println("noo " + aux + "  " + idDeLaTarjeta);
                                            ImageView ca1 = findViewById(aux);
                                            ImageView ca2 = findViewById(idDeLaTarjeta);
                                            ca1.setImageResource(R.drawable.imgagen);
                                            ca2.setImageResource(R.drawable.imgagen);
                                        }
                                        pasos = -1;
                                        aux = -1;
                                    }
                                    pasos++;
                                }

                            }
                        }, 1000); // 2000 milisegundos (2 segundos) de pausa
                    }

                }
            });


            // Agrega la tarjeta al GridLayout.
            GridLayout gridLayout = findViewById(R.id.memog);
            gridLayout.addView(tarjeta);



        }

    }
    public void inicia(){
        for(int i=0;i<17;i++){
            antes[i]=-1;
        }
    }
    public boolean busca(int id){
        boolean aux=false;
        for (int i = 0; i < Listos.size(); i++) {
            int elemento = Listos.get(i);
            if(id==elemento){
                aux=true;
                break;
            }
            System.out.println("Elemento " + i + ": " + elemento);
        }
        return aux;

    }
    public  boolean ver(int busca){
        for(int i=0;i<17;i++){
            if(busca==antes[i]){
                return true;
            }
        }
        antes[conta]=busca;
        conta++;
        return false;
    }
    private void crearPausa() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               System.out.println("hola");
            }
        }, 2000); // 2 segundos de pausa
    }

}

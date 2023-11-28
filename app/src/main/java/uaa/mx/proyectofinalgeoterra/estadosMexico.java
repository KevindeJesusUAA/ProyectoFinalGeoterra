package uaa.mx.proyectofinalgeoterra;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Arrays;
import java.util.List;

import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;

import android.graphics.drawable.AnimationDrawable;

public class estadosMexico extends AppCompatActivity implements SensorEventListener {
    private ImageView flecha;
    private boolean flechaVisible = true;
    private LinearLayout linear;
    private TextView text[][]=new TextView[100][10];
    private SensorManager sensorManager;
    private Sensor sensores[]=new Sensor[100];
    private List<Sensor> listSensor;
    private TextView textView1;
    private ImageView pelota;
    private ImageView nuevaPelota;
    private int screanw,screanh;
    private Sensor gravedad;
    private float posX;
    private float posY;

    private static float CENTRO_X; // Posición x del centro de la pantalla
    private static float CENTRO_Y; // Posición y del centro de la pantalla
    private boolean pelotaEnCentro = false;
    private int selectedItemPosition = 0;
    private boolean[] itemUsado = new boolean[10];
    private boolean pelotaMovimiento = false;
    private int correctas=0;

    private MediaPlayer mediaPlayer; // Variable para el reproductor de música

    private ObjectAnimator scaleAnimator;
    private ObjectAnimator rotateAnimator;

    private ImageView animacionImageView, imageView;
    private AnimationDrawable animacionPelota;

    private String Nombre,id;
    private String para;

    private int elementosSeleccionados = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estados_mexico);

        //Bundle recibeIngreso = getIntent().getExtras(); //Vamos a recibir los datos del parametro, obteniendo el intento y llamamos al método de getExtras
        // para obtener un objeto Bundle que contiene los datos

        //para = recibeIngreso.getString("parametro"); //Para recoger los datos, utilizamos la variable de bundle y con el metodo getstring obtenemos la clave de parametro
        // y vamos a almacenarlos en una variable de tipo string


        //Nombre = recibeIngreso.getString("Nombre"); //Para recoger los datos, utilizamos la variable de bundle y con el metodo getstring obtenemos la clave de parametro
        //id= recibeIngreso.getString("Idusu");
        Bundle recibeIngreso = getIntent().getExtras();
        Nombre = recibeIngreso.getString("Nombre"); //Para recoger los datos, utilizamos la variable de bundle y con el metodo getstring obtenemos la clave de parametro
        id= recibeIngreso.getString("Idusu");

        Arrays.fill(itemUsado, false);

        pelota=findViewById(R.id.brujula);
        nuevaPelota = new ImageView(this);
        flecha = findViewById(R.id.flecha);

        DisplayMetrics displayMetrics = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screanw = displayMetrics.widthPixels;
        screanh = displayMetrics.heightPixels;

        imageView=findViewById(R.id.imageView3);

        float screanwImage = imageView.getDrawable().getIntrinsicWidth();
        float screanhImage = imageView.getDrawable().getIntrinsicHeight();

        flecha.setVisibility(View.VISIBLE);

        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.opciones_imagenes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Inicializa las variables CENTRO_X y CENTRO_Y y las posiciones iniciales de la flecha
        initSpinnerValues(0);

        /*spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selectedItemPosition = position;
                if (position != 0 && !itemUsado[position - 1]) {
                    // Reinicia la posición de la pelota cuando seleccionas la segunda opción
                    reiniciarPosicionPelota();
                    flecha.setVisibility(View.VISIBLE);
                    pelotaEnCentro = false;
                    itemUsado[position - 1] = true;
                } else {
                    pelota.setVisibility(View.VISIBLE);
                    flecha.setVisibility(View.VISIBLE);
                }
                // Actualiza las variables CENTRO_X y CENTRO_Y y las posiciones iniciales de la flecha
                initSpinnerValues(selectedItemPosition);
                // Ajusta la posición de la pelota según el elemento seleccionado
                ajustarPosicionPelotaSegunElemento();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Maneja la situación donde no se ha seleccionado nada
            }
        });*/
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (!pelotaMovimiento) {
                    selectedItemPosition = position;
                    if (position != 0 && !itemUsado[position - 1]) {

                        // Incrementa el contador de elementos seleccionados
                        elementosSeleccionados++;

                        // Reinicia la posición de la pelota cuando seleccionas la segunda opción
                        reiniciarPosicionPelota();
                        flecha.setVisibility(View.VISIBLE);
                        pelotaEnCentro = false;
                        itemUsado[position - 1] = true;
                    } else {
                        pelota.setVisibility(View.VISIBLE);
                        flecha.setVisibility(View.VISIBLE);
                    }
                    // Actualiza las variables CENTRO_X y CENTRO_Y y las posiciones iniciales de la flecha
                    initSpinnerValues(selectedItemPosition);
                    // Ajusta la posición de la pelota según el elemento seleccionado
                    ajustarPosicionPelotaSegunElemento();
                } else {
                    // Muestra un mensaje indicando que la pelota aún está en movimiento
                    Toast.makeText(estadosMexico.this, "La pelota aún está en movimiento", Toast.LENGTH_SHORT).show();
                    // Deselecciona el elemento actual para evitar que se seleccione mientras la pelota está en movimiento
                    spinner.setSelection(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Maneja la situación donde no se ha seleccionado nada
            }
        });

        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        gravedad = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);

        // Inicializa los animadores de escala y rotación
        scaleAnimator = ObjectAnimator.ofFloat(pelota, "scaleX", 1f, 1.5f, 1f);
        scaleAnimator.setDuration(500);  // Duración de la animación en milisegundos
        scaleAnimator.setInterpolator(new DecelerateInterpolator());  // Interpolador para una animación de desaceleración

        rotateAnimator = ObjectAnimator.ofFloat(pelota, "rotation", 0f, 360f);
        rotateAnimator.setDuration(500);  // Duración de la animación en milisegundos
        rotateAnimator.setInterpolator(new DecelerateInterpolator());  // Interpolador para una animación de desaceleración

        animacionImageView = findViewById(R.id.animacionImageView);
        animacionPelota = (AnimationDrawable) getResources().getDrawable(R.drawable.animacion_bien);


    }

    // Método para inicializar las variables CENTRO_X, CENTRO_Y y las posiciones iniciales de la flecha
    private void initSpinnerValues(int position) {
        switch (position) {
            case 0:
                CENTRO_X = screanw / 2-50;
                CENTRO_Y = screanh / 2-25;
                flecha.setX(CENTRO_X-50);
                flecha.setY(CENTRO_Y-50);
                break;
            case 1:
                CENTRO_X = (float) (screanw / 2 * 1.6);
                CENTRO_Y = (float) (screanh / 3 * 1.2);
                flecha.setX(CENTRO_X-50);
                flecha.setY(CENTRO_Y-50);
                break;
            case 2:
                CENTRO_X = screanw / 2 + 160;
                CENTRO_Y = screanh / 2 - 620;
                flecha.setX(CENTRO_X-50);
                flecha.setY(CENTRO_Y-50);
                break;
            case 3:
                CENTRO_X = screanw / 2-160;
                CENTRO_Y = screanh / 2+20;
                flecha.setX(CENTRO_X-50);
                flecha.setY(CENTRO_Y-50);
                break;
            case 4:
                CENTRO_X = screanw / 2 - 360;
                CENTRO_Y = screanh / 2 - 100;
                flecha.setX(CENTRO_X - 50);
                flecha.setY(CENTRO_Y - 50);
                break;
            case 5:
                CENTRO_X = screanw / 2 + 20;
                CENTRO_Y = screanh / 2 - 150;
                flecha.setX(CENTRO_X - 50);
                flecha.setY(CENTRO_Y - 50);
                break;
            case 6:
                CENTRO_X = (float) (screanw / 2 * 1.5);
                CENTRO_Y = (float) (screanw / 2 * 2.1);
                flecha.setX(CENTRO_X - 50);
                flecha.setY(CENTRO_Y - 50);
                break;
            case 7:
                CENTRO_X = screanw / 2 - 360;
                CENTRO_Y = screanh / 2 + 230;
                flecha.setX(CENTRO_X - 50);
                flecha.setY(CENTRO_Y - 50);
                break;
            case 8:
                CENTRO_X = screanw / 2 - 500;
                CENTRO_Y = screanh / 2 + 450;
                flecha.setX(CENTRO_X - 50);
                flecha.setY(CENTRO_Y - 50);
                break;
            case 9:
                CENTRO_X = screanw / 2 - 310;
                CENTRO_Y = screanh / 2 + 975;
                flecha.setX(CENTRO_X - 50);
                flecha.setY(CENTRO_Y - 50);
                break;
        }
    }

    // Método para ajustar la posición de la pelota según el elemento seleccionado
    private void ajustarPosicionPelotaSegunElemento() {
        if (selectedItemPosition >= 0 && selectedItemPosition < 10) {
            pelota.setX(CENTRO_X - 50);
            pelota.setY(CENTRO_Y - 50);
        }
    }

    /*@Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_GRAVITY && !pelotaEnCentro) {
            float x = event.values[0]*5;
            float y = event.values[1]*5;

            if (pelota.getVisibility() == View.VISIBLE) {
                posX -= x;
                posY += y;

                posX = Math.min(Math.max(0, posX), screanw - pelota.getWidth());
                posY = Math.min(Math.max(0, posY), screanh - pelota.getHeight());

                if (!pelotaEnCentro) {
                    pelota.setX(posX);
                    pelota.setY(posY);
                }
            }

            if (Math.abs(posX + pelota.getWidth() / 2 - CENTRO_X) < 15 && Math.abs(posY + pelota.getHeight() / 2 - CENTRO_Y) < 15) {
                pelotaEnCentro = true;
                flecha.setVisibility(View.GONE);
            }
        }
    }*/

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_GRAVITY && !pelotaEnCentro) {
            float x = event.values[0] * 5;
            float y = event.values[1] * 5;

            if (pelota.getVisibility() == View.VISIBLE) {
                posX -= x;
                posY += y;

                posX = Math.min(Math.max(0, posX), screanw - pelota.getWidth());
                posY = Math.min(Math.max(0, posY), screanh - pelota.getHeight());

                if (!pelotaEnCentro) {
                    pelota.setX(posX);
                    pelota.setY(posY);
                    pelotaMovimiento = true;
                }
            }

            if (pelotaMovimiento) {
                // Oculta animacionImageView cuando la pelota está en movimiento
                animacionImageView.setVisibility(View.GONE);
            } else {
                // Muestra animacionImageView cuando la pelota se detiene
                animacionImageView.setVisibility(View.VISIBLE);

            }

            if (Math.abs(posX + pelota.getWidth() / 2 - CENTRO_X) < 15 && Math.abs(posY + pelota.getHeight() / 2 - CENTRO_Y) < 15) {
                pelotaEnCentro = true;
                flecha.setVisibility(View.GONE);
                pelotaMovimiento = false;

                // Reproducir el sonido solo si no se ha reproducido aún
                if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                    // Inicializar el reproductor de música y cargar el archivo de música desde res/raw
                    mediaPlayer = MediaPlayer.create(this, R.raw.nivel); // Reemplaza "nombre_del_archivo" con el nombre de tu archivo de música

                    // Configurar para que la música no se repita en bucle
                    mediaPlayer.setLooping(false);

                    // Iniciar la reproducción de música de fondo
                    mediaPlayer.start();
                }

                // Iniciar las animaciones de escala y rotación cuando la pelota se detiene
                if (scaleAnimator != null && !scaleAnimator.isRunning()) {
                    scaleAnimator.start();
                }

                if (rotateAnimator != null && !rotateAnimator.isRunning()) {
                    rotateAnimator.start();
                }

                // Iniciar la animación en la segunda ImageView
                if (animacionPelota != null) {
                    animacionImageView.setVisibility(View.VISIBLE);
                    animacionImageView.setImageDrawable(animacionPelota);
                    animacionPelota.start();
                }

                /*if (selectedItemPosition == 9 && pelotaEnCentro) {
                    // Mostrar un Toast de felicitaciones
                    //Toast.makeText(estadosMexico.this, "¡Felicidades!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "Felicidades pasaste", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(estadosMexico.this, Evaluaciondim.class);

                    System.out.println("vaya");
                    // Poner las respuestas seleccionadas como extras en el Intent

                    intent.putExtra("Nombre",Nombre);
                    intent.putExtra("Idusu",id);
                    intent.putExtra("Tema","5");
                    startActivity(intent);
                }*/
                if (elementosSeleccionados == 9) {
                    // Mostrar un Toast de felicitaciones
                    Toast.makeText(estadosMexico.this, "¡Felicidades! Has completado todos los elementos", Toast.LENGTH_SHORT).show();

                    // Iniciar la actividad de evaluación
                    Intent intent = new Intent(estadosMexico.this, Evaluaciondim.class);
                    intent.putExtra("Nombre", Nombre);
                    intent.putExtra("Idusu", id);
                    intent.putExtra("Tema", "5");
                    startActivity(intent);
                }
            }
        }
    }

    private void reiniciarPosicionPelota() {
        posX = 0 ;
        posY = 0 ;
        pelota.setX(posX);
        pelota.setY(posY);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
    @Override
    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(this,gravedad,sensorManager.SENSOR_DELAY_GAME);
    }
    protected void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
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

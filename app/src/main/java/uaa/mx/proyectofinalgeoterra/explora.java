package uaa.mx.proyectofinalgeoterra;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class explora extends AppCompatActivity implements OnMapReadyCallback {
    /*
    //En el método onCreate creamos la actividad y se configura
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explora_conmigo);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(21.91415, -102.3168);
        mMap.addMarker(new MarkerOptions()
                .position(sydney)
                .title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }*/

    private GoogleMap mMap;
    private ListView listView;
    private ArrayAdapter<String> adapter;

    private ImageView imageView;
    private CustomScrollView customScrollView;
    private Button btnEvaluacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explora_conmigo);

        customScrollView = findViewById(R.id.customScrollView);
        customScrollView.setEnableScrolling(true);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Inicializa el ImageView
        imageView = findViewById(R.id.imageView);

        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, obtenerNombresCoordenadas());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Llama al método actualizarMapa con la posición seleccionada
                actualizarMapa(position);
                customScrollView.setEnableScrolling(true);
            }
        });

        btnEvaluacion = findViewById(R.id.btnEnviar);

        btnEvaluacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Declaramos el método onClick

                //Bundle parametro = new Bundle(); //Se crea una instancia de la clase Bundle
                //parametro.putString("parametro", "pais");//Vamos a asignar el tipo de dato que queremos compartir,
                // asignamos una llave o identificador para posteriormente recibirlo en la otra actividad
                // y por último, agregamos el texto que queremos comparti

                // Inicia la nueva actividad cuando se hace clic en el botón
                Intent intent = new Intent(explora.this, evaluacion.class);
                //intent.putExtras(parametro); //Ahora vamos a agregar los datos del ingreso que proporcionó el usuario, al objeto intent
                startActivity(intent);

            }
        });

    }

    private void actualizarMapa(int position) {
        // Limpiar marcadores existentes
        mMap.clear();

        // Determina la ubicación según la posición seleccionada
        LatLng ubicacion;
        String nombreUbicacion;
        int imagenResourceId;

        if (position == 0) {
            // La Gran Muralla China
            ubicacion = new LatLng(40.4319077, 116.5703749);
            nombreUbicacion = "La Gran Muralla China";
            imagenResourceId = R.drawable.muralla_china;

            // Agrega marcador en las nuevas coordenadas y mueve la cámara
            mMap.addMarker(new MarkerOptions()
                    .position(ubicacion)
                    .title(nombreUbicacion));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));

            // Agrega un listener al mapa para deshabilitar el desplazamiento del ScrollView
            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    customScrollView.setEnableScrolling(false); // Deshabilita el desplazamiento
                    Log.d("MapClick", "Map clicked");
                }
            });

            // Actualiza el ImageView con la imagen correspondiente
            imageView.setImageResource(imagenResourceId);
        } else if (position == 1){
            // Petra
            ubicacion = new LatLng(30.3284544, 35.4443622);
            nombreUbicacion = "Petra";
            imagenResourceId = R.drawable.petra;

            // Agrega marcador en las nuevas coordenadas y mueve la cámara
            mMap.addMarker(new MarkerOptions()
                    .position(ubicacion)
                    .title(nombreUbicacion));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));

            // Agrega un listener al mapa para deshabilitar el desplazamiento del ScrollView
            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    customScrollView.setEnableScrolling(false); // Deshabilita el desplazamiento
                    Log.d("MapClick", "Map clicked");
                }
            });

            // Actualiza el ImageView con la imagen correspondiente
            imageView.setImageResource(imagenResourceId);
        } else if (position == 2){
            // Coliseo
            ubicacion = new LatLng(41.8902102, 12.4922309);
            nombreUbicacion = "Coliseo";
            imagenResourceId = R.drawable.coliseo;

            // Agrega marcador en las nuevas coordenadas y mueve la cámara
            mMap.addMarker(new MarkerOptions()
                    .position(ubicacion)
                    .title(nombreUbicacion));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));

            // Agrega un listener al mapa para deshabilitar el desplazamiento del ScrollView
            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    customScrollView.setEnableScrolling(false); // Deshabilita el desplazamiento
                    Log.d("MapClick", "Map clicked");
                }
            });

            // Actualiza el ImageView con la imagen correspondiente
            imageView.setImageResource(imagenResourceId);
        } else if (position == 3){
            // Coliseo
            ubicacion = new LatLng(20.6842849, -88.5677826);
            nombreUbicacion = "Chichen Itza";
            imagenResourceId = R.drawable.chichen_itza;

            // Agrega marcador en las nuevas coordenadas y mueve la cámara
            mMap.addMarker(new MarkerOptions()
                    .position(ubicacion)
                    .title(nombreUbicacion));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));

            // Agrega un listener al mapa para deshabilitar el desplazamiento del ScrollView
            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    customScrollView.setEnableScrolling(false); // Deshabilita el desplazamiento
                    Log.d("MapClick", "Map clicked");
                }
            });

            // Actualiza el ImageView con la imagen correspondiente
            imageView.setImageResource(imagenResourceId);
        } else if (position == 4){
            // Coliseo
            ubicacion = new LatLng(-22.951916, -43.2104872);
            nombreUbicacion = "Cristo Rendedor";
            imagenResourceId = R.drawable.cristo_rendedor;

            // Agrega marcador en las nuevas coordenadas y mueve la cámara
            mMap.addMarker(new MarkerOptions()
                    .position(ubicacion)
                    .title(nombreUbicacion));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));

            // Agrega un listener al mapa para deshabilitar el desplazamiento del ScrollView
            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    customScrollView.setEnableScrolling(false); // Deshabilita el desplazamiento
                    Log.d("MapClick", "Map clicked");
                }
            });

            // Actualiza el ImageView con la imagen correspondiente
            imageView.setImageResource(imagenResourceId);
        }else if (position == 5){
            // Coliseo
            ubicacion = new LatLng(-13.1631412, -72.5449629);
            nombreUbicacion = "Machu Pichu";
            imagenResourceId = R.drawable.machu_pichu;

            // Agrega marcador en las nuevas coordenadas y mueve la cámara
            mMap.addMarker(new MarkerOptions()
                    .position(ubicacion)
                    .title(nombreUbicacion));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));

            // Agrega un listener al mapa para deshabilitar el desplazamiento del ScrollView
            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    customScrollView.setEnableScrolling(false); // Deshabilita el desplazamiento
                    Log.d("MapClick", "Map clicked");
                }
            });

            // Actualiza el ImageView con la imagen correspondiente
            imageView.setImageResource(imagenResourceId);
        }else if (position == 6){
            // Coliseo
            ubicacion = new LatLng(27.1750151, 78.0421552);
            nombreUbicacion = "Taj Mahal";
            imagenResourceId = R.drawable.taj_mahal;

            // Agrega marcador en las nuevas coordenadas y mueve la cámara
            mMap.addMarker(new MarkerOptions()
                    .position(ubicacion)
                    .title(nombreUbicacion));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));

            // Agrega un listener al mapa para deshabilitar el desplazamiento del ScrollView
            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    customScrollView.setEnableScrolling(false); // Deshabilita el desplazamiento
                    Log.d("MapClick", "Map clicked");
                }
            });

            // Actualiza el ImageView con la imagen correspondiente
            imageView.setImageResource(imagenResourceId);
        }
    }

    private String[] obtenerNombresCoordenadas() {
        return new String[]{"La Gran Muralla China", "Petra","Coliseo","Chichen Itza","Cristo Rendedor","Machu Pichu","Taj Mahal"};
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Mostrar un marcador por defecto al iniciar el mapa
        LatLng defaultLocation = new LatLng(40.4319077, 116.5703749);
        mMap.addMarker(new MarkerOptions()
                .position(defaultLocation)
                .title("La Gran Muralla China"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(defaultLocation));

        // Agrega un listener al mapa para deshabilitar el desplazamiento del ScrollView
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                customScrollView.setEnableScrolling(false); // Deshabilita el desplazamiento
            }
        });
    }
}

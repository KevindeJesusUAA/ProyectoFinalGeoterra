package uaa.mx.proyectofinalgeoterra;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {
    /*Gestor de la base de datos*/
    private static final String DATABASE_NAME = "Geoterra";
    private static final int DATABASE_VERSION = 1;
    public DatabaseHelper(Context context) {
        //crea la base de datos
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            //usuario
            db.execSQL("CREATE TABLE usuarios (\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    nombre TEXT NOT NULL,\n" +
                    "    contraseña TEXT NOT NULL,\n" +
                    "    edad TEXT,\n" +
                    "    color TEXT,\n" +
                    "    direccion TEXT\n" +
                    ");\n");
            //preguntas
            db.execSQL("CREATE TABLE temas (\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    nombre TEXT NOT NULL,\n" +
                    "    texto TEXT,\n" +
                    "    dinamica TEXT\n" +
                    ");\n");
            //Aplica
            db.execSQL("CREATE TABLE aplica (\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    calificacion REAL,\n" +
                    "    fk_usuario INTEGER,\n" +
                    "    fk_tema INTEGER,\n" +
                    "    FOREIGN KEY (fk_usuario) REFERENCES usuarios(id),\n" +
                    "    FOREIGN KEY (fk_tema) REFERENCES temas(id)\n" +
                    ");\n");
            db.execSQL("CREATE TABLE cuestionario (\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    pregunta TEXT,\n" +
                    "    respuesta TEXT,\n" +
                    "    fk_tema INTEGER,\n" +
                    "    FOREIGN KEY (fk_tema) REFERENCES temas(id)\n" +
                    ");\n");
            System.out.println("enteeeeeeeeeeeeeeeeeeeeeeeeee");


        }catch (Exception e){
            System.out.println("Error..............................................");
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long insertUsuario(String nombre, String contraseña, String edad, String color,String direccion) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("contraseña", contraseña);
        values.put("edad", edad);
        values.put("color", color);
        values.put("direccion", direccion);
        try {
            long newRowId = db.insert("usuarios", null, values);
            db.close();

            return newRowId;
        } catch (SQLException e) {
            // Manejo de errores en caso de que falle la inserción
            e.printStackTrace();
            return -1;
        }
    }

    @SuppressLint("Range")
    public List<HashMap<String, String>> getAllUsers() {
        List<HashMap<String, String>> userList = new ArrayList<>();

        // Consulta SQL para obtener todos los registros de la tabla "usuarios"
        String query = "SELECT * FROM usuarios";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // Procesa los resultados
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> user = new HashMap<>();
                user.put("id", cursor.getString(cursor.getColumnIndex("id")));
                user.put("nombre", cursor.getString(cursor.getColumnIndex("nombre")));
                user.put("contraseña", cursor.getString(cursor.getColumnIndex("contraseña")));
                user.put("edad", cursor.getString(cursor.getColumnIndex("edad")));
                user.put("color", cursor.getString(cursor.getColumnIndex("color")));
                user.put("direccion", cursor.getString(cursor.getColumnIndex("direccion")));
                userList.add(user);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return userList;
    }
    public boolean verificarCredenciales(String nombre, String contraseña) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM usuarios WHERE nombre = ? AND contraseña = ?";
        String[] selectionArgs = {nombre, contraseña};

        Cursor cursor = db.rawQuery(query, selectionArgs);

        boolean existeUsuario = cursor.moveToFirst();

        cursor.close();

        return existeUsuario;
    }




}

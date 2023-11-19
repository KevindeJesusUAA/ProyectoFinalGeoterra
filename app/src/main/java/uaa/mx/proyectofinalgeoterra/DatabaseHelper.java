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
            //insercon de temas


        }catch (Exception e){
            System.out.println("Error..............................................");
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void meterpre() {
       /* SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO cuestionario  VALUES (null,'¿Pregunta 1?', 'Respuesta 1', 5);");
        db.execSQL("INSERT INTO cuestionario VALUES (null,'(TE,¿Qué estado es este?)(IM,https://www.cuentame.inegi.org.mx/monografias/imagenes/div/bc.gif)', 'Baja California', 5);");
        db.execSQL("INSERT INTO cuestionario VALUES (null,'(TE,¿Qué estado es este?)(IM,https://www.google.com/url?sa=i&url=https%3A%2F%2Fparatodomexico.com%2Festados-de-mexico%2Festado-baja-california-sur%2Findex.html&psig=AOvVaw0QYnp1yeZJmCE6_Gb2dwTP&ust=1700289515876000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCJih15a2yoIDFQAAAAAdAAAAABAR)', 'Baja California Sur', 5);");
        db.execSQL("INSERT INTO cuestionario  VALUES (null,'(TE,¿Qué estado es este?)(IM,https://www.google.com/url?sa=i&url=https%3A%2F%2Fcuentame.inegi.org.mx%2Fmonografias%2Finformacion%2Fcamp%2Fterritorio%2Fdiv_municipal.aspx%3Ftema%3Dme%26e%3D04&psig=AOvVaw2ceVVfTtFBlGCvx2GdwvzB&ust=1700289789793000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCICtmpm3yoIDFQAAAAAdAAAAABAE)', 'Campeche', 5);");
        db.execSQL("INSERT INTO cuestionario  VALUES (null,'(TE,¿Qué estado es este?)(IM,https://www.google.com/url?sa=i&url=https%3A%2F%2Fcuentame.inegi.org.mx%2Fmonografias%2Finformacion%2Fcoah%2Fterritorio%2Fdiv_municipal.aspx%3Ftema%3Dme%26e%3D05&psig=AOvVaw1l7SLN_SPN3w_KMojNyVFy&ust=1700289846974000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCIjjwbS3yoIDFQAAAAAdAAAAABAJ)', 'Coahuila', 5);");
        db.execSQL("INSERT INTO cuestionario VALUES (null,'(TE,¿Qué estado es este?)(IM,https://www.google.com/url?sa=i&url=https%3A%2F%2Fcuentame.inegi.org.mx%2Fmonografias%2Finformacion%2Fcol%2Fterritorio%2F&psig=AOvVaw3xr2Y8SBoFjqsYS1xGhGfn&ust=1700289876783000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCNia3sK3yoIDFQAAAAAdAAAAABAJ)', 'Colima', 5);");
        db.execSQL("INSERT INTO cuestionario  VALUES (null,'(TE,¿Qué estado es este?)(IM,https://www.google.com/url?sa=i&url=https%3A%2F%2Fskam49.angelfire.com%2Fchiapas.htm&psig=AOvVaw2YrGHhqRFk22dcv2s4CASL&ust=1700289903780000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCOD8zc-3yoIDFQAAAAAdAAAAABAW)', 'Chiapas', 5);");
        db.execSQL("INSERT INTO cuestionario  VALUES (null,'(TE,¿Qué estado es este?)(IM,https://www.google.com/url?sa=i&url=https%3A%2F%2Fcuentame.inegi.org.mx%2Fmonografias%2Finformacion%2Fchih%2Fterritorio%2Fdiv_municipal.aspx%3Ftema%3Dme%26e%3D08&psig=AOvVaw1ixC2gZ7ai8rHmiW6AxpGO&ust=1700289963395000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCICx8Ou3yoIDFQAAAAAdAAAAABAE)', 'Chihuahua', 5);");
        db.execSQL("INSERT INTO cuestionario VALUES (null,'(TE,¿Qué estado es este?)(IM,https://www.google.com/url?sa=i&url=https%3A%2F%2Fcuentame.inegi.org.mx%2Fmonografias%2Finformacion%2Fdur%2Fterritorio%2Fdiv_municipal.aspx%3Ftema%3Dme%26e%3D10&psig=AOvVaw0hKE2lDMGBn1J0tQyfuz2R&ust=1700289990092000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCODP3vi3yoIDFQAAAAAdAAAAABAI)', 'Durango', 5);");
        db.execSQL("INSERT INTO cuestionario  VALUES (null,'(TE,¿Qué estado es este?)(IM,https://www.google.com/url?sa=i&url=https%3A%2F%2Fmr.travelbymexico.com%2F685-estado-de-guanajuato%2F&psig=AOvVaw2rg5SxRCpj1UjScNIwukrI&ust=1700290036196000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCOi52o64yoIDFQAAAAAdAAAAABAE)', 'Guanajuato', 5);");
        db.execSQL("INSERT INTO cuestionario  VALUES (null,'(TE,¿Qué estado es este?)(IM,https://www.google.com/url?sa=i&url=https%3A%2F%2Fmr.travelbymexico.com%2F688-estado-de-guerrero%2F&psig=AOvVaw1haav5RbfsQjA75T2WwagP&ust=1700290069866000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCICK4Z64yoIDFQAAAAAdAAAAABAE', 'Guerrero', 5);");
        db.execSQL("INSERT INTO cuestionario  VALUES (null,'(TE,¿Qué estado es este?)(IM,https://www.google.com/url?sa=i&url=https%3A%2F%2Fes.wikipedia.org%2Fwiki%2FEstado_de_Hidalgo&psig=AOvVaw0EeY7s03PgUB7mu9fdIlsI&ust=1700290090157000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCICTwKi4yoIDFQAAAAAdAAAAABAE', 'Hidalgo', 5);");
        db.execSQL("INSERT INTO cuestionario VALUES (null,'(TE,¿Qué estado es este?)(IM,https://www.google.com/url?sa=i&url=https%3A%2F%2Fes.wikivoyage.org%2Fwiki%2FJalisco&psig=AOvVaw1qKp3gmnEbpEscLy41PmWH&ust=1700290117716000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCKCZy7W4yoIDFQAAAAAdAAAAABAE)', 'Jalisco', 5);");
        db.execSQL("INSERT INTO cuestionario VALUES (null,'(TE,¿Qué estado es este?)(IM,https://www.google.com/url?sa=i&url=https%3A%2F%2Fmr.travelbymexico.com%2F698-estado-de-mexico%2F&psig=AOvVaw1EFMuzUS-DzEdqF5oUkP7F&ust=1700290139521000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCMjdgcC4yoIDFQAAAAAdAAAAABAE)', 'México', 5);");
        db.execSQL("INSERT INTO cuestionario  VALUES (null,'(TE,¿Qué estado es este?)(IM,https://www.google.com/url?sa=i&url=https%3A%2F%2Fmr.travelbymexico.com%2F701-estado-de-michoacan%2F&psig=AOvVaw1TRdARbxMdwfCr1NtXCxpg&ust=1700290421574000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCJjxuMa5yoIDFQAAAAAdAAAAABAE)', 'Michoacán', 5);");
  */  }

    public void metertemas(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO temas  VALUES (null,'Mapas', 'Texto del tema 1', 'Dinámica del tema 1');");
        db.execSQL("INSERT INTO temas  VALUES (null,'Continentes', 'Texto del tema 2', 'Dinámica del tema 2');");
        db.execSQL("INSERT INTO temas  VALUES (null,'Paises', 'Texto del tema 3', 'Dinámica del tema 3');");
        db.execSQL("INSERT INTO temas  VALUES (null,'Explora', 'Texto del tema 4', 'Dinámica del tema 4');");
        db.execSQL("INSERT INTO temas  VALUES (null,'Estados', 'Texto del tema 5', 'Dinámica del tema 5');");
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
    @SuppressLint("Range")
    public List<HashMap<String, String>> gettemas() {
        List<HashMap<String, String>> userList = new ArrayList<>();

        // Consulta SQL para obtener todos los registros de la tabla "usuarios"
        String query = "SELECT * FROM temas";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // Procesa los resultados
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> user = new HashMap<>();
                user.put("id", cursor.getString(cursor.getColumnIndex("id")));
                user.put("nombre", cursor.getString(cursor.getColumnIndex("nombre")));
                user.put("texto", cursor.getString(cursor.getColumnIndex("texto")));
                user.put("dinamica", cursor.getString(cursor.getColumnIndex("dinamica")));

                userList.add(user);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return userList;
    }
    //tabla vacia
    public boolean tablavacia(String tabla) {
        // Definir la consulta para contar los registros en la tabla temas
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT COUNT(*) FROM "+tabla+";";

        // Ejecutar la consulta y obtener un cursor
        Cursor cursor = db.rawQuery(query, null);

        // Mover el cursor al primer registro
        cursor.moveToFirst();

        // Obtener el valor del conteo
        int count = cursor.getInt(0);

        // Cerrar el cursor
        cursor.close();

        // Devolver true si la tabla está vacía, false si tiene al menos un registro
        return count == 0;
    }
    public int noregis( String nombreDeLaTabla,String donde) {
        SQLiteDatabase db= this.getReadableDatabase();
        String consulta = "SELECT COUNT(*) FROM " + nombreDeLaTabla+" WHERE fk_tema="+donde;
        Cursor cursor = db.rawQuery(consulta, null);

        int recuento = 0;

        if (cursor.moveToFirst()) {
            recuento = cursor.getInt(0);
        }

        cursor.close();

        return recuento;
    }





}

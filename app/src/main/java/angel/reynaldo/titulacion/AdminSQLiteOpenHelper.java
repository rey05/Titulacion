package angel.reynaldo.titulacion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Angel on 06/05/2015.
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table alumnos (nocontrol integer primary key unique, nombre text, apellidos text, email text, carrera text, egreso text, ot text, fechat text, observaciones text) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists alumnos");
        db.execSQL("create table alumnos (nocontrol integer primary key unique, nombre text, apellidos text, email text, carrera text, egreso text, ot text, fechat text, observaciones text) ");
    }
}

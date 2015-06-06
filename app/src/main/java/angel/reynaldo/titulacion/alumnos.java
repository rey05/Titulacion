package angel.reynaldo.titulacion;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class alumnos extends ActionBarActivity {
    EditText nocontrol, nombre, apellidos, email, carrera, egreso, ot, fechat, observaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);

        nocontrol = (EditText) findViewById(R.id.nocontrol);
        nombre = (EditText) findViewById(R.id.nombre);
        apellidos= (EditText) findViewById(R.id.apellidos);
        email = (EditText) findViewById(R.id.email);
        carrera = (EditText) findViewById(R.id.carrera);
        egreso = (EditText) findViewById(R.id.egreso);
        ot = (EditText) findViewById(R.id.ot);
        fechat = (EditText) findViewById(R.id.ft);
        observaciones = (EditText) findViewById(R.id.observacion);
    }

    public void alta(View v){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "alumnos", null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String Nocontrol= nocontrol.getText().toString();
        String Nombre = nombre.getText().toString();
        String Apellidos = apellidos.getText().toString();
        String Email = email.getText().toString();
        String Carrera = carrera.getText().toString();
        String Egreso = egreso.getText().toString();
        String Ot = ot.getText().toString();
        String Fechat = fechat.getText().toString();
        String Observaciones = observaciones.getText().toString();


        Cursor fila = bd.rawQuery("select nombre, apellidos, email, carrera, egreso, ot, fechat, observaciones from alumnos where nocontrol=" + Nocontrol, null);
        if (fila.getCount()>=1){

            Toast.makeText(this, "No se puede agregar, el Numero de control ya existe", Toast.LENGTH_SHORT).show();

        }else {
            ContentValues registro = new ContentValues();


            registro.put("nocontrol", Nocontrol);
            registro.put("nombre", Nombre);
            registro.put("apellidos", Apellidos);
            registro.put("email", Email)    ;
            registro.put("carrera", Carrera);
            registro.put("egreso", Egreso);
            registro.put("ot", Ot);
            registro.put("fechat", Fechat);
            registro.put("observaciones", Observaciones);

            bd.insert("alumnos", null, registro);
            bd.close();

            nocontrol.setText("");
            nombre.setText("");
            apellidos.setText("");
            email.setText("");
            carrera.setText("");
            egreso.setText("");
            ot.setText("");
            fechat.setText("");
            observaciones.setText("");

            Toast.makeText(this, "Se agrego un nuevo alumno", Toast.LENGTH_SHORT).show();
        }
    }

    public void consulta (View v) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "alumnos", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String Nocontrol = nocontrol.getText().toString();


        Cursor fila = bd.rawQuery("select nombre, apellidos, email, carrera, egreso, ot, fechat, observaciones from alumnos where nocontrol=" + Nocontrol, null);
        if (fila.moveToFirst()){

            nombre.setText(fila.getString(0));
            apellidos.setText(fila.getString(1));
            email.setText(fila.getString(2));
            carrera.setText(fila.getString(3));
            egreso.setText(fila.getString(4));
            ot.setText(fila.getString(5));
            fechat.setText(fila.getString(6));
            observaciones.setText(fila.getString(7));
        }else {
            Toast.makeText(this, "No existe el registro", Toast.LENGTH_SHORT).show();
        }bd.close();
    }



    public void baja (View v) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "alumnos", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String Nocontrol = nocontrol.getText().toString();
        int cant = bd.delete("alumnos", "nocontrol=" + Nocontrol, null);
        bd.close();

        nocontrol.setText("");
        nombre.setText("");
        apellidos.setText("");
        email.setText("");
        carrera.setText("");
        egreso.setText("");
        ot.setText("");
        fechat.setText("");
        observaciones.setText("");

        if (cant==1) {
            Toast.makeText(this, "Se elimino el registro", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "No existe el registro", Toast.LENGTH_SHORT).show();
        }
    }


    public void modificacion (View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "alumnos", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String Nocontrol = nocontrol.getText().toString();
        String Nombre = nombre.getText().toString();
        String Apellidos = apellidos.getText().toString();
        String Email = email.getText().toString();
        String Carrera = carrera.getText().toString();
        String Egreso = egreso.getText().toString();
        String Ot = ot.getText().toString();
        String Fechat = fechat.getText().toString();
        String Observaciones = observaciones.getText().toString();
        ContentValues registro= new ContentValues();

        registro.put("nocontrol", Nocontrol);
        registro.put("nombre", Nombre);
        registro.put("apellidos", Apellidos);
        registro.put("email", Email);
        registro.put("carrera", Carrera);
        registro.put("egreso", Egreso);
        registro.put("ot", Ot);
        registro.put("fechat", Fechat);
        registro.put("observaciones", Observaciones);


        int cant = bd.update("alumnos", registro, "nocontrol=" +  Nocontrol, null);
        bd.close();

        if (cant==1){
            Toast.makeText(this, "Se modifico el registro de la persona", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "No existe el registro de la persona", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpia (View v) {

        nocontrol.setText("");
        nombre.setText("");
        apellidos.setText("");
        email.setText("");
        carrera.setText("");
        egreso.setText("");
        ot.setText("");
        fechat.setText("");
        observaciones.setText("");
    }

    public void vistar(View v){
        Intent intent = new Intent(alumnos.this, VistaRegistro.class);
        startActivity(intent);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alumnos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

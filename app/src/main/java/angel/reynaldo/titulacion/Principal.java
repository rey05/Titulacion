package angel.reynaldo.titulacion;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Principal extends ActionBarActivity {

    //Declaramos los atributos que utilizaremos
    EditText Usuario, Password;
    Button Ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Enlazamos la parte grafica con el codigo

        Usuario = (EditText) findViewById(R.id.Usuario);
        Password = (EditText) findViewById(R.id.Password);
        Ingresar= (Button) findViewById(R.id.btnIngresar);
    }

    //Mediante un login se verifica el acceso a la aplicacion
    public void login (View v){

        if (Usuario.getText().toString().equals("rey") &&   Password.getText().toString().equals("1")){

            Intent intent = new Intent(Principal.this, menu.class);
            startActivity(intent);
        }
        else {

            Toast toast = Toast.makeText(this, "Su password o el usuario es incorrecto", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
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

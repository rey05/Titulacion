package angel.reynaldo.titulacion;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Angel on 18/05/2015.
 */
public class adaptador extends RecyclerView.Adapter<adaptador.titulacionViewHolder> {




    private List<modelo> items;

    public static class titulacionViewHolder extends RecyclerView.ViewHolder {

        public TextView No_control;
        public TextView Nombre;
        public TextView Apellidos;
        public TextView Email;
        public TextView Carrera;
        public TextView Egreso;
        public TextView Ot;
        public TextView Fechat;
        public TextView Observaciones;


        public titulacionViewHolder(View v) {
            super(v);
            No_control = (TextView) v.findViewById(R.id.ncon);
            Nombre = (TextView) v.findViewById(R.id.nom);
            Apellidos = (TextView) v.findViewById(R.id.ap);
            Email = (TextView) v.findViewById(R.id.em);
            Carrera = (TextView) v.findViewById(R.id.car);
            Egreso = (TextView) v.findViewById(R.id.eg);
            Ot = (TextView) v.findViewById(R.id.ot);
            Fechat = (TextView) v.findViewById(R.id.fect);
            Observaciones = (TextView) v.findViewById(R.id.obs);
        }
    }

    public adaptador(List<modelo> items) {
        this.items = items;
    }

    @Override
    public titulacionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.carta, viewGroup, false);
        return new titulacionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(titulacionViewHolder viewHolder, int i) {
        //el String.valuOf
        viewHolder.No_control.setText("No. Control: "+items.get(i).getNocontrol());
        viewHolder.Nombre.setText("Nombre: "+ items.get(i).getNombre());
        viewHolder.Apellidos.setText("Apellidos: "+items.get(i).getApellidos());
        viewHolder.Email.setText("Email: "+items.get(i).getEmail());
        viewHolder.Carrera.setText("Carrera: "+items.get(i).getCarrera());
        viewHolder.Egreso.setText("Egreso: "+items.get(i).getEgreso());
        viewHolder.Ot.setText("Opción de Titulación: "+items.get(i).getOt());
        viewHolder.Fechat.setText("Fecha de Titulación: "+items.get(i).getFechat());
        viewHolder.Observaciones.setText("Observaciones: "+items.get(i).getObservaciones());
    }

    @Override
    public int getItemCount() {
        return  items.size();
    }





}




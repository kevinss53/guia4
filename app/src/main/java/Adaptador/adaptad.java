package Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.guia4.R;

import java.util.List;

import Entidades.Contactos;


public class adaptad extends BaseAdapter {

    private List<Contactos> datasource;
    private Context cntx;
    private int IdLayoutPlantilla;

    public List<Contactos> GetData(){
        return this.datasource;
    }

    public adaptad(Context context, int IdPlantilla, List<Contactos> sources){
        //Inicializamos las variables
        this.cntx = context;
        this.IdLayoutPlantilla = IdPlantilla;
        this.datasource = sources;
    }

    @Override
    public int getCount() {
        return this.datasource.size();
    }

    @Override
    public Object getItem(int position) {
        return this.datasource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Validamos que no exista un formato
        if(convertView == null){
            //Creamos el Administrador de Layout
            LayoutInflater inflater = (LayoutInflater) this.cntx.getSystemService(this.cntx.LAYOUT_INFLATER_SERVICE);
            //Le damos vida al archivo xml ahora es un Layout
            convertView = inflater.inflate(this.IdLayoutPlantilla,null);

            //Buscamos los controles de nuestra plantilla
            TextView lblnombre = convertView.findViewById(R.id.txtnombre);
            TextView lblnumero = convertView.findViewById(R.id.txtnumero);
            TextView lblorganizacion = convertView.findViewById(R.id.txtorganizacion);

            //Obtenemos el dato a mostrar
            lblnombre.setText("Nombre" + this.datasource.get(position).getNombre());
            lblnumero.setText("Numero" +this.datasource.get(position).getNumero());
            lblorganizacion.setText( "Organizacion" + this.datasource.get(position).getOrganizacion() );
        }
        return convertView;
    }
}

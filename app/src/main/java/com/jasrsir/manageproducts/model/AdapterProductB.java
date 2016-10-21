package com.jasrsir.manageproducts.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jasrsir.manageproducts.R;

/**
 * Created by usuario on 21/10/16.
 */

public class AdapterProductB extends ArrayAdapter<Product> {

    private Context context;

    //Como es la activity quien le pasa el valor del
    public AdapterProductB(Context context) {
        super(context, R.layout.item_product, ((ProductApplication)context.getApplicationContext()).getListProduct());
        this.context = context;
    }

    /**
     * ESTA ES UNA FORMA INCORRECTA
     * @param position posición a insertar
     * @param convertView Es la vista a convertir
     * @param parent Es el padre del grupo de
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //region 2-B - Usar de otra forma el ConvertView
        View item = convertView;
        ImageView product_image;
        TextView mTxvName;
        TextView mTxvStock;
        TextView mTxvPrice;

        //Preguntamos si la vista es nula, si es nula ya lo inicializamos
        if (item == null) {
            //1. Creamos un objeto inflater que inicializamos al LayoutInflater del contexto
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //2. Inflar la vista, crear en memoria el objeto VIew   ue contiene los widgets del XML
            item = inflater.inflate(R.layout.item_product, null);
        }

        //3. Asignamos a las vbariables los widgets mediante el metodo findViewById
        product_image = (ImageView) item.findViewById(R.id.imvFoto);
        mTxvName = (TextView) item.findViewById(R.id.txvSeeName);
        mTxvStock = (TextView) item.findViewById(R.id.txvSeeStock);
        mTxvPrice = (TextView) item.findViewById(R.id.txvSeePrice);

        //4. Asignamos los datos del adapter a los widgets
        product_image.setImageResource(getItem(position).getmImage());
        mTxvName.setText(getItem(position).getmName());
        mTxvPrice.setText(getItem(position).getFormattedPrice());
        mTxvStock.setText(getItem(position).getFormattedStock());

        return item;
        //endregion


    }
}
package com.jasrsir.manageproducts.model;

import android.app.Application;

import com.jasrsir.manageproducts.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Class created to initialize a product's ArrayList
 * @author jasrsir
 */
public class ProductApplication extends Application{

    //Class variable
    private ArrayList<Product> mListaProductos = new ArrayList<Product>();


    @Override
    public void onCreate() {
        super.onCreate();
        saveProduct(new Product("Pericurol", "Curotodol.S.A.", "600mg", "Ibuprofeno", 14.25, 10, R.drawable.imagen1 ));
        saveProduct(new Product("AnalIn", "Pene.S.A.", "2g", "Supositorio", 6.96, 69, R.drawable.imagen2 ));
        saveProduct(new Product("Barridol", "Estomach", "345mg", "Omeprazol", 2.30, 58, R.drawable.imagen3 ));
        saveProduct(new Product("Ojolital", "Curotodol.S.A.", "600mg", "Ibuprofeno", 14.25, 0, R.drawable.imagen4 ));
        saveProduct(new Product("Mentolera", "Curotodol.S.A.", "600mg", "Ibuprofeno", 14.25, 22, R.drawable.imagen2 ));
        saveProduct(new Product("Barriobajera", "Matacanis", "5g", "Killninisfeno", 14.25, 74, R.drawable.imagen3 ));
        saveProduct(new Product("Relajaraja", "Bayer", "600mg", "Morfina", 14.25, 10, R.drawable.imagen4 ));
        saveProduct(new Product("Pericurol", "Curotodol.S.A.", "600mg", "Ibuprofeno", 14.25, 0, R.drawable.imagen1 ));
        saveProduct(new Product("Pericurol", "Curotodol.S.A.", "600mg", "Ibuprofeno", 14.25, 10, R.drawable.imagen2));

    }

    /**
     * Method to add a product in mListaProductos
     * @param producto product to save
     */
    private void saveProduct(Product producto) {
        mListaProductos.add(producto);
    }


    /**
     * Get method to obtain the product's arraylist
     * @return List products
     */
    public List<Product> getListProduct() {
        return mListaProductos;
    }
}

package com.jasrsir.manageproducts;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ArrayAdapter;

import com.jasrsir.manageproducts.model.AdapterProductA;
import com.jasrsir.manageproducts.model.AdapterProductB;
import com.jasrsir.manageproducts.model.AdapterProductC;
import com.jasrsir.manageproducts.model.Product;

public class ListProducts_Activity extends ListActivity {

    //region variables
    private ArrayAdapter<Product> mAdapter;
    private FloatingActionButton mFloatBtnAdd;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_products);
        //Como ya tiene una lista interna por la herencia, nos obliga a tener un ID en android
        //debemos vincular la list y nuestra activity     getListView();
        mFloatBtnAdd = (FloatingActionButton) findViewById(R.id.fabAdd);
        mFloatBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListProducts_Activity.this, AddProduct_Activity.class);
                startActivityForResult(intent,RESULT_OK);
            }
        });
        //TODO CASE 1: ADAPTER NOT PERSONALIZED
        //mAdapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1,((ProductApplication) getApplication()).getListProduct());

        mAdapter = new AdapterProductC(this);
        getListView().setAdapter(mAdapter);
    }
}

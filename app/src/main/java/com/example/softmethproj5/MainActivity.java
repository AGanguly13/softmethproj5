package com.example.softmethproj5;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

    public int [] itemImages = {R.drawable.chicagobbq, R.drawable.chicagodeluxe, R.drawable.chicagomeatzza, R.drawable.chicagobuildyourown,
            R.drawable.nypizza, R.drawable.nydeluxe, R.drawable.nymeatzza, R.drawable.nypizza};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        RecyclerView pizzaRCView = findViewById(R.id.rcViewMain);
        fillRecycleViewArray();
        PizzaAdapter adapter = new PizzaAdapter(this, pizzas);
        pizzaRCView.setAdapter(adapter);
        pizzaRCView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void fillRecycleViewArray() {
        pizzas.add(new ChicagoPizza().createBBQChicken(Size.valueOf(getResources().getString(R.string.largeSize))));
        pizzas.add(new ChicagoPizza().createDeluxe(Size.valueOf(getResources().getString(R.string.largeSize))));
        pizzas.add(new ChicagoPizza().createMeatzza(Size.valueOf(getResources().getString(R.string.largeSize))));
        pizzas.add(new ChicagoPizza().createBuildYourOwn(null, Size.valueOf(getResources().getString(R.string.largeSize))));
        pizzas.add(new NYPizza().createBBQChicken(Size.valueOf(getResources().getString(R.string.largeSize))));
        pizzas.add(new NYPizza().createDeluxe(Size.valueOf(getResources().getString(R.string.largeSize))));
        pizzas.add(new NYPizza().createMeatzza(Size.valueOf(getResources().getString(R.string.largeSize))));
        pizzas.add(new NYPizza().createBuildYourOwn(null, Size.valueOf(getResources().getString(R.string.largeSize))));
    }

}
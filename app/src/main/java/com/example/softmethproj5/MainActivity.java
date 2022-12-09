package com.example.softmethproj5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

/**
 * This class represents the functionality of the Main Activity screen of the application. This screen contains a RecyclerView of all
 * possible pizza options, and two buttons to navigate to the Current Orders activity and the Store Orders activity.
 *
 * @author Adwait Ganguly, Kennan Guan
 */
public class MainActivity extends AppCompatActivity {

    private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

    public static ArrayList<Pizza> pizzasInOrder = new ArrayList<>();

    public static ArrayList<Order> ordersList = new ArrayList<>();

    /**
     * This method initializes the Main Activity screen that contains the Recycler View of all
     * the pizzas options the user can choose from.
     * @param savedInstanceState contains the data associated with the activity when it is exited.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        RecyclerView pizzaRCView = findViewById(R.id.rcViewMain);
        pizzaRCView.setLayoutManager(new LinearLayoutManager(this));
        pizzaRCView.addItemDecoration(new DividerItemDecoration(pizzaRCView.getContext(), DividerItemDecoration.VERTICAL));
        fillRecycleViewArray();
        PizzaAdapter adapter = new PizzaAdapter(this, pizzas);
        pizzaRCView.setAdapter(adapter);

        setButtonListener();
    }

    /**
     * This is a helper method that fills the array with pizza objects representing each of the eight different types of pizza.
     */
    private void fillRecycleViewArray() {
        pizzas.add(new ChicagoPizza().createBBQChicken(Size.valueOf(getResources().getString(R.string.largeSize))));
        pizzas.add(new ChicagoPizza().createDeluxe(Size.valueOf(getResources().getString(R.string.largeSize))));
        pizzas.add(new ChicagoPizza().createMeatzza(Size.valueOf(getResources().getString(R.string.largeSize))));
        pizzas.add(new ChicagoPizza().createBuildYourOwn(new ArrayList<>(), Size.valueOf(getResources().getString(R.string.largeSize))));
        pizzas.add(new NYPizza().createBBQChicken(Size.valueOf(getResources().getString(R.string.largeSize))));
        pizzas.add(new NYPizza().createDeluxe(Size.valueOf(getResources().getString(R.string.largeSize))));
        pizzas.add(new NYPizza().createMeatzza(Size.valueOf(getResources().getString(R.string.largeSize))));
        pizzas.add(new NYPizza().createBuildYourOwn(new ArrayList<>(), Size.valueOf(getResources().getString(R.string.largeSize))));
    }

    /**
     * This method sets the listener for the Current Order button. This method contains the lambda expressions that
     * are onClick methods for the Current Order and Store Order buttons.
     */
    public void setButtonListener() {

        Button currentOrderButton = (Button) findViewById(R.id.currentOrderButton);
        currentOrderButton.setOnClickListener(new View.OnClickListener() {
            /**
             * This method represents the onClick action when the user presses the Current Order button. This method
             * opens the Current Order Activity.
             * @param view is the Current Order button that was clicked to initialize this method.
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CurrentOrderActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        Button storeOrderButton = (Button) findViewById(R.id.storeOrderButton);
        storeOrderButton.setOnClickListener(new View.OnClickListener() {
            /**
             * This method represents the onClick action when the user presses the Store Order button. This method
             * opens the Store Order Activity.
             * @param view is the Store Order button that was clicked to initialize this method.
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), StoreOrderActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }

}
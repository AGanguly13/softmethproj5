package com.example.softmethproj5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.PizzaHolder> {

    private Context context;

    private ArrayList<Pizza> pizzas;


    public PizzaAdapter(Context context, ArrayList<Pizza> pizzas) {
        this.context = context;
        this.pizzas = pizzas;
    }

    @NonNull
    @Override
    public PizzaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.pizzaRowView, parent, false);

        return new PizzaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NotNull PizzaHolder holder, int position) {

    }

    @Override
    public int getPizzaCount() {
        return pizzas.size();
    }
}

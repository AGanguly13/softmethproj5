package com.example.softmethproj5;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
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

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    @NonNull
    @Override
    public PizzaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.pizza_row_view, parent, false);

        return new PizzaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NotNull PizzaHolder holder, int position) {
        holder.pizza_Name.setText(pizzas.get(position).toString());
        holder.pizza_Image.setImageResource(R.drawable.pizza);
        holder.pizza = pizzas.get(position);
    }

    @Override
    public int getItemCount() {
        return pizzas.size();
    }

    public static class PizzaHolder extends RecyclerView.ViewHolder {
        private TextView pizza_Name;

        private ImageView pizza_Image;

        private ConstraintLayout parentlayout;

        private Pizza pizza;

        public PizzaHolder(@NonNull View pizzaView) {
            super(pizzaView);
            pizza_Name = pizzaView.findViewById(R.id.pizzaName);
            pizza_Image = pizzaView.findViewById(R.id.pizzaImage);
            parentlayout = pizzaView.findViewById(R.id.pizzaRowLayout);

            parentlayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(pizzaView.getContext(), PizzaSelectedActivity.class);
                    intent.putExtra("PIZZA", pizza);
                    pizzaView.getContext().startActivity(intent);
                }
            });
        }
    }
}

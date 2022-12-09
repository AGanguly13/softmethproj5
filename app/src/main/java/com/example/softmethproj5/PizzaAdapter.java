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

/**
 * This class is the Adapter class for the RecyclerView in the Main Activity. This class sets the data in full for
 * the RecyclerView.
 *
 * @author Adwait Ganguly, Kennan Guan
 */
public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.PizzaHolder> {

    private Context context;

    private ArrayList<Pizza> pizzas;

    /**
     * This is the parameterized constructor for a PizzaAdapter object. This method takes in a Context and ArrayList of pizzas.
     * @param context is the context object representing the current state of the application.
     * @param pizzas is the ArrayList containing the eight possible types of pizzas.
     */
    public PizzaAdapter(Context context, ArrayList<Pizza> pizzas) {
        this.context = context;
        this.pizzas = pizzas;
    }

    /**
     * Getter method for the pizzas instance variable.
     * @return the pizzas instance variable.
     */
    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    /**
     * This method will inflate each item of the RecyclerView.
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return the new view, in this case the RecyclerView with the correct formatting.
     */
    @NonNull
    @Override
    public PizzaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.pizza_row_view, parent, false);

        return new PizzaHolder(view);
    }

    /**
     * This method binds the data with the actual components of the RecyclerView UI.
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NotNull PizzaHolder holder, int position) {
        holder.pizza_Name.setText(pizzas.get(position).toString());
        holder.pizza_Image.setImageResource(R.drawable.pizza);
        holder.pizza = pizzas.get(position);
    }

    /**
     * This method returns the size of the pizzas ArrayList instance variable.
     * @return the size/length of the pizzas instance variable.
     */
    @Override
    public int getItemCount() {
        return pizzas.size();
    }

    /**
     * This is an inner class that represents the Holder for each item of the RecyclerView. This inner class
     * contains a constructor for the PizzaHolder as well as a listener for any click on a RecyclerView item.
     *
     * @author Adwait Ganguly, Kennan Guan
     */
    public static class PizzaHolder extends RecyclerView.ViewHolder {
        private TextView pizza_Name;

        private ImageView pizza_Image;

        private ConstraintLayout parentlayout;

        private Pizza pizza;

        /**
         * This is the parameterized constructor for the PizzaHolder that will hold an item of the RecyclerView along with
         * its data.
         * @param pizzaView is the item of the RecyclerView that contains a specific pizza object.
         */
        public PizzaHolder(@NonNull View pizzaView) {
            super(pizzaView);
            pizza_Name = pizzaView.findViewById(R.id.pizzaName);
            pizza_Image = pizzaView.findViewById(R.id.pizzaImage);
            parentlayout = pizzaView.findViewById(R.id.pizzaRowLayout);

            parentlayout.setOnClickListener(new View.OnClickListener() {
                /**
                 * This method represents the onClick action when the user presses the on a RecyclerView item.
                 * @param view is the RecyclerView item that is pressed and invokes this onClick method.
                 */
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

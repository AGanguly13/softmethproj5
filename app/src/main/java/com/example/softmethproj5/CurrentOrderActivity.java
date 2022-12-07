package com.example.softmethproj5;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CurrentOrderActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private ArrayList<String> currentPizzas;
    private Order currentOrder;
    private double subPrice;
    private double orderTotal;
    private double salesTax;
    private ArrayList<Order> allOrders;

    private ArrayList<Pizza> allPizzas;
    private EditText orderNumberDisplay;
    private ListView orderDisplay;
    private EditText subtotalDisplay;
    private EditText salesTaxDisplay;
    private EditText orderTotalDisplay;
    private Button remove;
    private Button clear;
    private Button placeOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currentorder);

        remove = findViewById(R.id.removePizza);
        clear = findViewById(R.id.clearOrder);
        placeOrder = findViewById(R.id.placeOrder);
        orderDisplay = findViewById(R.id.pizzaOrders);
        subtotalDisplay = findViewById(R.id.subtotal);
        salesTaxDisplay = findViewById(R.id.salesTax);
        orderTotalDisplay = findViewById(R.id.orderTotal);
        orderNumberDisplay = findViewById(R.id.orderNum);

        //need to set allOrders to variable in main
        //allOrders = MainActivity.
    }

    public void setCurrentOrder(ArrayList<Pizza> pizzas) {
        allPizzas = pizzas;
        currentOrder = new Order();
        for (Pizza piz: pizzas) {
            currentOrder.getCurrentOrder().add(piz);
        }
        orderNumberDisplay.setText(String.valueOf(this.currentOrder.getSerialNumber()));
        subPrice = 0;
        for (Pizza p: currentOrder.getCurrentOrder()) {
            subPrice += p.price();
            currentPizzas.add(p.toString());
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, currentPizzas);
        orderDisplay.setAdapter(adapter);
        orderTotal = subPrice * 1.06625;
        salesTax = subPrice * 0.06625;
        salesTax = Math.round(salesTax * 100) / 100.0;
        orderTotal = Math.round(orderTotal * 100) / 100.0;

    }

    /**
     * This method removes a Pizza from the current order when the user selects a pizza from the order ListView and then
     * selects the Remove button.
     * @param view the view where the action originated from.
     */
    public void removePizza(View view) {
        if (orderDisplay.getCheckedItemCount() != 0) {
            int index = orderDisplay.getCheckedItemPosition();
            subPrice -= this.currentOrder.getCurrentOrder().get(index).price();
            salesTax = subPrice * 0.06625;
            orderTotal = subPrice * 1.06625;
            salesTax = Math.round(salesTax * 100) / 100.0;
            orderTotal = Math.round(orderTotal * 100) / 100.0;
            subtotalDisplay.setText(String.format("%.2f", subPrice));
            orderTotalDisplay.setText(String.format("%.2f", orderTotal));
            salesTaxDisplay.setText(String.format("%.2f", salesTax));

            currentPizzas.remove(index);
            currentOrder.getCurrentOrder().remove(index);
            allPizzas.remove(index);
            adapter.notifyDataSetChanged();
        }
    }

    /**
     * This method clears the Order of pizzas from the current order when the user clicks the Clear
     * Order button. The ListView is cleared and the order price is back to zero.
     * @param view the view where the action originated from.
     */
    public void clear(View view) {
        currentOrder.clearOrder();
        allPizzas.clear();
        orderTotalDisplay.getText().clear();
        subtotalDisplay.getText().clear();
        salesTaxDisplay.getText().clear();
        currentPizzas.clear();
        adapter.notifyDataSetChanged();
    }

    /**
     * This method places the current order of pizzas. This method is invoked when the user is satisfied with their order
     * and selects the Place Order button on the CurrentOrderView.
     * @param view the view where the action originated from.
     */
    public void placeOrder(View view) {
        if (this.currentOrder.getCurrentOrder().isEmpty()) {
            return;
        }
        allOrders.add(this.currentOrder); //sent in list
        this.currentOrder.updateOrderCount();
        orderNumberDisplay.getText().clear();
        orderTotalDisplay.getText().clear();
        subtotalDisplay.getText().clear();
        salesTaxDisplay.getText().clear();
        currentPizzas.clear();
        allPizzas.clear();
        adapter.notifyDataSetChanged();
    }
}

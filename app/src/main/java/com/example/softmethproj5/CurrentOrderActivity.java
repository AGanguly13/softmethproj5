package com.example.softmethproj5;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
/**
 * This activity class defines the Current Order page. It sets the view displayed to the user, defines the elements of the page
 * and defines the functionality of the page.
 *
 * @author Kennan Guan and Adwait Ganguly
 */
public class CurrentOrderActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayAdapter<String> adapter;
    private ArrayList<String> currentPizzas = new ArrayList<>();
    private Order currentOrder;
    private double subPrice;
    private double orderTotal;
    private double salesTax;
    private ArrayList<Order> allOrders;
    private ArrayList<Pizza> allPizzas;
    private TextView orderNumberDisplay;
    private ListView orderDisplay;
    private TextView subtotalDisplay;
    private TextView salesTaxDisplay;
    private TextView orderTotalDisplay;
    private Button clear;
    private Button placeOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_order);

        clear = findViewById(R.id.clearOrder);
        placeOrder = findViewById(R.id.placeOrder);
        orderDisplay = findViewById(R.id.pizzaOrders);
        subtotalDisplay = findViewById(R.id.subtotal);
        salesTaxDisplay = findViewById(R.id.salesTax);
        orderTotalDisplay = findViewById(R.id.orderTotal);
        orderNumberDisplay = findViewById(R.id.orderNum);

        allOrders = MainActivity.ordersList;
        setCurrentOrder();
    }

    public void setCurrentOrder() {
        ArrayList<Pizza> pizzas = MainActivity.pizzasInOrder;
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
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, currentPizzas);
        orderDisplay.setOnItemClickListener(this);
        orderDisplay.setAdapter(adapter);
        orderTotal = subPrice * 1.06625;
        salesTax = subPrice * 0.06625;
        salesTax = Math.round(salesTax * 100) / 100.0;
        orderTotal = Math.round(orderTotal * 100) / 100.0;

        subtotalDisplay.setText("$" + String.format("%.2f", subPrice));
        orderTotalDisplay.setText("$" + String.format("%.2f", orderTotal));
        salesTaxDisplay.setText("$" + String.format("%.2f", salesTax));



    }

    /**
     * This method removes a Pizza from the current order when the user selects a pizza from the order ListView and then
     * selects the Remove button.
     */
    public void removePizza(int position) {;
        subPrice -= this.currentOrder.getCurrentOrder().get(position).price();
        salesTax = subPrice * 0.06625;
        orderTotal = subPrice * 1.06625;
        salesTax = Math.round(salesTax * 100) / 100.0;
        orderTotal = Math.round(orderTotal * 100) / 100.0;
        subtotalDisplay.setText("$" + String.format("%.2f", subPrice));
        orderTotalDisplay.setText("$" + String.format("%.2f", orderTotal));
        salesTaxDisplay.setText("$" + String.format("%.2f", salesTax));
        currentPizzas.remove(position);
        currentOrder.getCurrentOrder().remove(position);
        allPizzas.remove(position);
        adapter.notifyDataSetChanged();
    }

    /**
     * This method clears the order of pizzas from the current order when the user clicks the Clear
     * Order button. The ListView is cleared and the order price is back to zero.
     * @param view the view where the action originated from.
     */
    public void clear(View view) {
        if (adapter.getCount() != 0) {
            currentOrder.clearOrder();
            allPizzas.clear();
            currentPizzas.clear();
            this.currentOrder.updateOrderCount();
            setCurrentOrder();
            adapter.notifyDataSetChanged();
        }
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
        allOrders.add(this.currentOrder);
        this.currentOrder.updateOrderCount();
        currentPizzas.clear();
        allPizzas.clear();
        setCurrentOrder();
        adapter.notifyDataSetChanged();
    }

    /**
     * Called when the user clicks on a pizza in their order. Prompts the user if they want to delete the selected pizza.
     * "Yes" will remove the pizza and "No" will do nothing.
     * @param adapterView the adapterview where the clicked happened
     * @param view the view where the item was clicked
     * @param i the integer location of the clicked item
     * @param l the row id where the item was clicked
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Delete Pizza?");
        alert.setMessage(adapterView.getAdapter().getItem(i).toString());
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                removePizza(i);
            }
        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }
}

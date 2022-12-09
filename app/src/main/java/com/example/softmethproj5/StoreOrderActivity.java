package com.example.softmethproj5;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
/**
 * Activity class for the Store Order functionality. It sets the displayed view for the user, initializes the elements, and defines
 * the functionality for the Store Order page.
 *
 * @author Kennan Guan and Adwait Ganguly
 */
public class StoreOrderActivity extends AppCompatActivity{

    private ArrayAdapter<String> adapterOrders;

    private ArrayAdapter<Integer> adapterNumbers;

    private ArrayList<Integer> orderSerialNumbers = new ArrayList<>();

    private ArrayList<String> currentOrders = new ArrayList<>();

    private static StoreOrder orders;

    private ListView orderDisplay;

    private Spinner orderNumList;

    private TextView orderTotal;

    /**
     * Called when this activity is opened first. Sets the correct layout to the app's view and initializes all elements
     * seen on the page.
     * @param savedInstanceState contains the data associated with the activity when it is exited.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_orders);

        orderDisplay = findViewById(R.id.storeOrdersList);
        orderNumList = findViewById(R.id.selectOrder);
        orderTotal = findViewById(R.id.storeOrderTotal);
        currentOrders.add("Select");
        orderSerialNumbers.add(0);

        adapterOrders = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, currentOrders);
        orderDisplay.setAdapter(adapterOrders);

        adapterNumbers = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, orderSerialNumbers);
        orderNumList.setAdapter(adapterNumbers);

        setOrdersList(MainActivity.ordersList);
        orderNumList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                displayCurrentOrder();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });
    }

    /**
     * This method displays an order based on which serial number is selected from the Spinner by the user. This method is invoked when a user selects a serial number
     * from the Spinner
     */
    public void displayCurrentOrder() {
        currentOrders.clear();
        double orderPrice = 0;

        for (int i = 0; i < orders.getOrders().size(); i++) {
            if (orders.getOrders().get(i).getSerialNumber() == (Integer)orderNumList.getSelectedItem()) {
                for (Pizza p : orders.getOrders().get(i).getCurrentOrder()) {
                    currentOrders.add(p.toString());
                    orderPrice += p.price();
                }
            }
        }
        orderPrice *= 1.06625;
        orderPrice = Math.round(orderPrice * 100) / 100.0;
        orderTotal.setText("$" + String.format("%.2f", orderPrice));
        adapterOrders.notifyDataSetChanged();
        adapterNumbers.notifyDataSetChanged();
    }

    /**
     * This method cancels the current order selected by the user and displayed on the screen. This method is invoked when the user selects an order to display and then
     * clicks the Cancel Order button.
     * @param view the view in which the button was clicked.
     */
    public void cancelOrder(View view) {
        int orderID = (Integer) orderNumList.getSelectedItem();
        for (int i = 0; i < orderSerialNumbers.size(); i++){
            if (orderSerialNumbers.get(i) == orderID) {
                if (i == 0){
                    return;
                }
                orders.getOrders().remove(i-1);
                orderNumList.setSelection(i-1);
                orderSerialNumbers.remove(i);
            }
        }
        orderTotal.setText("");
        currentOrders.clear();
        setOrdersList(orders.getOrders());
        displayCurrentOrder();

    }


    /**
     * This method is invoked when the StoreOrdersView is loaded. This method sets the ArrayList of Orders.
     * @param list is an ArrayList of Order objects passed from the CurrentOrderController.
     */
    public void setOrdersList(ArrayList<Order> list) {
        orders = new StoreOrder(list);
        updateOrderList();
    }


    /**
     * This is a helper method to update the list of serial numbers used in the Spinner.
     */
    public void updateOrderList() {
        for (Order order: this.orders.getOrders()) {
            if (orderSerialNumbers.contains(order.getSerialNumber()) == false) {
                orderSerialNumbers.add(order.getSerialNumber());
            }
        }
        adapterNumbers.notifyDataSetChanged();
        adapterOrders.notifyDataSetChanged();
    }

}


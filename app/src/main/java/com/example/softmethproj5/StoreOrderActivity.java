package com.example.softmethproj5;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class StoreOrderActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapterOrders;

    private ArrayAdapter<Integer> adapterNumbers;

    private ArrayList<Integer> orderSerialNumbers;

    private ArrayList<String> currentOrders;

    private static StoreOrder orders;

    private Button cancelOrder;

    private ListView orderDisplay;

    private Spinner orderNumList;

    private EditText orderTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storeorders);

        cancelOrder = findViewById(R.id.cancelOrder);
        orderDisplay = findViewById(R.id.storeOrdersList);
        orderNumList = findViewById(R.id.selectOrder);
        orderTotal = findViewById(R.id.storeOrderTotal);

        adapterOrders = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, currentOrders);
        orderDisplay.setAdapter(adapterOrders);

        adapterNumbers = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, orderSerialNumbers);
        orderNumList.setAdapter(adapterNumbers);
    }

    /**
     * This method displays an order based on which serial number is selected from the Combo Box by the user. This method is invoked when a user selects a serial number
     * from the Combo Box.
     */
    public void displayCurrentOrder() {
        double orderPrice = 0;
        if (orderNumList.getSelectedItem() == null) {
            return;
        }

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
        adapterOrders.notifyDataSetChanged();
        adapterNumbers.notifyDataSetChanged();
        orderTotal.setText(String.format("%.2f", orderPrice));
    }

    /**
     * This method cancels the current order selected by the user and displayed on the screen. This method is invoked when the user selects an order to display and then
     * clicks the Cancel Order button.
     */
    public void cancelOrder(View view) {
        if (orderNumList.getSelectedItem() == null) {
            return;
        }

        for (int x = 0; x < this.orders.getOrders().size(); x++) {
            if ((Integer)orderNumList.getSelectedItem() == this.orders.getOrders().get(x).getSerialNumber()) {
                for (int i = 0; i < orderSerialNumbers.size(); i++) {
                    if (orderSerialNumbers.get(i) == (Integer)orderNumList.getSelectedItem()) {
                        orderSerialNumbers.remove(i);
                    }
                }
                orderTotal.setText("");
                orders.getOrders().remove(x);
                setOrdersList(orders.getOrders());
                return;
            }
        }
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
     * This is a helper method to update the list of serial numbers used in the ComboBox.
     */
    public void updateOrderList() {
        for (Order order: this.orders.getOrders()) {
            if (orderSerialNumbers.contains(order.getSerialNumber()) == false) {
                orderSerialNumbers.add(order.getSerialNumber());
            }
        }
        adapterNumbers.notifyDataSetChanged();
    }
}


package com.example.softmethproj5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class PizzaSelectedActivity extends AppCompatActivity {

    private TextView pizzaName;

    private ImageView pizzaImage;

    private String pizzaInfo;

    private TextView pizzaPrice = findViewById(R.id.pizzaPrice);

    private RadioButton small = findViewById(R.id.smallButton);

    private RadioButton medium = findViewById(R.id.mediumButton);

    private RadioButton large = findViewById(R.id.largeButton);

    private RadioGroup radioGroup;
    private Pizza newPizza;

    private CheckBox sausage = findViewById(R.id.Sausage);

    private CheckBox pepperoni = findViewById(R.id.Pepperoni);

    private CheckBox greenpepper = findViewById(R.id.GreenPepper);

    private CheckBox onion = findViewById(R.id.Onion);

    private CheckBox mushroom = findViewById(R.id.Mushroom);

    private CheckBox bbqchicken = findViewById(R.id.BBQChicken);

    private CheckBox provolone = findViewById(R.id.Provolone);

    private CheckBox cheddar = findViewById(R.id.Cheddar);

    private CheckBox beef = findViewById(R.id.Beef);

    private CheckBox ham = findViewById(R.id.Ham);

    private CheckBox pineapple = findViewById(R.id.Pineapple);

    private CheckBox olive = findViewById(R.id.Olive);

    private CheckBox buffalosauce = findViewById(R.id.BuffaloSauce);

    private ArrayList<Topping> pizzaToppings = new ArrayList<Topping>();

    private static final int NOTINSTRING = -1;
    private static final int MAXTOPPINGS = 8;
    private static final double TOPPINGPRICE = 1.59;
    private static final int[] checkboxes = {R.id.Sausage, R.id.Pepperoni, R.id.GreenPepper, R.id.Onion, R.id.Mushroom, R.id.BBQChicken, R.id.Provolone, R.id.Cheddar, R.id.Beef, R.id.Ham, R.id.Pineapple,
                                R.id.Olive, R.id.BuffaloSauce};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza_selection);
        Intent intent = getIntent();
        //String pizzaInfo = intent.getStringExtra("PIZZA");
        newPizza = (Pizza) intent.getSerializableExtra("PIZZA");

        pizzaName = (TextView) findViewById(R.id.pizza_name);
        setPizzaName(newPizza);
        setToppings(newPizza);
        setPrice(newPizza);

        addListenerOnRadioButton(newPizza);
    }

    public void setPizzaName(Pizza pizzaInformation) {
        if (pizzaInformation.toString().indexOf("Chicago Style") != NOTINSTRING) {
            if (pizzaInformation.toString().indexOf("Deluxe") != NOTINSTRING) {
                pizzaName.setText(R.string.chicago_deluxe);
                pizzaImage.setImageResource(R.drawable.chicagodeluxe);
            }
            else if (pizzaInformation.toString().indexOf("Meatzza") != NOTINSTRING) {
                pizzaName.setText(R.string.chicago_meatzza);
                pizzaImage.setImageResource(R.drawable.chicagomeatzza);
            }
            else if (pizzaInformation.toString().indexOf("BBQChicken") != NOTINSTRING) {
                pizzaName.setText(R.string.chicago_bbq);
                pizzaImage.setImageResource(R.drawable.chicagobbq);
            }
            else if (pizzaInformation.toString().indexOf("Build your own") != NOTINSTRING) {
                pizzaName.setText(R.string.chicago_byo);
                pizzaImage.setImageResource(R.drawable.chicagopizza);
            }
        }
        else {
            if (pizzaInformation.toString().indexOf("Deluxe") != NOTINSTRING) {
                pizzaName.setText(R.string.ny_deluxe);
                pizzaImage.setImageResource(R.drawable.nydeluxe);
            }
            else if (pizzaInformation.toString().indexOf("Meatzza") != NOTINSTRING) {
                pizzaName.setText(R.string.ny_meatzza);
                pizzaImage.setImageResource(R.drawable.nymeatzza);
            }
            else if (pizzaInformation.toString().indexOf("BBQChicken") != NOTINSTRING) {
                pizzaName.setText(R.string.ny_bbq);
                pizzaImage.setImageResource(R.drawable.nypizza);
            }
            else if (pizzaInformation.toString().indexOf("Build your own") != NOTINSTRING) {
                pizzaName.setText(R.string.ny_byo);
                pizzaImage.setImageResource(R.drawable.nypizza);
            }
        }
    }

    public void setToppings(Pizza pizzaInformation) {
        if (pizzaInformation.toString().indexOf("Build your own") != NOTINSTRING) {
            return;
        }
        enableCheckBoxes();
        for (Topping topping: pizzaInformation.getToppings()) {
            if (topping.toString().equalsIgnoreCase("SAUSAGE")) {
                sausage.setChecked(true);
            } else if (topping.toString().equalsIgnoreCase("PEPPERONI")) {
                pepperoni.setChecked(true);
            } else if (topping.toString().equalsIgnoreCase("GREENPEPPER")) {
                greenpepper.setChecked(true);
            } else if (topping.toString().equalsIgnoreCase("ONION")) {
                onion.setChecked(true);
            } else if (topping.toString().equalsIgnoreCase("MUSHROOM")) {
                mushroom.setChecked(true);
            } else if (topping.toString().equalsIgnoreCase("BBQCHICKEN")) {
                bbqchicken.setChecked(true);
            } else if (topping.toString().equalsIgnoreCase("PROVOLONE")) {
                provolone.setChecked(true);
            } else if (topping.toString().equalsIgnoreCase("CHEDDAR")) {
                cheddar.setChecked(true);
            } else if (topping.toString().equalsIgnoreCase("BEEF")) {
                beef.setChecked(true);
            } else if (topping.toString().equalsIgnoreCase("HAM")) {
                ham.setChecked(true);
            } else if (topping.toString().equalsIgnoreCase("PINEAPPLE")) {
                pineapple.setChecked(true);
            } else if (topping.toString().equalsIgnoreCase("OLIVE")) {
                olive.setChecked(true);
            } else if (topping.toString().equalsIgnoreCase("BUFFALOSAUCE")) {
                buffalosauce.setChecked(true);
            }
        }
        disableCheckboxes();
    }

    public void disableCheckboxes() {
        for (int x = 0; x < checkboxes.length; x++) {
            CheckBox checkBox = (CheckBox) findViewById(checkboxes[x]);
            checkBox.setEnabled(false);
        }
    }

    public void enableCheckBoxes() {
        for (int x = 0; x < checkboxes.length; x++) {
            CheckBox checkBox = (CheckBox) findViewById(checkboxes[x]);
            checkBox.setEnabled(true);
        }
    }

    public void setPrice(Pizza pizza) {
        pizzaPrice.setText("");
        if (pizza.toString().indexOf("Build") != NOTINSTRING) {
            pizzaPrice.setText(String.format("%.2f",pizza.price() + pizza.getToppings().size() * TOPPINGPRICE));
        }
        else {
            pizzaPrice.setText(String.format("%.2f", pizza.price()));
        }
    }

    public void addListenerOnRadioButton (Pizza pizza) {
        radioGroup = findViewById(R.id.sizeGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checked) {
                if (small.isChecked()) {
                    pizza.setSize(Size.SMALL);
                }
                else if (medium.isChecked()) {
                    pizza.setSize(Size.MEDIUM);
                }
                else if (large.isChecked()) {
                    pizza.setSize(Size.LARGE);
                }
                setPrice(pizza);
            }
        });
    }

    public void onCheckBoxClicked(View view) {
        boolean isChecked = ((CheckBox) view).isChecked();

        if (isChecked) {
            newPizza.getToppings().add(Topping.valueOf(((CheckBox) view).getText().toString().toUpperCase()));
            setPrice(newPizza);
        }
        else {
            newPizza.getToppings().remove(Topping.valueOf(((CheckBox) view).getText().toString().toUpperCase()));
            setPrice(newPizza);
        }

    }

    public void addPizza(View view) {
        int counter = 0;
        for (int x = 0; x < checkboxes.length; x++) {
            CheckBox cBox = (CheckBox) findViewById(checkboxes[x]);
            if (cBox.isChecked()) {
                counter++;
            }
        }
        if (counter > MAXTOPPINGS) {
            Toast.makeText(this, "You can only select up to 8 toppings!", Toast.LENGTH_SHORT).show();
        }

        else {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            MainActivity.pizzasInOrder.add(newPizza);
            view.getContext().startActivity(intent);
            finish();
        }
    }

}

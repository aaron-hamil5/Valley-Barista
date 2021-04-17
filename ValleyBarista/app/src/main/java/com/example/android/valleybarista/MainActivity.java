package com.example.android.valleybarista;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice(quantity, 1);
        CheckBox whippedCreamCheckBox = findViewById(R.id.whippedCream);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        if (hasWhippedCream) {
            price += (quantity);
        }

        EditText NameBox = findViewById(R.id.NameOfUser);
        String UsersName = NameBox.getText().toString();

        EditText NameBox2 = findViewById(R.id.Location);
        String UsersLocation = NameBox2.getText().toString();

        /**
         Espresso
         */
        CheckBox espresso_checkbox = findViewById(R.id.espresso);
        boolean hasEspresso = espresso_checkbox.isChecked();


        /**
         Double Espresso
         */
        CheckBox douEspresso_checkbox = findViewById(R.id.douEspresso);
        boolean hasdouEspresso = douEspresso_checkbox.isChecked();


        /**
         Macchiato
         */
        CheckBox macchaiato_checkbox = findViewById(R.id.macchaiato);
        boolean hasMacchaiato = macchaiato_checkbox.isChecked();


        /**
         Cappuccino
         */
        CheckBox Cappuccino_checkbox = findViewById(R.id.Cappuccino);
        boolean hasCappuccino = Cappuccino_checkbox.isChecked();
        if (hasCappuccino) {
            price += (quantity);
        }

        /**
         Black Coffee Americano
         */
        CheckBox Americano_checkbox = findViewById(R.id.americano);
        boolean hasAmericano = Americano_checkbox.isChecked();


        /**
         Caffe Latte
         */
        CheckBox Latte_checkbox = findViewById(R.id.latte);
        boolean hasLatte = Latte_checkbox.isChecked();


        /**
         Mocha
         */
        CheckBox Mocha_checkbox = findViewById(R.id.mocha);
        boolean hasMocha = Mocha_checkbox.isChecked();


        /**
         Hot Chocolate
         */
        CheckBox Chocolate_checkbox = findViewById(R.id.hotChocolate);
        boolean hasChocolate = Chocolate_checkbox.isChecked();


        /**
         Flat White
         */
        CheckBox White_checkbox = findViewById(R.id.flatWhite);
        boolean hasWhite = White_checkbox.isChecked();


        /**
         Has cup?
         */
        CheckBox cup_checkbox = findViewById(R.id.cup);
        boolean hascup = cup_checkbox.isChecked();
        if (hascup) {
            quantity += .5;
        }

        /**
         milk?
         */
        CheckBox milk_checkbox = findViewById(R.id.milk);
        boolean hasmilk = milk_checkbox.isChecked();


        /**
         sugar?
         */
        CheckBox sugar_checkbox = findViewById(R.id.sugar);
        boolean hassugar = sugar_checkbox.isChecked();


        /**
         Marshmallows?
         */
        CheckBox Marshmallows_checkbox = findViewById(R.id.marshmallows);
        boolean hasMarshmallows = Marshmallows_checkbox.isChecked();


        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "aaronleon28@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order For " + UsersName);
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary(quantity, hasWhippedCream, hasEspresso, UsersName, UsersLocation, hasdouEspresso, hasMacchaiato, hasCappuccino, hasAmericano, hasLatte, hasMocha, hasWhite, hasChocolate, hascup, hasmilk, hassugar, hasMarshmallows));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Calculates the price of the order.
     *
     * @return total price
     */
    private int calculatePrice(int amount, int cost) {
        return amount * cost;
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        if (quantity > 100) {
            Toast.makeText(this, "You cannot go over 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        displayQuantity(quantity);
    }

    /**
     * This method is called when the negitive button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        if (quantity < 1) {
            Toast.makeText(this, "You cannot go under 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        displayQuantity(quantity);
    }


    /**
     * This method displays the given price on the screen.
     * <p>
     * It will display the name, location of the room, what drink they chopse
     *
     * @param price of the order
     * @return text summary
     */
    private String createOrderSummary(int price, boolean Cream, boolean Espresso, String Person, String location, boolean DouEspresso, boolean Macchiato, boolean Cappuccino, boolean Americano, boolean Latte, boolean Mocha, boolean White, boolean Chocolate, boolean cup, boolean milk, boolean sugar, boolean Marshmallows) {
        String priceMessage = "Name: " + Person;
        priceMessage += "\nRoom Location: " + location;
        priceMessage += "\n\nEspresso: " + Espresso;
        priceMessage += "\nDouble Espresso: " + DouEspresso;
        priceMessage += "\nMacchiato: " + Macchiato;
        priceMessage += "\nCappuccino: " + Cappuccino;
        priceMessage += "\nBlack Coffee Americano: " + Americano;
        priceMessage += "\nCaffe Latte: " + Latte;
        priceMessage += "\nMocha: " + Mocha;
        priceMessage += "\nFlat White: " + White;
        priceMessage += "\nHot Chocolate: " + Chocolate;
        priceMessage += "\n\nHas Own Cup? : " + cup;
        priceMessage += "\n\nExtras";
        priceMessage += "\nAdd Milk: " + milk;
        priceMessage += "\nAdd Sugar: " + sugar;
        priceMessage += "\nAdd Whipped Cream: " + Cream;
        priceMessage += "\nAdd Marshmallows: " + Marshmallows;
        priceMessage += "\n\nQuantity: " + quantity;
        priceMessage += "\nTotal: £" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

}

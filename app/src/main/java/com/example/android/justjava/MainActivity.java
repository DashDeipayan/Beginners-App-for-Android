/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity=1;

    /**
     * This method is called when the order button is clicked.
     *
     */

    public void submitOrder(View view) {
        createOrderSummary(quantity);


    }
    public void increment(View view){
        if (quantity == 10){
            quantity =10;
            Toast toast = Toast.makeText(this,"Reached order limit!",Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            quantity++;
        }
        display(quantity);


    }
    public void decrement(View view){
        if (quantity ==1){
            quantity = 1;
            Toast toast = Toast.makeText(this,"Can't order less than 1 coffee!",Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            quantity--;
        }
        display(quantity);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    public void createOrderSummary(int number){

        EditText name_in_order = (EditText)findViewById(R.id.name_in_order);
        String nameInOrder = name_in_order.getText().toString();
        CheckBox checkBoxWhippedCream = (CheckBox)findViewById(R.id.checkbox_whipped_cream);
        CheckBox checkBoxChocolate = (CheckBox)findViewById(R.id.checkbox_chocolate);
        boolean hasCheckedWhippedCream=checkBoxWhippedCream.isChecked();
        boolean hasCheckedChocolate = checkBoxChocolate.isChecked();
        int basePrice = 5;
        if (hasCheckedWhippedCream){
            basePrice = basePrice + 1;
        }
        if (hasCheckedChocolate){
            basePrice = basePrice + 2;
        }
        String order="Name: "+nameInOrder+"\nAdd Whipped cream- "+hasCheckedWhippedCream+"\nAdd Chocolate- "+hasCheckedChocolate+
               "\nQuantity: "+number+"\nTotal: $"+(basePrice*number)+"\nThank You!";
        Context context=getApplicationContext();
        Toast message=Toast.makeText(context,"Order Created",Toast.LENGTH_SHORT);
        message.show();
        displayMessage(order);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }
}
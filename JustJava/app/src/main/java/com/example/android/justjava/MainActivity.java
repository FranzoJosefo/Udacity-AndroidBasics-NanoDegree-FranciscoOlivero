package com.example.android.justjava;

/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


import static android.widget.Toast.makeText;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    private int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        if (quantity == 100) {
            Toast toast = Toast.makeText(this, getString(R.string.errorMaxQty), Toast.LENGTH_LONG);
            toast.show();
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity < 2) {
            Toast toast = Toast.makeText(this, getString(R.string.errorMinQty), Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //Checks if the user added cream.
        CheckBox creamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_check);
        boolean hasCream = creamCheckBox.isChecked();
        //Checks if the user added chocolate.
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_check);
        boolean hasChoco = chocolateCheckBox.isChecked();
        //Store the EditText in a view.
        EditText nameText = (EditText) findViewById(R.id.name_textBox);
        //Stores the users name in a variable.
        String userName = nameText.getText().toString();
        if (!hasErrors(userName)) {
            String orderSummary = createOrderSummary(calculatePrice(hasChoco, hasCream), hasCream, hasChoco, userName);
            //displayMessage(orderSummary);
            //showMap(Uri.parse("geo:33.8120918, -117.9189742?z=11"));
            List<String> emailList = new ArrayList<>();
            emailList.add("franj.olivero@gmail.com");
            String[] emailArray = new String[emailList.size()];//creates arrat with List size.
            emailArray = emailList.toArray(emailArray);//Converts to array
            String subject = getString(R.string.emailSubject, userName);
            String body = orderSummary;
            composeEmail(emailArray, subject, body);
        }
    }

    /**
     * Calculates the price of the order.
     */
    private int calculatePrice(boolean hasChoco, boolean hasCream) {
        int priceOfCoffee = 5;
        if (hasChoco) {
            priceOfCoffee += 2;
        }
        if (hasCream) {
            priceOfCoffee += 1;
        }
        return priceOfCoffee * quantity;
    }

    /**
     * Creates Summary of a order.
     *
     * @param price    is the total price for cups of coffee.
     * @param addCream controls if we add cream or not.
     * @param addChoco controls if we add Chocolate or not.
     * @return text summary.
     */
    private String createOrderSummary(int price, boolean addCream, boolean addChoco, String name) {
        String OrderSummary = getString(R.string.summary_name, name);
        OrderSummary += "\n" + getString(R.string.summary_hasWhipped, addCream);
        OrderSummary += "\n" + getString(R.string.summary_hasChoco, addChoco);
        OrderSummary += "\n" + getString(R.string.summary_Qty, quantity);
        OrderSummary += "\n" + getString(R.string.summary_total, price);
        OrderSummary += "\n" + getString(R.string.summary_thanks);
        return OrderSummary;
    }

    private boolean hasErrors(String name) {
        String errorMessage = getString(R.string.errorOrder);
        boolean error = false;
        if (name.equals(getString(R.string.name_txtBox))) {
            errorMessage += "\n" + getString(R.string.errorName);
            error = true;
        }
        if (name.equals("")) {
            errorMessage += "\n" + getString(R.string.errorNameEmpty);
            error = true;
        }
        if (error) {
            String text = errorMessage;
            Toast toast = makeText(this, text, Toast.LENGTH_LONG);
            toast.show();
            return error;
        }
        return error;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * This method displays the given text on the screen.
     */
//    private void displayMessage(String message) {
//        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
//        orderSummaryTextView.setText(message);
//
//    }

    /**
     * This method deletes the Name placeholder on tap, and changes font to BLACK.
     *
     * @param view gets the view onClick
     */

    public void setTextBox(View view) {
        EditText textBox = (EditText) view;
        String text = textBox.getText().toString();
        if (text.equals(getString(R.string.name_txtBox))) {
            textBox.setText("");
            textBox.setTextColor(Color.BLACK);
            textBox.setEnabled(true);
        }
    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        //Sets URI (Uniform Resource Identifier)
        intent.setData(geoLocation);
        //Checks for nullity (if there is no app that supports this intent)
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void composeEmail(String[] addresses, String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SENDTO); //Messaging without attachment
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
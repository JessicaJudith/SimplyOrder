package com.example.simplyorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {



    int quantity=0;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void decrement(View view) {
        if (quantity == 0)   return;
        display(--quantity);
        displayPrice(quantity);
    }

    public void increment(View view) {
        display(++quantity);
        displayPrice(quantity);
    }
    public void submitOrder(View view){
        String message =""+NumberFormat.getCurrencyInstance().format(quantity * 6.7) + " /- incl. tax\nThank you!\nYour Coffee is on its way!";
        displayMessage(message);
    }

   public void display(int qty){
       TextView quantityTextView = (TextView) findViewById(R.id.num);
       quantityTextView.setText(""+qty);
    }
    public void displayPrice(int quantity){
        int total=quantity*5;
        TextView priceTextView = (TextView) findViewById(R.id.bill);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(total));
    }

    public void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.billmsg);
        priceTextView.setText(message);
    }
}
package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MakeOrderAcivity extends AppCompatActivity {
    private static final String EXTRA_USER_NAME = "userName";
    private TextView textViewGreetings;
    private TextView textViewAddittives;
    private Button buttonMakeOrder;
    private RadioGroup radioGroupDrinks;
    private RadioButton radioButtonTea;
    private RadioButton radioButtonCoffe;
    private CheckBox checkBoxSugar;
    private CheckBox checkBoxMilk;
    private CheckBox checkBoxLemon;
    private Spinner tea;
    private Spinner coffee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order_acivity);
        initViews();

        String userName = getIntent().getStringExtra(EXTRA_USER_NAME);
        String greetings = getString(R.string.greetings);
        String result = String.format(greetings, userName);
    }
    public static Intent newIntent(Context context, String userName){
        Intent intent = new Intent(context, MakeOrderAcivity.class);
        intent.putExtra(EXTRA_USER_NAME, userName);
        return  intent;
    }
    private  void initViews(){
        textViewGreetings = findViewById(R.id.textViewGreetings);
        textViewAddittives = findViewById(R.id.textViewAddittives);
        buttonMakeOrder = findViewById(R.id.buttonMakeOrder);
        radioGroupDrinks = findViewById(R.id.radioGroupDrinks);
        radioButtonTea = findViewById(R.id.radioButtonTea);
        radioButtonCoffe = findViewById(R.id.radioButtonCoffe);
        checkBoxSugar = findViewById(R.id.checkBoxSugar);
        checkBoxMilk = findViewById(R.id.checkBoxMilk);
        checkBoxLemon = findViewById(R.id.checkBoxLemon);
        tea = findViewById(R.id.spinnerTea);
        coffee = findViewById(R.id.spinnerCoffee);

    }
}
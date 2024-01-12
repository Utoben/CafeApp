package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

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
    private String drink;
    private String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order_acivity);
        initViews();

        userName = getIntent().getStringExtra(EXTRA_USER_NAME);
        String greetings = getString(R.string.greetings, userName);
        textViewGreetings.setText(greetings);

        radioGroupDrinks.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int id) {
                if(id == radioButtonTea.getId()){
                    onUserChooseTea();
                } else if(id == radioButtonCoffe.getId()){
                    onUserChooseCoffee();
                }

            }
        });
        radioButtonTea.setChecked(true);
        buttonMakeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onUserMadeOrder();
            }
        });


//        String result = String.format(greetings, userName);
//        textViewGreetings.setText(result);
    }

    private void onUserMadeOrder(){
        ArrayList<String> additives = new ArrayList<>();
        if(checkBoxSugar.isChecked()) {
            additives.add(checkBoxSugar.getText().toString());
        }
        if(checkBoxMilk.isChecked()) {
            additives.add(checkBoxMilk.getText().toString());
        }
        if(radioButtonTea.isChecked() && checkBoxLemon.isChecked()) {
            additives.add(checkBoxLemon.getText().toString());
        }
        String drinkType = "";
        if(radioButtonTea.isChecked()) drinkType = tea.getSelectedItem().toString();
        else if(radioButtonCoffe.isChecked()) drinkType = coffee.getSelectedItem().toString();

        Intent intent = OrderDetailActivity.newIntent(
                this,
                userName,
                drink,
                drinkType,
                additives.toString());
        startActivity(intent);
    }

    private void onUserChooseTea(){
        drink = getString(R.string.tea);
        String additivesLabel = getString(R.string.addittives_question, drink);
        textViewAddittives.setText(additivesLabel);
        checkBoxLemon.setVisibility(View.VISIBLE);
        tea.setVisibility(View.VISIBLE);
        coffee.setVisibility(View.INVISIBLE);
    }
    private void onUserChooseCoffee(){
        drink = getString(R.string.coffee);
        String additivesLabel = getString(R.string.addittives_question, drink);
        textViewAddittives.setText(additivesLabel);
        checkBoxLemon.setVisibility(View.INVISIBLE);
        coffee.setVisibility(View.VISIBLE);
        tea.setVisibility(View.INVISIBLE);
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
package com.danica.shsregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner Superman;
    EditText etLastname,etFirstname,etMiddlename;
    RadioButton rbMale,rbFemale;
    CheckBox cbxReq1, cbxReq2, cbxReq3, cbxReq4;

    String academicProgram, Lastname, Firstname, Middlename, Gender, Requirements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Superman = findViewById(R.id.Superman);
        etLastname = findViewById(R.id.etLastname);
        etFirstname = findViewById(R.id.etFirstname);
        etMiddlename = findViewById(R.id.etMiddlename);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        cbxReq1 = findViewById(R.id.cbxReq1);
        cbxReq2 = findViewById(R.id.cbxReq2);
        cbxReq3 = findViewById(R.id.cbxReq3);
        cbxReq4 = findViewById(R.id.cbxReq4);
    }

    public void submit (View view) {
        academicProgram = Superman.getSelectedItem().toString();
        Lastname = etLastname.getText().toString();
        Firstname = etFirstname.getText().toString();
        Middlename = etMiddlename.getText().toString();

        if (rbMale.isChecked()) {
            Gender = "Male";
        }
        else {
            Gender = "Female";
        }

        Requirements = "";
        if(cbxReq1.isChecked()) {
            Requirements = cbxReq1.getText().toString() + "\n";
        }
        if(cbxReq2.isChecked()) {
            Requirements = Requirements + cbxReq2.getText().toString() + "\n";
        }
        if(cbxReq3.isChecked()) {
            Requirements = Requirements + cbxReq3.getText().toString() + "\n";
        }
        if(cbxReq4.isChecked()) {
            Requirements = Requirements + cbxReq4.getText().toString() + "\n";
        }

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("academicProgram", academicProgram);
        intent.putExtra("lastname", Lastname);
        intent.putExtra("firstname", Firstname);
        intent.putExtra("middlename", Middlename);
        intent.putExtra("gender", Gender);
        intent.putExtra("requirements", Requirements);
        startActivity(intent);

    }
}

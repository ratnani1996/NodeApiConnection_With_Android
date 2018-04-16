package com.example.abhij.restapiconnection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddingStudent extends AppCompatActivity {

    MyApi myApi;
    UserApi userApi;

    EditText name;
    EditText roll;
    EditText percentage;
    EditText school;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_student);

        myApi = MyApi.getMyApiInstance();
        userApi =myApi.getUserApi();

        name= findViewById(R.id.editText_add_name);
        roll = findViewById(R.id.editText_add_roll);
        percentage = findViewById(R.id.editText_add_percentage);
        school = findViewById(R.id.editText_add_school);


        Student student = new Student(name.getText()+"",
                Integer.parseInt(roll.getText()+""),
                Float.parseFloat(percentage.getText()+""),
                school.getText()+"");

        Intent intent = new Intent();
        Bundle bundle = new Bundle();

        bundle.putSerializable("data",student);
        intent.putExtras(bundle);

        setResult(1,intent);

        finish();


    }
}

package com.example.abhij.restapiconnection;

import android.content.Intent;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    MyApi myApi;
    UserApi userApi;
    ArrayList<Student> studentArrayList;
    FrameLayout list_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Toolbar  toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        list_container= findViewById(R.id.container_StudList);


        studentArrayList= new ArrayList<>();
        myApi = MyApi.getMyApiInstance();
        userApi= myApi.getUserApi();

//                String url = "http://10.0.2.2:3000/";
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse(url));

//                startActivity(Intent.createChooser(intent,"browse"));

        studentArrayList.add(new Student("8","abhishek",32,89,"sjlj"));
        studentArrayList.add(new Student("6","jatin",31,88,"sjlj"));
        studentArrayList.add(new Student("5","himanshu",30,87,"sjlj"));
        studentArrayList.add(new Student("4","rahul",38,83,"sjlj"));

//                String urlString= "http://10.0.2.2:3000/";
//                StudentAsynTask asynTask = new StudentAsynTask();
//                asynTask.execute(urlString);



//        Call<Student> call1 = userApi.getStudent("5ab68dd7d2ce47146c92a64e");
//        call1.enqueue(new Callback<Student>() {
//            @Override
//            public void onResponse(Call<Student> call, Response<Student> response) {
//                Student user= response.body();
//                Toast.makeText(AddingStudent.this, user.getName(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<Student> call, Throwable t) {
//
//                Toast.makeText(AddingStudent.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//

        Call<List<Student>> call = userApi.getStudents();
        Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();

        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {

                studentArrayList = (ArrayList<Student>) response.body();
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();

                ListFragment fragment = new ListFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("list",studentArrayList);
                fragment.setArguments(bundle);

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.container_StudList,fragment).commit();

            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {

                Log.d("TAGGeR",t.getLocalizedMessage());
                ListFragment fragment = new ListFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("list",studentArrayList);
                fragment.setArguments(bundle);

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.container_StudList,fragment).commit();

                Snackbar.make(list_container, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,AddingStudent.class);
                startActivityForResult(intent,1);
            }


        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1)
        {
            if(resultCode==1)
            {
                Student student= (Student) data.getExtras().getSerializable("data");
                userApi.addStudent(student);

            }
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

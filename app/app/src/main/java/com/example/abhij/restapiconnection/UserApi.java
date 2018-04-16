package com.example.abhij.restapiconnection;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by abhij on 31-03-2018.
 */

public interface UserApi {



    @GET("/")
    Call<List<Student>> getStudents();

    @GET("/data/find/:{name}")
    Call<Student> getStudent(@Path("name") String id);

    @POST("/data/input")
    void addStudent(Student student);

}

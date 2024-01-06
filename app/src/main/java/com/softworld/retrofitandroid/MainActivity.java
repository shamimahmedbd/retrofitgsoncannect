package com.softworld.retrofitandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView tvdesply;
    String url = "https://jsonplaceholder.typicode.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvdesply = findViewById(R.id.tvdesplay);
        tvdesply.setText("");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create()).build();

        myapi api = retrofit.create(myapi.class);

        Call<List<Madel>> call= api.getmodel();

        call.enqueue(new Callback<List<Madel>>() {
            @Override
            public void onResponse(Call<List<Madel>> call, Response<List<Madel>> response) {
               List<Madel>data=response.body();
               for (int i=0; i<data.size();i++)
                   tvdesply.append(" SL NO:" +data.get(i).getId()+"\n Title :"+data.get(i).getTitle()+"\n\n\n");
            }

            @Override
            public void onFailure(Call<List<Madel>> call, Throwable t) {

            }
        });




    }
}
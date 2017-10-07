package com.bagicode.www.bagiwordpress;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.bagicode.www.bagiwordpress._api.ApiService;
import com.bagicode.www.bagiwordpress._api.ApiUrl;
import com.bagicode.www.bagiwordpress._wordpress.ItemPost;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getRecentPost();
    }

    public void getRecentPost () {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.URL_RECENT_POST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);

        Call<ItemPost> call = service.getRecentPost();
        call.enqueue(new Callback<ItemPost>() {
            @Override
            public void onResponse(Call<ItemPost> call, Response<ItemPost> response) {

                if (response.isSuccessful()) {

                    String status = response.body().getStatus();

                    Toast.makeText(MainActivity.this, status, Toast.LENGTH_SHORT).show();

                } else {
                    String error = "Error Retrive Data from Server !!!";
                    Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ItemPost> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error Try "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.example.heroes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import HeroeApi.HeroApi;
import model.HeroModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetActivity extends AppCompatActivity {

    private TextView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);

        lst=findViewById(R.id.lstview);

        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://10.0.2.2:3000").addConverterFactory(GsonConverterFactory.create()).build();
        HeroApi heroApi=retrofit.create(HeroApi.class);

        Call<List<HeroModel>> listCall=heroApi.getAllHero();

        listCall.enqueue(new Callback<List<HeroModel>>() {
            @Override
            public void onResponse(Call<List<HeroModel>> call, Response<List<HeroModel>> response) {
                List<HeroModel> heroModels=response.body();
                for(HeroModel hero:heroModels) {
                    String context = "";

                    context += "name" + hero.getName()+"\n";
                    context += "description" + hero.getDesc()+"\n";
        context+="..........................."+"\n";
                    lst.append(context);

                }
            }

            @Override
            public void onFailure(Call<List<HeroModel>> call, Throwable t) {
                Toast.makeText(GetActivity.this, "Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
            }
}

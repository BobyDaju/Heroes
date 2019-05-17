package com.example.heroes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import HeroeApi.HeroApi;
import model.HeroModel;
import model.HeroModel2;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostActivity extends AppCompatActivity {

    private final static String base_url="http://10.0.2.2:3000";
    private EditText name,desc;
    private Button btnregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        name=findViewById(R.id.etname);
        desc=findViewById(R.id.etdesc);
        btnregister=findViewById(R.id.register);


        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });


    }
    public void register(){
        String hero_name=name.getText().toString();
        String hero_desc=desc.getText().toString();

        HeroModel2 heroModel2=new HeroModel2(hero_name,hero_desc);

        Retrofit retrofit=new Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build();

        HeroApi heroApi=retrofit.create(HeroApi.class);

        Call<Void> voidCall=heroApi.registerHero(heroModel2);

        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(PostActivity.this, "badhai ho badhai ho", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(PostActivity.this, "panauti ram dai"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package HeroeApi;

import java.util.List;

import model.HeroModel;
import model.HeroModel2;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface HeroApi {

    @GET("heroes")
    Call<List<HeroModel>> getAllHero();

    @POST("heroes")
    Call<Void> registerHero(@Body HeroModel2 model);
}

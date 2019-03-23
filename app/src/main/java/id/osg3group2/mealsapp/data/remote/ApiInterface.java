package id.osg3group2.mealsapp.data.remote;

import id.osg3group2.mealsapp.model.SearchMealsData;
import id.osg3group2.mealsapp.model.SearchMealsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/api/json/v1/1/search.php")
    Call<SearchMealsResponse> searchMealByQuery(@Query("s") String search);
}

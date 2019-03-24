package id.osg3group2.mealsapp.data.remote;

import id.osg3group2.mealsapp.model.ListCategoryResponse;
import id.osg3group2.mealsapp.model.ListMealsCategoryResponse;
import id.osg3group2.mealsapp.model.SearchMealsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    //https://www.themealdb.com/api/json/v1/1/search.php?s=Arrabiata
    @GET("/api/json/v1/1/search.php")
    Call<SearchMealsResponse> searchMealByQuery(@Query("s") String search);

    //https://www.themealdb.com/api/json/v1/1/list.php?c=list
    @GET("/api/json/v1/1/list.php?c=list")
    Call<ListCategoryResponse> getListCategoryData();

    //https://www.themealdb.com/api/json/v1/1/filter.php?c=Seafood
    @GET("/api/json/v1/1/filter.php")
    Call<ListMealsCategoryResponse> filterMealByCategory(@Query("c") String search);
}

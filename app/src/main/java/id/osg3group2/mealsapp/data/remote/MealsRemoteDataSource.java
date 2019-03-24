package id.osg3group2.mealsapp.data.remote;

import id.osg3group2.mealsapp.data.MealsDataSource;
import id.osg3group2.mealsapp.data.remote.ApiInterface;
import id.osg3group2.mealsapp.data.remote.ApiService;
import id.osg3group2.mealsapp.model.SearchMealsData;
import id.osg3group2.mealsapp.model.SearchMealsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealsRemoteDataSource  implements MealsDataSource {

    private ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);

    @Override
    public void getListMeals(final GetMealsCallback callback, String search) {
        Call<SearchMealsResponse> call = apiInterface.searchMealByQuery(search);
        call.enqueue(new Callback<SearchMealsResponse>() {
            @Override
            public void onResponse(Call<SearchMealsResponse> call, Response<SearchMealsResponse> response) {
                callback.onMealsLoaded(response.body());
            }

            @Override
            public void onFailure(Call<SearchMealsResponse> call, Throwable t) {
                callback.onDataNotAvailable(t.toString());
            }
        });
    }
}

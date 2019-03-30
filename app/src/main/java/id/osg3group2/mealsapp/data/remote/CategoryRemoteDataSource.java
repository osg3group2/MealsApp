package id.osg3group2.mealsapp.data.remote;

import id.osg3group2.mealsapp.data.CategoryDataSource;
import id.osg3group2.mealsapp.model.ListCategoryResponse;
import id.osg3group2.mealsapp.model.ListMealsCategoryResponse;
import id.osg3group2.mealsapp.model.SearchMealsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRemoteDataSource implements CategoryDataSource {

    private ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);

    @Override
    public void getListCategory(final GetCategoryCallback getCategoryCallback) {
        Call<ListCategoryResponse> call = apiInterface.getListCategoryData();
        call.enqueue(new Callback<ListCategoryResponse>() {
            @Override
            public void onResponse(Call<ListCategoryResponse> call, Response<ListCategoryResponse> response) {
                getCategoryCallback.onCategoryLoaded(response.body());
            }

            @Override
            public void onFailure(Call<ListCategoryResponse> call, Throwable t) {
                getCategoryCallback.onDataNotAvailable(t.toString());
            }
        });
    }

    @Override
    public void getListCategoryByFilter(final GetCategoryByFilterCallback getCategoryByFilterCallback, String category) {
        Call<ListMealsCategoryResponse> call = apiInterface.filterMealByCategory(category);
        call.enqueue(new Callback<ListMealsCategoryResponse>() {
            @Override
            public void onResponse(Call<ListMealsCategoryResponse> call, Response<ListMealsCategoryResponse> response) {
                getCategoryByFilterCallback.onCategoryByFilterLoaded(response.body());
            }

            @Override
            public void onFailure(Call<ListMealsCategoryResponse> call, Throwable t) {
                getCategoryByFilterCallback.onDataNotByIdAvailable(t.toString());
            }
        });
    }

    @Override
    public void getListCategoryById(final GetCategoryByIdCallback getCategoryByIdCallback, String id) {
        Call<SearchMealsResponse> call = apiInterface.filterMealById(id);
        call.enqueue(new Callback<SearchMealsResponse>() {
            @Override
            public void onResponse(Call<SearchMealsResponse> call, Response<SearchMealsResponse> response) {
                getCategoryByIdCallback.onCategoryByIdLoaded(response.body());
            }

            @Override
            public void onFailure(Call<SearchMealsResponse> call, Throwable t) {
                getCategoryByIdCallback.onDataNotByIdAvailable(t.toString());
            }
        });
    }
}

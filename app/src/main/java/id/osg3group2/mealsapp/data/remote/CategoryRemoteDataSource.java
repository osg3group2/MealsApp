package id.osg3group2.mealsapp.data.remote;

import id.osg3group2.mealsapp.data.CategoryDataSource;
import id.osg3group2.mealsapp.model.ListCategoryResponse;
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
}

package id.osg3group2.mealsapp.data;

import id.osg3group2.mealsapp.model.SearchMealsResponse;

public class MealsRepository implements MealsDataSource {

    private MealsDataSource mealsDataSource;

    public MealsRepository(MealsDataSource mealsDataSource) {
        this.mealsDataSource = mealsDataSource;
    }

    @Override
    public void getListMeals(final GetMealsCallback callback, String search) {
        mealsDataSource.getListMeals(new GetMealsCallback() {
            @Override
            public void onMealsLoaded(SearchMealsResponse data) {
                callback.onMealsLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                callback.onDataNotAvailable(errorMessage);
            }
        }, search);
    }
}

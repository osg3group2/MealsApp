package id.osg3group2.mealsapp.data;

import id.osg3group2.mealsapp.model.SearchMealsResponse;

public interface MealsDataSource {
    void getListMeals(GetMealsCallback callback, String search);

    interface GetMealsCallback {
        void onMealsLoaded(SearchMealsResponse data);

        void onDataNotAvailable(String errorMessage);
    }
}

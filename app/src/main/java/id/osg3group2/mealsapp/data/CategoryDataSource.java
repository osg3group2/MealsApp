package id.osg3group2.mealsapp.data;

import id.osg3group2.mealsapp.model.ListCategoryResponse;
import id.osg3group2.mealsapp.model.ListMealsCategoryResponse;
import id.osg3group2.mealsapp.model.SearchMealsResponse;

public interface CategoryDataSource {

    void getListCategory(GetCategoryCallback getCategoryCallback);

    void getListCategoryByFilter(GetCategoryByFilterCallback getCategoryByFilterCallback, String category);

    void getListCategoryById(GetCategoryByIdCallback getCategoryByIdCallback, String id);

    interface GetCategoryCallback {
        void onCategoryLoaded(ListCategoryResponse data);

        void onDataNotAvailable(String errorMessage);
    }

    interface GetCategoryByFilterCallback {
        void onCategoryByFilterLoaded(ListMealsCategoryResponse data);

        void onDataNotByIdAvailable(String errorMessage);
    }

    interface GetCategoryByIdCallback {
        void onCategoryByIdLoaded(SearchMealsResponse mealsResponse);

        void onDataNotByIdAvailable(String errorMessage);
    }
}

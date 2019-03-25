package id.osg3group2.mealsapp.data;

import id.osg3group2.mealsapp.model.ListCategoryResponse;
import id.osg3group2.mealsapp.model.ListMealsCategoryResponse;

public interface CategoryDataSource {

    void getListCategory(GetCategoryCallback getCategoryCallback);

    void getListCategoryByFilter(GetCategoryByFilterCallback getCategoryByFilterCallback, String category);

    interface GetCategoryCallback {
        void onCategoryLoaded(ListCategoryResponse data);

        void onDataNotAvailable(String errorMessage);
    }

    interface GetCategoryByFilterCallback {
        void onCategoryByFilterLoaded(ListMealsCategoryResponse data);

        void onDataNotByIdAvailable(String errorMessage);
    }
}

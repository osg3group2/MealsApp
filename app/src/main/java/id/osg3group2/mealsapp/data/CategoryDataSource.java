package id.osg3group2.mealsapp.data;

import id.osg3group2.mealsapp.model.ListCategoryResponse;

public interface CategoryDataSource {

    void getListCategory(GetCategoryCallback getCategoryCallback);

    interface GetCategoryCallback {
        void onCategoryLoaded(ListCategoryResponse data);

        void onDataNotAvailable(String errorMessage);
    }
}

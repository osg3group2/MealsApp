package id.osg3group2.mealsapp.helpers;

import java.util.List;

import id.osg3group2.mealsapp.model.ListCategoryData;

public interface CategoryNavigator {

    void loadListCategoryMeals(List<ListCategoryData> categoryDataList);

    void errorLoadListCategoryMeals(String message);
}

package id.osg3group2.mealsapp.helpers;

import java.util.List;

import id.osg3group2.mealsapp.model.ListCategoryData;
import id.osg3group2.mealsapp.model.ListMealsCategoryData;
import id.osg3group2.mealsapp.model.SearchMealsData;

public interface CategoryNavigator {

    void loadListCategoryMeals(List<ListCategoryData> categoryDataList);

    void loadListCategoryByFilter(List<ListMealsCategoryData> mealsCategoryDataList);

    void loadListCategoryById(List<SearchMealsData> mealsDataList);

    void errorLoadListCategoryMeals(String message);
}

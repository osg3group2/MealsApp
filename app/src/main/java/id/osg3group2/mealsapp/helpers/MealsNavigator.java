package id.osg3group2.mealsapp.helpers;

import java.util.List;

import id.osg3group2.mealsapp.model.SearchMealsData;

public interface MealsNavigator {
    void loadListMeals(List<SearchMealsData> searchMealsDataList);

    void errorLoadListMeals(String message);


}

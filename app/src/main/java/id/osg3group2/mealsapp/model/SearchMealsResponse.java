package id.osg3group2.mealsapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SearchMealsResponse {

	@SerializedName("meals")
	private List<SearchMealsData> meals;

	public void setMeals(List<SearchMealsData> meals){
		this.meals = meals;
	}

	public List<SearchMealsData> getMeals(){
		return meals;
	}

	@Override
 	public String toString(){
		return 
			"SearchMealsResponse{" +
			"meals = '" + meals + '\'' + 
			"}";
		}
}
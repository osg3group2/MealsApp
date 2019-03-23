package id.osg3group2.mealsapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ListMealsCategoryResponse{

	@SerializedName("meals")
	private List<ListMealsData> meals;

	public void setMeals(List<ListMealsData> meals){
		this.meals = meals;
	}

	public List<ListMealsData> getMeals(){
		return meals;
	}

	@Override
 	public String toString(){
		return 
			"ListMealsCategoryResponse{" + 
			"meals = '" + meals + '\'' + 
			"}";
		}
}
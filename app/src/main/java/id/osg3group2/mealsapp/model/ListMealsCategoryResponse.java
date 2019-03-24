package id.osg3group2.mealsapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ListMealsCategoryResponse{

	@SerializedName("meals")
	private List<ListMealsCategoryData> meals;

	public void setMeals(List<ListMealsCategoryData> meals){
		this.meals = meals;
	}

	public List<ListMealsCategoryData> getMeals(){
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
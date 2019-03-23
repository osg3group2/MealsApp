package id.osg3group2.mealsapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ListCategoryResponse{

	@SerializedName("meals")
	private List<ListCategoryData> meals;

	public void setMeals(List<ListCategoryData> meals){
		this.meals = meals;
	}

	public List<ListCategoryData> getMeals(){
		return meals;
	}

	@Override
 	public String toString(){
		return 
			"ListCategoryResponse{" + 
			"meals = '" + meals + '\'' + 
			"}";
		}
}
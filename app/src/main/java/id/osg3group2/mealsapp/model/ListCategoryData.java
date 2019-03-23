package id.osg3group2.mealsapp.model;

import com.google.gson.annotations.SerializedName;

public class ListCategoryData {

	@SerializedName("strCategory")
	private String strCategory;

	public void setStrCategory(String strCategory){
		this.strCategory = strCategory;
	}

	public String getStrCategory(){
		return strCategory;
	}

	@Override
 	public String toString(){
		return 
			"ListCategoryData{" +
			"strCategory = '" + strCategory + '\'' + 
			"}";
		}
}
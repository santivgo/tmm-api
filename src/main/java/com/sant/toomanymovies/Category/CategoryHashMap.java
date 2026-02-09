package com.sant.toomanymovies.Category;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class CategoryHashMap {


    private final Map<Integer, String> categoryHashMap;

    public CategoryHashMap(){
        categoryHashMap = new HashMap<Integer, String>();
        for (CategoryEnum enu: CategoryEnum.values()){
            categoryHashMap.put(enu.getId(), enu.getName());
        }
    }




}

package com.sant.toomanymovies.Category;


import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO map(CategoryModel categoryModel);
    CategoryModel map(CategoryDTO categoryDTO);


}

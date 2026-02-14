package com.sant.toomanymovies.Category;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryMapper categoryMapper;
    private CategoryRepository categoryRepository;

    public CategoryDTO createNewCategory(CategoryDTO categoryDTO){
        CategoryModel categoryModel = categoryMapper.map(categoryDTO);

        if(categoryRepository.existsById(categoryModel.getId())){
            return null;
        }
        categoryModel = categoryRepository.save(categoryModel);
        return categoryMapper.map(categoryModel);
    }

    public List<CategoryDTO> createListOfCategories(List<CategoryDTO> categoryDTOList){
        List<CategoryModel> categoryModelList = categoryDTOList.stream().map(categoryMapper::map).toList();
        categoryModelList = categoryRepository.saveAll(categoryModelList);
        return categoryModelList.stream().map(categoryMapper::map).toList();
    }

    public CategoryDTO getCategory(Long id){
        return categoryRepository.findById(id)
                                  .map(categoryMapper::map).orElse(null);
    }

    public CategoryDTO deleteById(Long id){
        CategoryModel categoryDTO = categoryRepository.findById(id).orElse(null);
        if(categoryDTO == null) return null;

        return categoryMapper.map(categoryDTO);
    }


    public Set<CategoryDTO> getCategoriesList(){
        List<CategoryModel> categoryModelList = categoryRepository
                .findAll(Sort.by("id"));
        return categoryModelList.stream()
               .map(categoryMapper::map)
               .collect(Collectors.toSet());
    }

}

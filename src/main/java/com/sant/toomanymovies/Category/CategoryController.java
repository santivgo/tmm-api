package com.sant.toomanymovies.Category;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getCategories(){
        List<CategoryDTO> categoriesDTO = categoryService.getCategoriesList().stream().toList();
        return ResponseEntity.ok(categoriesDTO) ;
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO createCategoryResponse = categoryService.createNewCategory(categoryDTO);
        if (createCategoryResponse == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já cadastrada no banco.");
        }

        return ResponseEntity.status(201).body(createCategoryResponse);
    }

    @PostMapping("/batch")
    ResponseEntity<List<CategoryDTO>> categoryList(@RequestBody List<CategoryDTO> categoryDTOList){
        List<CategoryDTO> categoryDTOS = categoryService.createListOfCategories(categoryDTOList);
        return ResponseEntity.ok(categoryDTOS);
    }

    @GetMapping("/{id}")
    ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id){
        CategoryDTO categoryDTO = categoryService.getCategory(id);
        if (categoryDTO == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(categoryDTO);
        }
        return ResponseEntity.ok(categoryDTO);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteCategory(@PathVariable Long id){
        CategoryDTO categoryDTO = categoryService.deleteById(id);

        if (categoryDTO == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Não foi possível deletar");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }

}

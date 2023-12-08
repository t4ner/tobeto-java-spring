package com.spring.homework.controllers;

import com.spring.homework.models.Category;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoriesController {
    List<Category> inCategoriesList = new ArrayList<>();

    @GetMapping
    public List<Category> get(){
        return inCategoriesList;
    }

    @GetMapping("{id}")
    public Category getById(@PathVariable int id){
        Category category = inCategoriesList.stream().filter((p) -> p.getId() == id).findFirst().orElseThrow();
        return category;
    }

    @PostMapping
    public String add(@RequestBody Category category) {
        inCategoriesList.add(category);
        return category.getId()+" ID' li kategori sisteme eklendi.";
    }

    @PutMapping
    public String update(@RequestBody Category updatedCategory){
        Category category = inCategoriesList
                .stream()
                // Lambda Expressions
                .filter((p) -> p.getId() == updatedCategory.getId()) // 1 eleman [ {} ]
                .findFirst() // {}
                .orElseThrow();
        category.setName(updatedCategory.getName());

        return category.getId()+" ID' li kategori güncellendi.";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable int id){
        Category category = inCategoriesList
                .stream()
                // Lambda Expressions
                .filter((p) -> p.getId() == id) // 1 eleman [ {} ]
                .findFirst() // {}
                .orElseThrow();
        inCategoriesList.remove(category);
        return id+" ID' li kategori silindi.";
    }
}

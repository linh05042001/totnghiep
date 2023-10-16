package com.example.totnghiep.service;

import com.example.totnghiep.model.Category;

import java.util.List;

public interface CategoryService {
    public Category addCategory(Category category);

    public Category editCategory(long id, Category category);
    public boolean deleteCategory(long id);
    public List<Category> selectCategory();
}

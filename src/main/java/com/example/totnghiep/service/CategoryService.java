package com.example.totnghiep.service;

import com.example.totnghiep.Dto.CategoryDto;
import com.example.totnghiep.model.Category;

import java.util.List;

public interface CategoryService {
    public Category addCategory(CategoryDto categoryDto);

    public Category editCategory(long id, CategoryDto categoryDto);
    public boolean deleteCategory(long id);
    public List<Category> selectCategory();
    public Category getCategorybyId(long id);

    public List<Category> seach(String key);
    public List<Category> Mindan(String type);
    public List<Category> Maxdan(String type);
    public List<Category> SelectType(String type);

}

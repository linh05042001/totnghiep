package com.example.totnghiep.service.impl;

import com.example.totnghiep.model.Category;
import com.example.totnghiep.repository.CategoryRepository;
import com.example.totnghiep.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryIMPL implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Category addCategory(Category category) {
        if(category != null){
            return categoryRepository.save(category);
        }
        return null;
    }

    @Override
    public Category editCategory(long id, Category category) {
        if(category!=null){
            Category us=categoryRepository.getById(id);
            if(us!=null){
                us.setName(category.getName());
                us.setColor(category.getColor());
                us.setSize(category.getSize());
                us.setYear(category.getYear());
                return categoryRepository.save(us);
            }
        }
        return null;
    }

    @Override
    public boolean deleteUser(long id) {
        if(id>=1){
            Category us=categoryRepository.getById(id);
            if(us!=null){
                categoryRepository.delete(us);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Category> selectCategory() {
        return categoryRepository.findAll();
    }
}

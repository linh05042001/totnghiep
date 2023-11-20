package com.example.totnghiep.service.impl;

import com.example.totnghiep.Dto.CategoryDto;
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
    public Category addCategory(CategoryDto categoryDto) {
        if(categoryDto != null){
            Category category=new Category(
                    categoryDto.getId(),
                    categoryDto.getName(),
                    categoryDto.getPrice(),
                    categoryDto.getSize(),
                    categoryDto.getImage(),
                    categoryDto.getNumber()
            );
            return categoryRepository.save(category);
        }
        return null;
    }

    @Override
    public Category editCategory(long id, CategoryDto categoryDto) {
        if(categoryDto!=null){
            Category us=categoryRepository.getById(id);
            if(us!=null){
                us.setName(categoryDto.getName());
                us.setPrice(categoryDto.getPrice());
                us.setSize(categoryDto.getSize());
                us.setImage(categoryDto.getImage());
                us.setNumber(categoryDto.getNumber());
                return categoryRepository.save(us);
            }
        }
        return null;
    }

    @Override
    public boolean deleteCategory(long id) {
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

    @Override
    public Category getCategorybyId(long id) {
        Category us=categoryRepository.getById(id);
        if (us!=null) {
            return us;
        }
        return null;
    }
}

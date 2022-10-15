package com.reto_3.repositorio;

import com.reto_3.modelo.Category;
import com.reto_3.repositorio.crud.CategoryCrudRepositoryInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepositoryInterfaz categoryCrudRepositoryInterfaz;

    public List<Category> obtenerCategoryCompleta() {
        return (List<Category>) categoryCrudRepositoryInterfaz.findAll();
    }

    public Optional<Category> obtenerCategoryId(Integer id) {
        return categoryCrudRepositoryInterfaz.findById(id);
    }

    public Category salvarCategory(Category category) {
        return categoryCrudRepositoryInterfaz.save(category);
    }

    public void delete(Category category) {
        categoryCrudRepositoryInterfaz.delete(category);
    }
}

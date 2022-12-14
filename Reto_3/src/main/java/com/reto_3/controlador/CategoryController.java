package com.reto_3.controlador;

import com.reto_3.modelo.Category;
import com.reto_3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> obtenerCategoryCompleta() {
        return categoryService.obtenerCategoryCompleta();
    }

    @GetMapping("/{id}")
    public Optional<Category> obtenerCategoryId(@PathVariable("id") Integer identificador) {
        return categoryService.obtenerCategoryId(identificador);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category salvarCategory(@RequestBody Category category) {
        return categoryService.salvarCategory(category);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return categoryService.deleteCategory(id);
    }
}

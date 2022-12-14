package com.reto_3.controlador;

import com.reto_3.modelo.Admin;
import com.reto_3.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/api/Admin")
    public List<Admin> obtenerAdminCompleta() {
        return adminService.obtenerAdminCompleta();
    }

    @GetMapping("/{id}")
    public Optional<Admin> obtenerAdminId(@PathVariable("id") Integer identificador) {
        return adminService.obtenerAdminId(identificador);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin salvarAdmin(@RequestBody Admin admin) {
        return adminService.salvarAdmin(admin);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin) {
        return adminService.updateAdmin(admin);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return adminService.deleteAdmin(id);
    }
}
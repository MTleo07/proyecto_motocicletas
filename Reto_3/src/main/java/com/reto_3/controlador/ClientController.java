package com.reto_3.controlador;

import com.reto_3.modelo.Client;
import com.reto_3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> obtenerClientCompleta() {
        return clientService.obtenerClientCompleta();
    }

    @GetMapping("/{id}")
    public Optional<Client> obtenerClientId(@PathVariable("id") Integer identificador) {
        return clientService.obtenerClientId(identificador);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client salvarClient(@RequestBody Client client) {
        return clientService.salvarClient(client);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client) {
        return clientService.updateClient(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return clientService.deleteClient(id);
    }

}

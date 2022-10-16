package com.reto_3.controlador;

import com.reto_3.modelo.Message;
import com.reto_3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class MessageControler {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> obtenerMessageCompleta() {
        return messageService.obtenerMessageCompleta();
    }

    @GetMapping("/{id}")
    public Optional<Message> obtenerMessageId(@PathVariable("id") Integer identificador) {
        return messageService.obtenerMessageId(identificador);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message salvarMessage(@RequestBody Message message) {
        return messageService.salvarMessage(message);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message) {
        return messageService.updateMessage(message);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return messageService.deleteMessage(id);
    }
}

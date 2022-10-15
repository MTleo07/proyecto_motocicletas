package com.reto_3.repositorio;

import com.reto_3.modelo.Message;
import com.reto_3.repositorio.crud.MessageCrudRepositoryInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepositoryInterfaz messageCrudRepositoryInterfaz;

    public List<Message> obtenerMessageCompleta() {
        return (List<Message>) messageCrudRepositoryInterfaz.findAll();
    }

    public Optional<Message> obtenerMessageId(Integer id) {
        return messageCrudRepositoryInterfaz.findById(id);
    }

    public Message salvarMessage(Message message) {
        return messageCrudRepositoryInterfaz.save(message);
    }

    public void delete(Message message) {
        messageCrudRepositoryInterfaz.delete(message);
    }
}

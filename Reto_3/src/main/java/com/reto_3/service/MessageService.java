package com.reto_3.service;

import com.reto_3.modelo.Message;
import com.reto_3.repositorio.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    public MessageRepository messageRepository;

    public List<Message> obtenerMessageCompleta() {
        return messageRepository.obtenerMessageCompleta();

    }

    public Optional<Message> obtenerMessageId(Integer id) {
        return messageRepository.obtenerMessageId(id);
    }

    public Message salvarMessage(Message message) {
        if (message.getIdMessage() == null) {
            return messageRepository.salvarMessage(message);
        } else {
            Optional<Message> messageAuxiliar = messageRepository.obtenerMessageId(message.getIdMessage());
            if (messageAuxiliar.isPresent()) {
                return messageRepository.salvarMessage(message);
            } else {
                return message;
            }
        }

    }

    public Message updateMessage(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> e = messageRepository.obtenerMessageId(message.getIdMessage());
            if (!e.isPresent()) {
                if (message.getMessageText() != null) {
                    e.get().setMessageText(message.getMessageText());
                }

                messageRepository.salvarMessage(e.get());
                return e.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    public boolean deleteMessage(int id) {
        Boolean d = obtenerMessageId(id).map(message -> {
            messageRepository.delete(message);
            return true;

        }).orElse(false);
        return d;
    }

}

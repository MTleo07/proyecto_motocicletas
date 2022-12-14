package com.reto_3.service;

import com.reto_3.modelo.Motorbike;
import com.reto_3.repositorio.MotorbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorbikeService {

    @Autowired
    public MotorbikeRepository motorbikeRepository;

    public List<Motorbike> obtenerMotorbikeCompleta() {
        return motorbikeRepository.obtenerMotorbikeCompleta();

    }

    public Optional<Motorbike> obtenerMotorbikeId(Integer id) {
        return motorbikeRepository.obtenerMotorbikeId(id);
    }

    public Motorbike salvarMotorbike(Motorbike motorbike) {
        if (motorbike.getId() == null) {
            return motorbikeRepository.salvarMotorbike(motorbike);
        } else {
            Optional<Motorbike> motorbikeAuxiliar = motorbikeRepository.obtenerMotorbikeId(motorbike.getId());
            if (!motorbikeAuxiliar.isPresent()) {
                return motorbikeRepository.salvarMotorbike(motorbike);
            } else {
                return motorbike;
            }
        }

    }

    public Motorbike updateMotorbike(Motorbike motorbike) {
        if (motorbike.getId() != null) {
            Optional<Motorbike> e = motorbikeRepository.obtenerMotorbikeId(motorbike.getId());
            if (e.isPresent()) {
                if (motorbike.getYear() != null) {
                    e.get().setYear(motorbike.getYear());
                }
                if (motorbike.getBrand() != null) {
                    e.get().setBrand(motorbike.getBrand());
                }
                if (motorbike.getDescription() != null) {
                    e.get().setDescription(motorbike.getDescription());
                }
                if (motorbike.getCategory() != null) {
                    e.get().setCategory(motorbike.getCategory());
                }
                if (motorbike.getName() != null) {
                    e.get().setName(motorbike.getName());
                }
                motorbikeRepository.salvarMotorbike(e.get());
                return e.get();
            } else {
                return motorbike;
            }
        } else {
            return motorbike;
        }
    }

    public boolean deleteMotorbike(int id) {
        Boolean d = obtenerMotorbikeId(id).map(motorbike -> {
            motorbikeRepository.delete(motorbike);
            return true;

        }).orElse(false);
        return d;
    }

}

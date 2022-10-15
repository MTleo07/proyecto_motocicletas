package com.reto_3.repositorio;

import com.reto_3.modelo.Motorbike;
import com.reto_3.repositorio.crud.MotorbikeCrudRepositoryInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MotorbikeRepository {

    @Autowired
    private MotorbikeCrudRepositoryInterfaz motorbikeCrudRepositoryInterfaz;

    public List<Motorbike> obtenerMotorbikeCompleta() {
        return (List<Motorbike>) motorbikeCrudRepositoryInterfaz.findAll();
    }

    public Optional<Motorbike> obtenerMotorbikeId(Integer id) {
        return motorbikeCrudRepositoryInterfaz.findById(id);
    }

    public Motorbike salvarMotorbike(Motorbike motorbike) {
        return motorbikeCrudRepositoryInterfaz.save(motorbike);
    }

    public void delete(Motorbike motorbike) {
        motorbikeCrudRepositoryInterfaz.delete(motorbike);
    }
}

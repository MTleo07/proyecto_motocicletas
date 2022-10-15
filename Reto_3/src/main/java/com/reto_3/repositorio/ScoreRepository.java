package com.reto_3.repositorio;

import com.reto_3.modelo.Score;
import com.reto_3.repositorio.crud.ScoreCrudRepositoryInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepositoryInterfaz scoreCrudRepositoryInterfaz;

    public List<Score> obtenerScoreCompleta() {
        return (List<Score>) scoreCrudRepositoryInterfaz.findAll();
    }

    public Optional<Score> obtenerScoreId(Integer id) {
        return scoreCrudRepositoryInterfaz.findById(id);
    }

    public Score salvarScore(Score score) {
        return scoreCrudRepositoryInterfaz.save(score);
    }

    public void delete(Score score) {
        scoreCrudRepositoryInterfaz.delete(score);
    }
}

package com.reto_3.controlador;

import com.reto_3.modelo.Score;
import com.reto_3.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> obtenerScoreCompleta() {
        return scoreService.obtenerScoreCompleta();
    }

    @GetMapping("/{id}")
    public Optional<Score> obtenerScoreId(@PathVariable("id") Integer identificador) {
        return scoreService.obtenerScoreId(identificador);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score salvarScore(@RequestBody Score score) {
        return scoreService.salvarScore(score);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score score) {
        return scoreService.updateScore(score);
    }
    /* 
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return scoreService.deleteScore(id);
    }*/

}

package vagasws;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VagaController {

    private VagaRepo vagaRepo;

    public VagaController(VagaRepo vagaRepo) {
        this.vagaRepo = vagaRepo;
    }

    @GetMapping("/fci/api/vagas")
    public List<Vaga> getVagas() {
        return vagaRepo.findAll();
    }

    @GetMapping("/fci/api/vagas/{id}")
    public Vaga getVaga(@PathVariable long id) {
        return vagaRepo.findById(id).orElse(null);
    }

    @PostMapping("/fci/api/vagas")
    public Vaga createVaga(@RequestBody Vaga novaVaga) {
        novaVaga.setId(0);
        return vagaRepo.save(novaVaga);
    }

    @PutMapping("/fci/api/vagas/{id}")
    public Vaga updateVaga(@PathVariable long id, @RequestBody Vaga vagaAtualizada) {
        if (vagaRepo.existsById(id)) {
            vagaAtualizada.setId(id);
            return vagaRepo.save(vagaAtualizada);
        }
        return null;
    }

    @DeleteMapping("/fci/api/vagas/{id}")
    public Vaga deleteVaga(@PathVariable long id) {
        Vaga vaga = vagaRepo.findById(id).orElse(null);

        if (vaga != null) {
            vagaRepo.deleteById(id);
        }

        return vaga;
    }
}

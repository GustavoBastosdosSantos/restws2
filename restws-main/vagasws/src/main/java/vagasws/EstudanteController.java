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
public class EstudanteController {

    private EstudanteRepo estudanteRepo;

    public EstudanteController(EstudanteRepo estudanteRepo) {
        this.estudanteRepo = estudanteRepo;
    }

    @GetMapping("/fci/api/estudantes")
    public List<Estudante> getEstudantes() {
        return estudanteRepo.findAll();
    }

    @GetMapping("/fci/api/estudantes/{id}")
    public Estudante getEstudante(@PathVariable long id) {
        return estudanteRepo.findById(id).orElse(null);
    }

    @PostMapping("/fci/api/estudantes")
    public Estudante createEstudante(@RequestBody Estudante novoEstudante) {
        novoEstudante.setId(0);
        return estudanteRepo.save(novoEstudante);
    }

    @PutMapping("/fci/api/estudantes/{id}")
    public Estudante updateEstudante(@PathVariable long id, @RequestBody Estudante estudanteAtualizado) {
        if (estudanteRepo.existsById(id)) {
            estudanteAtualizado.setId(id);
            return estudanteRepo.save(estudanteAtualizado);
        }
        return null;
    }

    @DeleteMapping("/fci/api/estudantes/{id}")
    public Estudante deleteEstudante(@PathVariable long id) {
        Estudante estudante = estudanteRepo.findById(id).orElse(null);

        if (estudante != null) {
            estudanteRepo.deleteById(id);
        }

        return estudante;
    }
}

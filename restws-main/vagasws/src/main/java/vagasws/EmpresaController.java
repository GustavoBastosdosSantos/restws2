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
public class EmpresaController {

    private EmpresaRepo empresaRepo;

    public EmpresaController(EmpresaRepo empresaRepo) {
        this.empresaRepo = empresaRepo;
    }

    @GetMapping("/fci/api/empresas")
    public List<Empresa> getEmpresas() {
        return empresaRepo.findAll();
    }

    @GetMapping("/fci/api/empresas/{id}")
    public Empresa getEmpresa(@PathVariable long id) {
        return empresaRepo.findById(id).orElse(null);
    }

    @PostMapping("/fci/api/empresas")
    public Empresa createEmpresa(@RequestBody Empresa novaEmpresa) {
        novaEmpresa.setId(0);
        return empresaRepo.save(novaEmpresa);
    }

    @PutMapping("/fci/api/empresas/{id}")
    public Empresa updateEmpresa(@PathVariable long id, @RequestBody Empresa empresaAtualizada) {
        if (empresaRepo.existsById(id)) {
            empresaAtualizada.setId(id);
            return empresaRepo.save(empresaAtualizada);
        }
        return null;
    }

    @DeleteMapping("/fci/api/empresas/{id}")
    public Empresa deleteEmpresa(@PathVariable long id) {
        Empresa empresa = empresaRepo.findById(id).orElse(null);

        if (empresa != null) {
            empresaRepo.deleteById(id);
        }

        return empresa;
    }
}

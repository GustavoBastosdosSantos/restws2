package vagasws;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner carregarDados(EmpresaRepo empresaRepo, EstudanteRepo estudanteRepo, VagaRepo vagaRepo) {
        return args -> {
            if (empresaRepo.count() == 0) {
                empresaRepo.save(new Empresa("Empresa Alfa LTDA", "12.345.678/0001-90", "contato@empresa-alfa.com"));
                empresaRepo.save(new Empresa("Beta Comércio ME", "98.765.432/0001-10", "beta@comercio.com"));
                empresaRepo.save(new Empresa("Gamma Serviços S. A.", "11.222.333/0001-44", "servicos@gamma.com"));
                empresaRepo.save(new Empresa("Delta Engenharia", "22.333.444/0001-55", "contato@deltaeng.com"));
                empresaRepo.save(new Empresa("Epsilon Digital", "33.444.555/0001-66", "email@epsilondigital.com"));
            }

            if (estudanteRepo.count() == 0) {
                estudanteRepo.save(new Estudante("Ana Paula Souza", "ana.souza@email.com", "2002-03-15", 2020));
                estudanteRepo.save(new Estudante("Carlos Henrique Lima", "carlos.lima@email.com", "2001-10-22", 2019));
                estudanteRepo.save(new Estudante("Fernanda Oliveira", "fernanda.oliveira@email.com", "2003-07-05", 2021));
                estudanteRepo.save(new Estudante("Lucas Pereira", "lucas.pereira@email.com", "2002-04-11", 2020));
                estudanteRepo.save(new Estudante("Gabriela Martins", "gabriela.martins@email.com", "2001-12-25", 2019));
                estudanteRepo.save(new Estudante("Rafael Costa", "rafael.costa@email.com", "2000-09-13", 2018));
                estudanteRepo.save(new Estudante("Juliana Silva", "juliana.silva@email.com", "2002-06-18", 2020));
                estudanteRepo.save(new Estudante("Marcos Vinícius", "marcos.vinicius@email.com", "2003-01-30", 2021));
                estudanteRepo.save(new Estudante("Camila Azevedo", "camila.azevedo@email.com", "2001-11-08", 2019));
                estudanteRepo.save(new Estudante("Felipe Cardoso", "felipe.cardoso@email.com", "2000-08-27", 2018));
            }

            if (vagaRepo.count() == 0) {
                vagaRepo.save(new Vaga("Desenvolvedor Java", "Atuação em projetos backend com Java e Spring. Experiência desejada em APIs REST.", "2025-10-01", true, 1));
                vagaRepo.save(new Vaga("Analista de Suporte Técnico", "Suporte a clientes, resolução de chamados e participação em treinamentos internos.", "2025-09-27", true, 2));
                vagaRepo.save(new Vaga("Engenheiro de Software", "Desenvolvimento de soluções para sistemas corporativos, integração e automação.", "2025-10-03", false, 3));
                vagaRepo.save(new Vaga("Analista de Dados", "Manipulação e análise de grandes volumes de dados. Conhecimentos de SQL e Python.", "2025-09-18", true, 4));
                vagaRepo.save(new Vaga("Designer Digital", "Criação de materiais gráficos, UX/UI e participação em campanhas de marketing.", "2025-09-30", false, 5));
                vagaRepo.save(new Vaga("Consultor de Projetos", "Elaboração e acompanhamento de projetos empresariais e treinamentos.", "2025-10-06", true, 1));
                vagaRepo.save(new Vaga("Programador Full Stack", "Desenvolvimento de aplicações web frontend e backend com foco em automação.", "2025-10-04", true, 2));
            }
        };
    }
}

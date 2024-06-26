package com.livraria.livraria.services;

import com.livraria.livraria.entity.Contas;
import com.livraria.livraria.repository.ContasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContasServices {
    private ContasRepository contasRepository;

    public ContasServices(ContasRepository contasRepository) {
        this.contasRepository = contasRepository;
    }
    public void cadastrarContas (Contas contas){
        contasRepository.save(contas);
    }
    public Optional<Contas> buscarContas (long id){
        return contasRepository.findById(id);
    }
    public void deletarContas(Long id){
        contasRepository.deleteAllById(id);
    }
    public Contas editarContas (Contas contas){
        return contasRepository.save(contas);
    }
    public List<Contas> listarContas() {
        List<Contas> CO = contasRepository.findAll();
        return CO;
    }
   /* public Contas atualizarContas(Contas contas) {
        return contasRepository.save(contas);
    }*/

}

package com.livraria.livraria.services;

import com.livraria.livraria.entity.Enderecos;
import com.livraria.livraria.repository.EnderecosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecosServices {

    private EnderecosRepository enderecosRepository;

    public EnderecosServices(EnderecosRepository enderecosRepository) {
        this.enderecosRepository = enderecosRepository;
    }
    public void adicionarEnderecos(Enderecos enderecos){
        enderecosRepository.save(enderecos);
    }
    public void cadastrarEnderecos(Enderecos enderecos) {
        enderecosRepository.save(enderecos);
    }
    public List<Enderecos> listarTodosEnderecos(){
        return enderecosRepository.findAll();
    }

    public Optional<Enderecos> buscarPorId(long id){
        return enderecosRepository.findById(id);
    }

    public Enderecos editarEnderecos (Enderecos enderecos){
        return enderecosRepository.save(enderecos);
    }

    public Optional<Enderecos> buscarPeloCidade(String cidade){
        return enderecosRepository.findByCidade(cidade);
    }

    public void deletarEnderecos(Long id){
        enderecosRepository.deleteById(id);
    }
    public Enderecos atualizarEnderecos(Enderecos enderecos) {
        return enderecosRepository.save(enderecos);
    }
}

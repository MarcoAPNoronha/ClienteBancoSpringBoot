package com.example.banco.service;


import com.example.banco.dto.ClienteBancoDTO;
import com.example.banco.entity.ClienteBanco;
import com.example.banco.repository.ClienteBancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteBancoService {

    @Autowired
    private ClienteBancoRepository clienteRepository;


    public List<ClienteBancoDTO> findAllClientes(){
        //return de Lista pode existir vazio
        return clienteRepository.findAll().
                stream()
                .map(this::toClienteBancoDTO)
                .toList();
    }

    private ClienteBancoDTO toClienteBancoDTO(ClienteBanco clienteBanco) {
        return new ClienteBancoDTO(
                clienteBanco.getId(),
                clienteBanco.getNome(),
                clienteBanco.getEmail(),
                clienteBanco.getEndereco(),
                clienteBanco.getTelefone()
        );
    }


    public Optional<ClienteBancoDTO> findClienteBancoById(Long id){
        //return de objeto único pode ser vazio, pro caso de não achar.
        //Por isso o uso de Optional
        return clienteRepository.findById(id).
                map(this::toClienteBancoDTO);
    }


    public ClienteBancoDTO criarCliente(ClienteBanco clienteBanco){
        ClienteBanco clienteSalvo = clienteRepository.save(clienteBanco);
        return toClienteBancoDTO(clienteSalvo);
    }


    public ClienteBancoDTO updateClienteBanco(Long id, ClienteBanco updateClienteBanco){
        return clienteRepository.findById(id)
                .map(clienteBanco -> {
                    clienteBanco.setNome(updateClienteBanco.getNome());
                    clienteBanco.setEmail((updateClienteBanco.getEmail()));
                    clienteBanco.setEndereco(updateClienteBanco.getEndereco());
                    clienteBanco.setTelefone(updateClienteBanco.getTelefone());
                    clienteBanco.setSenha(updateClienteBanco.getSenha());

                    ClienteBanco clienteSalvo = clienteRepository.save(clienteBanco);
                    return toClienteBancoDTO(clienteSalvo);
                }).orElseThrow(() -> new RuntimeException("Cliente não existe"));
    }


    public void excluirClienteBanco(Long id){
        clienteRepository.deleteById(id);
    }

}

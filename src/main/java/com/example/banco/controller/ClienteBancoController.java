package com.example.banco.controller;


import com.example.banco.dto.ClienteBancoDTO;
import com.example.banco.entity.ClienteBanco;
import com.example.banco.service.ClienteBancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteBancoController {


    @Autowired
    private ClienteBancoService clienteBancoService;



    @GetMapping
    private List<ClienteBancoDTO> buscarClientes() {
        return clienteBancoService.findAllClientes();
    }


    @GetMapping("/{id}")
    private ResponseEntity<ClienteBancoDTO> buscarClientePorId(@PathVariable Long id) {
        return clienteBancoService.findClienteBancoById(id)
                .map(cliente -> ResponseEntity.ok().body(cliente))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    private ClienteBancoDTO criarCliente(@RequestBody ClienteBanco clienteBanco){
        return clienteBancoService.criarCliente(clienteBanco);
    }


    @PutMapping("/{id}")
    private ClienteBancoDTO atualizarCliente(@PathVariable Long id, @RequestBody ClienteBanco clienteBanco){
        return clienteBancoService.updateClienteBanco(id, clienteBanco);
    }


    @DeleteMapping("/{id}")
    private void deletarCliente(@PathVariable Long id) {
        clienteBancoService.excluirClienteBanco(id);
    }



}




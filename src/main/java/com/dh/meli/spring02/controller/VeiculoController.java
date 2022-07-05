package com.dh.meli.spring02.controller;

import com.dh.meli.spring02.model.Veiculo;
import com.dh.meli.spring02.repository.VeiculoRepo;
import com.dh.meli.spring02.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoRepo service;

    @GetMapping("/{placa}")
    public ResponseEntity<Veiculo> getVeiculo(@PathVariable String placa) {
        // ESSE CÓDIGO NÃO É MAIS EXECUTADO, PORQUE VAI SER LANÇADA A EXCEÇÃO.
        // Veiculo v = repo.getVeiculo(placa);

        // if(v != null) {
        //    return ResponseEntity.ok(v);
        //}

        // return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(service.getVeiculo(placa));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Veiculo>> getAllVeiculo() {
        List<Veiculo> lista = service.getAllVeiculo();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void saveVeiculo(@RequestBody Veiculo novoVeiculo){
        service.saveVeiculo(novoVeiculo);
    }

}

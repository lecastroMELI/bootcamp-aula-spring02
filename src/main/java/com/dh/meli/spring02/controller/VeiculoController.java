package com.dh.meli.spring02.controller;

import com.dh.meli.spring02.model.Veiculo;
import com.dh.meli.spring02.repository.VeiculoRepo;
import com.dh.meli.spring02.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.dh.meli.spring02.dto.VeiculoDto;


@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    // private VeiculoRepo repo;
    private VeiculoService service; // ALTERADO PELA CAMADA DE SERVIÇO

    @GetMapping("/{placa}")
    public ResponseEntity<VeiculoDto> getVeiculo(@PathVariable String placa) {
        // ESSE CÓDIGO NÃO É MAIS EXECUTADO, PORQUE VAI SER LANÇADA A EXCEÇÃO.
        // Veiculo v = repo.getVeiculo(placa);

        // if(v != null) {
        //    return ResponseEntity.ok(v);
        //}

        // return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(service.getVeiculo(placa));
    }


    @GetMapping("/all")
    public ResponseEntity<List<VeiculoDto>> getAllVeiculo() {
        List<VeiculoDto> lista = service.getAllVeiculo();
        return ResponseEntity.ok(lista);
    }

    // ORDENA POR VALOR
    @GetMapping("/allOrder")
    public ResponseEntity<List<VeiculoDto>> getAllVeiculoOrder() {
        List<VeiculoDto> lista = service.getAllOrderByValue();
        return ResponseEntity.ok(lista);
    }

    // ORDENA POR MODELO
    @GetMapping("/allbymodel")
    public ResponseEntity<List<VeiculoDto>> getAllVeiculoOrderByModelo() {
        List<VeiculoDto> lista = service.getAllOrderByModelo();
        return ResponseEntity.ok(lista);
    }

    // FILTRA PELO MODELO
    @GetMapping("/bymodel/{modelo}")
    public ResponseEntity<List<VeiculoDto>> getByModelo(@PathVariable String modelo) {
        List<VeiculoDto> lista = service.getByModelo(modelo);
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void saveVeiculo(@RequestBody Veiculo novoVeiculo){
        service.saveVeiculo(novoVeiculo);
    }

}

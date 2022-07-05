// IMPLEMENTA A INTERFACE

// O CONTROLLER VAI DEPENDER DA INTERFACE (ELE NÃO DEVE DEPENDER DE UMA CLASSE CONTRETA)

package com.dh.meli.spring02.service;

import com.dh.meli.spring02.dto.VeiculoDto;
import com.dh.meli.spring02.model.Veiculo;
import com.dh.meli.spring02.repository.VeiculoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// ANOTANDO QUE ESSA CLASSE SERVIRÁ COMO A CAMADA DE SERVIÇO
@Service
// ESTA CLASSE IMPLEMENTA A INTERFACE VeiculoService
public class VeiculoServiceImp implements VeiculoService {
    // Toda classe que implementa uma interface, deve implementar os métodos

    // DEVEMOS DEFINIR ISSO AQUI¹
    @Autowired
    private VeiculoRepo repo;

    // ¹A EXECUÇÃO DESSES MÉTODOS DEPENDE DO REPOSITORY VeiculoRepo

    @Override
    public VeiculoDto getVeiculo(String placa) {
        // passo como parametro o veículo que veio desse retorno repo.getVeiculo(placa)
        VeiculoDto veiculoDto = new VeiculoDto(repo.getVeiculo(placa));
        return veiculoDto;
    }

    @Override
    public List<VeiculoDto> getAllVeiculo() {
        // repo.getAllVeiculo() retorna uma lista de veículo
        List<Veiculo> listaVeiculos = repo.getAllVeiculo();
        // necessário transformar em uma lista de veiculoDto
        List<VeiculoDto> listaDto = listaVeiculos.stream()
            // convertendo cada elemento em um veiculoDto
            .map(VeiculoDto::new).collect(Collectors.toList()); // transfoma em lista : .collect(Collectors.toList())
            // .map(v -> new VeiculoDto(v)).collect(Collectors.toList()); // outra forma de fazer o map

        return listaDto;
    }

    @Override
    public void saveVeiculo(Veiculo novoVeiculo) {
        repo.saveVeiculo(novoVeiculo);
    }

    @Override
    public List<VeiculoDto> getAllOrderByValue() {
        // entra uma lista de veiculos, mas preciso de uma lista de veiculo dto

        List<Veiculo> listaVeiculos = repo.getAllVeiculo();

        return listaVeiculos.stream()
            .sorted() // ordenar por valor
            .map(VeiculoDto::new) // transformo veiculo num veiculo dto, criando com o new
            .collect(Collectors.toList());
    }

    // ORDENA POR MODELO
    @Override
    public List<VeiculoDto> getAllOrderByModelo() {
        List<Veiculo> listaVeiculos = repo.getAllVeiculo();

        return listaVeiculos.stream()
            // O compareTo é do método String, pois o getModelo retorna umA string
            .sorted((v1, v2) -> v1.getModelo().compareTo(v2.getModelo())) // ordenar pelo modelo
            .map(VeiculoDto::new) // transformo veiculo num veiculo dto, criando com o new
            .collect(Collectors.toList());
    }

    // FILTRANDO PELO MODELO
    @Override
    public List<VeiculoDto> getByModelo(String modelo) {
        List<Veiculo> listaVeiculos = repo.getAllVeiculo();

        return listaVeiculos.stream()
            // equals é case sensitive, portanto necessário ignorar
            .filter(v -> v.getModelo().equalsIgnoreCase(modelo)) // inclui no conjunto quando é True, e não inclui quando é falso
            .map(VeiculoDto::new) // transformo veiculo num veiculo dto, criando com o new
            .collect(Collectors.toList());
    }
}

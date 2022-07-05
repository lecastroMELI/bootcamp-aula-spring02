// IMPLEMENTA A INTERFACE

// O CONTROLLER VAI DEPENDER DA INTERFACE (ELE NÃO DEVE DEPENDER DE UMA CLASSE CONTRETA)

package com.dh.meli.spring02.service;

import com.dh.meli.spring02.model.Veiculo;
import com.dh.meli.spring02.repository.VeiculoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoServiceImp implements VeiculoService {
    // Toda classe que implementa uma interface, deve implementar os métodos

    // DEVEMOS DEFINIR ISSO AQUI*
    @Autowired
    private VeiculoRepo repo;

    // *A EXECUÇÃO DESSE MÉTODO DEPENDE DO REPOSITÓRIO
    @Override
    public Veiculo getVeiculo(String placa) {
        return repo.getVeiculo(placa);
    }

    @Override
    public List<Veiculo> getAllVeiculo() {
        return null;
    }

    @Override
    public void saveVeiculo(Veiculo novoVeiculo) {

    }
}

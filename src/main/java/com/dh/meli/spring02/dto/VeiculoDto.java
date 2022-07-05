package com.dh.meli.spring02.dto;

// DTO = Data Transfer Object -> usado para filtrar informações

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.dh.meli.spring02.model.Veiculo;

@Getter
@Setter
@NoArgsConstructor
public class VeiculoDto {
    // os atributos serão as informações do veículo que quero que sejam mostradas
    private String placa;
    private String modelo;
    private double valor;

    public VeiculoDto(Veiculo veiculo) {
        this.placa = veiculo.getPlaca();
        this.modelo = veiculo.getModelo();
        this.valor = veiculo.getValor();

        // usa get porque os atributos são privados
    }
}

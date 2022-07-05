package com.dh.meli.spring02.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo  implements Comparable<Veiculo>{
    private String placa;
    private String modelo;
    private double valor;
    private String renavam;

    @Override
    public int compareTo(Veiculo outro) {
        if(this.valor > outro.getValor())
            return 1;
        if(this.valor < outro.getValor())
            return -1;
        return 0;
    }
}

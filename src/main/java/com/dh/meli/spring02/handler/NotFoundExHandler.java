package com.dh.meli.spring02.handler;

import com.dh.meli.spring02.exception.NotFoundException;
import com.dh.meli.spring02.exception.NotFoundExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

// ANOTAÇÃO PARA COMUNICAR O CONTROLLER/SPRING QUE DEVERÁ FAZER O TRATAMENTO DO ERRO NotFoundException
// POR MEIO DESSA CLASSE. OU SEJA, IRÁ SUBSTITUIR O ERRO PADRÃO, PELO ERRO PERSONALIZADO
@ControllerAdvice
public class NotFoundExHandler {
    // Anotação para indicar que esse método vai devolver para o cliente a exceção já tratada
    @ExceptionHandler(NotFoundException.class) // informar qual exeção vai ser disparada, ou seja, o que será retornado
    // é a classe da exceção personalizada que eu criei.
    // A classe que gera a exceção personalizada vai por parâmetro neste método: handlerNotFoundEx(<aqui>)
    public ResponseEntity<NotFoundExceptionDetails> handlerNotFoundEx(NotFoundException ex) {
        // return new ResponseEntity<>(<o-que-vai-devolver>, <o-status>)
        return new ResponseEntity<>(
            // construo o retorno de acordo com os atributos que quero mostrar, através do @Builder
            NotFoundExceptionDetails.builder()
                .title("Objeto não encontrado! (esses dados estão em NotFoundExHandler)")
                .status(HttpStatus.NOT_FOUND.value()) // Quero que envie o valor do status, ou seja, o número 404
                .message(ex.getMessage()) // Essa mensagem, foi passada por parâmetro, ao chamar a classe
                // 'NotFoundException' em VeiculoRepo(),
                // e é o conteúdo dela que quero que esse atribuo aqui receba para mostrar no erro personalizado
                .timestamp(LocalDateTime.now()) // pega a data e hora atual
                .build(),
            HttpStatus.NOT_FOUND
        );
    }
}

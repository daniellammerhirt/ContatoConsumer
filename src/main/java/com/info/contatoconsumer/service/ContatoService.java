package com.info.contatoconsumer.service;


import com.info.contatoconsumer.model.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private WebClient webClient;

    private final String uri = "/contato";

    public Contato findById(Integer id){
        Mono<Contato> monoContato = this.webClient.method(HttpMethod.GET).
                uri(uri + "/" + id).
                retrieve().
                bodyToMono(Contato.class);
        return monoContato.block();
    }

    public List<Contato> findAll(){
        Mono<List<Contato>> monoListContato = this.webClient.method(HttpMethod.GET).
                uri(uri).
                retrieve().
                bodyToFlux(Contato.class).collectList();
        return monoListContato.block();
    }

    public Contato save(Contato contato){
        Mono<Contato> monoContato = this.webClient.method(HttpMethod.POST).
                uri(uri).
                body(BodyInserters.fromValue(contato)).
                retrieve().
                bodyToMono(Contato.class);
        return monoContato.block();
    }

    public Void delete(Integer id){
        Mono<Void> monoVoid = this.webClient.method(HttpMethod.DELETE).
                uri(uri + "/" + id).retrieve().bodyToMono(Void.class);
        return monoVoid.block();
    }
}

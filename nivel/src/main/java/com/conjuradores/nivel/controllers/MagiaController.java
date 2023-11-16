package com.conjuradores.nivel.controllers;

import java.lang.Iterable;
import java.util.ArrayList;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;



import com.conjuradores.nivel.entities.Magias;
import com.conjuradores.nivel.repositories.MagiaRepository;

@RestController()
@RequestMapping()
public class MagiaController {
    private MagiaRepository magiaRepository;

    public MagiaController(MagiaRepository magiaRepository){
        this.magiaRepository = magiaRepository;
    }

    @GetMapping("/comandos")
    public ArrayList<String> getComandos(){
        String verComandos = "localhost:8080/comandos - Veja todos os comandos disponíveis.";
        String todasAsMagias = "localhost:8080/magias - Acesso a lista de magia";
        String todasAsClasses = "localhost:8080/magias/'classe' - Altere 'classe' por: bardo, bruxo, clerigo, druida, feititeiro ou mago, para ter acesso a lista de magias da classe escolhida";
        String magiasDeClasses = "localhost:8080/magias/'classe'/'nivel' - Altere 'classe por: bardo, bruxo, clerigo, druida, feiticeiro ou mago, e altere 'nivel' por: 0, 1 - para filtrar apenas os níveis de magias que desejar da classe específica";
        ArrayList<String> instrucoes = new ArrayList<>();
        instrucoes.add(verComandos);
        instrucoes.add(todasAsMagias);
        instrucoes.add(todasAsClasses);
        instrucoes.add(magiasDeClasses);
        return instrucoes;
    }

    @GetMapping("/magias")
    public Iterable<Magias> getAllMagias(){
        return this.magiaRepository.findAll();
    }

    @GetMapping("/magias/{classe}")
    public Iterable<Magias> getMagiasClasse(@PathVariable("classe") String classe){
        return this.magiaRepository.getListByClasse(classe);
    }

    @GetMapping("/magias/{classe}/{nivel}")
    public Iterable<Magias> getBardoMagiasNivel(
        @PathVariable("classe") String classe,
        @PathVariable("nivel") String nivel){
        Iterable<Magias> getMagiasBardoSpell = this.magiaRepository.getListByClasseAndNivel(classe, nivel);
        return getMagiasBardoSpell;
    }

 
    
}
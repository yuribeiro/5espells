package com.conjuradores.nivel.controllers;

import java.lang.Iterable;
import java.util.ArrayList;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;



import com.conjuradores.nivel.entities.Magias;
import com.conjuradores.nivel.entities.EscolasMagias;
import com.conjuradores.nivel.repositories.MagiaRepository;
import com.conjuradores.nivel.repositories.EscolasRepository;

@RestController()
@RequestMapping()
public class MagiaController {
    private MagiaRepository magiaRepository;
    private EscolasRepository escolasRepository;

    public MagiaController(MagiaRepository magiaRepository, EscolasRepository escolasRepository){
        this.magiaRepository = magiaRepository;
        this.escolasRepository = escolasRepository;
    }



    // Retorna listas de comandos
    @GetMapping("/comandos")
    public ArrayList<String> getComandos(){
        String verComandos = "localhost:8080/comandos - Todos os comandos disponíveis.";
        String todasAsMagias = "localhost:8080/magias - Acesso a lista de todas as magias";
        String todasAsClasses = "localhost:8080/magias/classes/'classe' - Altere 'classe' por: bardo, bruxo, clerigo, druida, feititeiro ou mago, retorna lista de magia da classe escolhida";
        String todasOsNiveis = "localhost:8080/magias/niveis/'nivel' - Altere 'nivel' por um numero de 0 a 9, para listar todas as magias do nível escolhido";
        String magiasDeClasses = "localhost:8080/magias/'classe'/'nivel' - Altere 'classe por: bardo, bruxo, clerigo, druida, feiticeiro ou mago, e altere 'nivel' pelo numero de 0 a 9 - Retorna lista de magias da classe e nivel escolhido";
        String verEscolaDeMagia = "localhost:8080/magias/escolas/'escola' - Altere pelo nome da escola que deseja ver a lista de magia";
        ArrayList<String> instrucoes = new ArrayList<>();
        instrucoes.add(verComandos);
        instrucoes.add(todasAsMagias);
        instrucoes.add(todasAsClasses);
        instrucoes.add(todasOsNiveis);
        instrucoes.add(magiasDeClasses);
        instrucoes.add(verEscolaDeMagia);
        return instrucoes;
    }

    // Retorna lista de todas as magias
    @GetMapping("/magias")
    public Iterable<Magias> getAllMagias(){
        return this.magiaRepository.findAll();
    }

    // Retorna lista de todas as magias baseada na classe escolhida
    @GetMapping("/magias/classe/{classe}")
    public Iterable<Magias> getMagiasClasse(@PathVariable("classe") String classe){
        return this.magiaRepository.getListByClasse(classe);
    }

    // Retorna lista de todas as magias baseadas no nível escolhido
    @GetMapping("/magias/nivel/{nivel}")
    public Iterable<Magias> getMagiasNivel(@PathVariable("nivel") String nivel){
        return this.magiaRepository.getListByNivel(nivel);
    }

    // Retorna lista magias baseadas na classe e o nível escolhido
    @GetMapping("/magias/{classe}/{nivel}")
    public Iterable<Magias> getBardoMagiasNivel(
        @PathVariable("classe") String classe,
        @PathVariable("nivel") String nivel){
        Iterable<Magias> getMagiasBardoSpell = this.magiaRepository.getListByClasseAndNivel(classe, nivel);
        return getMagiasBardoSpell;
    }

    // Retorna lista de todas as magias por escola
    @GetMapping("/magias/escolas")
    public Iterable<EscolasMagias> getMagiasPorEscolas(){
        return this.escolasRepository.findAll();
    }

    // Retorna lista de magias pela escola escolhida
    @GetMapping("/magias/escolas/{escola}")
    public Iterable<EscolasMagias> getMagiasByEscolas(@PathVariable("escola") String escola){
        return this.escolasRepository.getListByEscolasDaMagia(escola);
    }
    
}
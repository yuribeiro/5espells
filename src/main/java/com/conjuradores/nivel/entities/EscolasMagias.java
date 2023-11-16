package com.conjuradores.nivel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name="ESCOLAS")
public class EscolasMagias {
    
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="ESCOLA")
    private String escolasDaMagia;

    // Coluna de nível 
    @Column(name="NIVEL")
    private String nivelDaMagia;

    // Coluna dos nomes das Magias
    @Column(name="MAGIA")
    private String nomeDaMagia;

    //GETTER METHODS

    // Retorna Id
    public Integer getId(){
        return this.id;
    }

    // Retorna Escolas existentes
    public String getEscolasDaMagia(){
        return this.escolasDaMagia;
    }

    // Retorna nivel da magia
    public String getNivelEscola(){
        return this.nivelDaMagia;
    }

    // Retorna o nome da magia
    public String getNomeDaMagia(){
        return this.nomeDaMagia;
    }
}

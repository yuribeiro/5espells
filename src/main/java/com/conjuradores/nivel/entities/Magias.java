package com.conjuradores.nivel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name="MAGIAS")
public class Magias {
    
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="CLASSE")
    private String classe;

    @Column(name="NIVEL")
    private String nivel;

    @Column(name="NOME")
    private String nomeMagia;

    //GETTER METHODS

    // Retorna a id da magia
    public Integer getId(){
        return this.id;
    }

    // Retorna o Nível da Magia
    public String getClasse(){
        return this.classe;
    }

    // Retorna o Nome da magia
    public String getNivel(){
        return this.nivel;
    }

    public String getNome(){
        return this.nomeMagia;
    }


    //SETTER METHODS

    // Configura novo valor do Id
    public void setId(Integer id){
        this.id = id;
    }

    // Configura novo valor da classe da magia
    public void setClasse(String classe){
        this.classe = classe;
    }

    // Configura novo valor do Nome da Magia
    public void setNome(String nomeMagia){
        this.nomeMagia = nomeMagia;
    }

    // Configura novo valor do Nível da Magia
    public void setNivel(String nivel){
        this.nivel = nivel;
    }

}

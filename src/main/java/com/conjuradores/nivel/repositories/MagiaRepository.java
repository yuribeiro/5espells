package com.conjuradores.nivel.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.conjuradores.nivel.entities.Magias;

public interface MagiaRepository extends CrudRepository<Magias, Integer>{

    // Filtro que retorna a lista baseada no nome da classe
    List<Magias> getListByClasse(String classe);

    // Filtro que retorna a lista baseada no nivel da magia
    List<Magias> getListByNivel(String nivel);

    // Filtro que retorna a lista baseada no nome da classe e no nível da magia
    List<Magias> getListByClasseAndNivel(String classe, String nivel);

}

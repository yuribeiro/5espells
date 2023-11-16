package com.conjuradores.nivel.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.conjuradores.nivel.entities.Magias;

public interface MagiaRepository extends CrudRepository<Magias, Integer>{
    List<Magias> getListByClasse(String classe);
    List<Magias> getListByNivel(String nivel);
    List<Magias> getListByClasseAndNivel(String classe, String nivel);

}

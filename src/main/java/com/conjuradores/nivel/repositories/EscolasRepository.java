package com.conjuradores.nivel.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.conjuradores.nivel.entities.EscolasMagias;

public interface EscolasRepository extends CrudRepository<EscolasMagias, Integer>{

    // Filtro que retorna a lista de magias por escola
    List<EscolasMagias> getListByEscolasDaMagia(String escolasDaMagia);
}

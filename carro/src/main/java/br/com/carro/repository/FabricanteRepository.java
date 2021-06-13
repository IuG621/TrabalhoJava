/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.carro.repository;

import br.com.carro.model.Fabricante;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author iUg
 */
public interface FabricanteRepository extends CrudRepository<Fabricante,Long>{
    
}

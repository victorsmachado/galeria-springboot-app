package br.gov.sp.fatec.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import br.gov.sp.fatec.springbootapp.entity.Imagem;

public interface ImagemRepository extends JpaRepository<Imagem, Long>{
    
    public Imagem findByNome(String imagem);
}
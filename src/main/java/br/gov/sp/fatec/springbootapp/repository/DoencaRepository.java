package br.gov.sp.fatec.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springbootapp.entity.Doenca;

public interface DoencaRepository extends JpaRepository<Doenca, Long> {

    public List<Doenca> findByNomeContainsIgnoreCase(String nome);

    public Doenca findByNome(String nome);

    @Query("select u from Doenca u where u.nome = ?1")
    public Doenca buscaDoencaPorNome(String nome);

    @Query("select u from Doenca u inner join u.imagens a where a.nome = ?1")
    public List<Doenca> buscaPorNomeImagem(String imagem);

    public Doenca findByNomeAndDescricao(String nome, String descricao);

}
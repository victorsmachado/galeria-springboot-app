package br.gov.sp.fatec.springbootapp.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "doe_doenca")
public class Doenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doe_id")
    private long id;

    @Column(name = "doe_nome")
    private String nome;
    
    @Column(name = "doe_descricao")
    private String descricao;

    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "dim_doenca_imagem",
		joinColumns = { @JoinColumn(name = "doe_id") },
		inverseJoinColumns = { @JoinColumn(name = "ima_id") })
	private Set<Imagem> imagens;
   

    public Long getId(){
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }



    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(Set<Imagem> imagens) {
		this.imagens = imagens;
	}
    


}
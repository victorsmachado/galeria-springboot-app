package br.gov.sp.fatec.springbootapp.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ima_imagem")
public class Imagem {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ima_id")
	private Long id;
	
	@Column(name = "ima_nome", unique=true, length = 20, nullable = false)
    private String nome;

    @Column(name = "ima_endereco", unique=true, length = 20, nullable = false)
    private String endereco;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "imagens")
    private Set<Doenca> doencas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
    }

    public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
    }
    
    public Set<Doenca> gDoencas() {
		return doencas;
	}

	public void setDoencas(Set<Doenca> doencas) {
		this.doencas = doencas;
	}
    
}
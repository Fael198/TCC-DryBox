package br.fepi.tcc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "material")
public class Material implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "partNumber", length = 60, nullable = false)
	private String partNumber;
	
	@Column(name = "quantidade", length = 60, nullable = false)
	private int quantidade;
	
	@Column(name = "quantidadeMin", length = 60, nullable = false)
	private int quantidadeMin;
	
	@Column(name = "quantidadeMax", length = 60, nullable = false)
	private int quantidadeMax;
	
	@Column(name = "descricao", length = 60, nullable = false)
	private String descricao;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "estoqueId")
	private Estoque estoque;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getQuantidadeMin() {
		return quantidadeMin;
	}
	public void setQuantidadeMin(int quantidadeMin) {
		this.quantidadeMin = quantidadeMin;
	}
	public int getQuantidadeMax() {
		return quantidadeMax;
	}
	public void setQuantidadeMax(int quantidadeMax) {
		this.quantidadeMax = quantidadeMax;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}

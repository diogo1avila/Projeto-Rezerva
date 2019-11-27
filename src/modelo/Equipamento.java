package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Equipamento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String nome;
	@OneToOne
	private TipoEquipamento tipoequipamento;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoEquipamento getTipoequipamento() {
		return tipoequipamento;
	}
	public void setTipoequipamento(TipoEquipamento tipoequipamento) {
		this.tipoequipamento = tipoequipamento;
	}
	
	

}

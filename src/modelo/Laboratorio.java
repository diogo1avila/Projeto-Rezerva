package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Laboratorio {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Integer id;
	private String nome;
	 private int numero;
	 @OneToOne
	 private TipoLab tipolab;
	 public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public TipoLab getTipolab() {
		return tipolab;
	}
	public void setTipolab(TipoLab tipolab) {
		this.tipolab = tipolab;
	}
	

}

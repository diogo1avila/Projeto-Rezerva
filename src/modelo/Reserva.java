package modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Reserva {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	private Pessoa usuario ;
	@OneToOne
	private Laboratorio laboratorio ;
	
	private Calendar data;
	private Calendar horainicio;
	private Calendar horafim;
	public Pessoa getUsuario() {
		return usuario;
	}
	public void setUsuario(Pessoa usuario) {
		this.usuario = usuario;
	}
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public Calendar getHorainicio() {
		return horainicio;
	}
	public void setHorainicio(Calendar horainicio) {
		this.horainicio = horainicio;
	}
	public Calendar getHorafim() {
		return horafim;
	}
	public void setHorafim(Calendar horafim) {
		this.horafim = horafim;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	

}

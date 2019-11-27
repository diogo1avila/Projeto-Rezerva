package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.Dao;
import modelo.Laboratorio;
import modelo.Pessoa;
import modelo.Reserva;
import modelo.TipoLab;

@ManagedBean
@ViewScoped
public class ReservaControler {
	private Reserva reserva= new Reserva();
	private Integer idPessoa, idLab;
	
	
	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public Integer getIdLab() {
		return idLab;
	}

	public void setIdLab(Integer idLab) {
		this.idLab = idLab;
	}



	public void gravar(){
		Pessoa p= new Dao<Pessoa>(Pessoa.class).buscaPorId(idPessoa);
		reserva.setUsuario(p);
		Laboratorio l = new Dao<Laboratorio>(Laboratorio.class).buscaPorId(idLab);
		reserva.setLaboratorio(l);
		if(reserva.getId()==null)
			new Dao<Reserva>(Reserva.class).adiciona(reserva);
		else
			new Dao<Reserva>(Reserva.class).atualiza(reserva);
	}
	
	public List<Reserva>getTodasReservas(){
		return new Dao<Reserva>(Reserva.class).buscaTodos();
	}
	
	public void remover(Reserva r){
		new Dao<Reserva>(Reserva.class).remove(r.getId());
	}
	
	public void carregar(Reserva r){
		idPessoa=r.getUsuario().getId();
		idLab=r.getLaboratorio().getId();
		reserva= r;
	}
	
	public List<TipoLab> getTodosTipos(){
		return new Dao<TipoLab>(TipoLab.class).buscaTodos();
	}
	
	
}

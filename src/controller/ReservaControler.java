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
	private Integer idReserva;
	private Reserva reserva= new Reserva();
	private Integer idPessoa, idLab;
	public Integer getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}
	public Reserva getR() {
		return reserva;
	}
	public void setR(Reserva r) {
		this.reserva = r;
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
	
	public List<Reserva>getTodasRezervas(){
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

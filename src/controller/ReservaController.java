package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.Dao;
import modelo.Laboratorio;
import modelo.Pessoa;
import modelo.Reserva;

@ManagedBean
@ViewScoped
public class ReservaController {
	private Reserva reserva = new Reserva();
	private Integer idPessoa,idLaboratorio;
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
	public Integer getIdLaboratorio() {
		return idLaboratorio;
	}
	public void setIdLaboratorio(Integer idLab) {
		this.idLaboratorio = idLab;
	}
	public void gravar(){
		Pessoa p = new Dao<Pessoa>(Pessoa.class).buscaPorId(idPessoa);
		reserva.setPessoa(p);
		Laboratorio l = new Dao<Laboratorio>(Laboratorio.class).buscaPorId(idLaboratorio);
		reserva.setLaboratorio(l);
		if(reserva.getId()==null)
			new Dao<Reserva>(Reserva.class).adiciona(reserva);
		else
			new Dao<Reserva>(Reserva.class).atualiza(reserva);
	}
	
	public List<Reserva>getTodosReservas(){
		return new Dao<Reserva>(Reserva.class).buscaTodos();
	}
	
	public void remover(Reserva p){
		new Dao<Reserva>(Reserva.class).remove(p.getId());
	}
	
	public void carregar(Reserva p){
		idPessoa=p.getPessoa().getId();
		reserva= p;
	}
	
	public List<Pessoa> getTodosPessoa(){
		return new Dao<Pessoa>(Pessoa.class).buscaTodos();
	}
	public List<Laboratorio> getTodosLaboratorio(){
		return new Dao<Laboratorio>(Laboratorio.class).buscaTodos();
	}
}

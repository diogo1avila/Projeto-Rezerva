package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.Dao;
import modelo.Equipamento;
import modelo.TipoEquipamento;


@ManagedBean
@ViewScoped
public class EquipamentoController {
	
	private Equipamento equipamento = new Equipamento();
	private Integer idTipoEquipamento;
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	public Integer getIdTipoEquipamento() {
		return idTipoEquipamento;
	}
	public void setIdTipoEquipamento(Integer idTipoEquipamento) {
		this.idTipoEquipamento = idTipoEquipamento;
	}
	
	public void gravar(){
		TipoEquipamento t = new Dao<TipoEquipamento>(TipoEquipamento.class).buscaPorId(idTipoEquipamento);
		equipamento.setTipoequipamento(t);
		if(equipamento.getId()==null)
			new Dao<Equipamento>(Equipamento.class).adiciona(equipamento);
		else
			new Dao<Equipamento>(Equipamento.class).atualiza(equipamento);
	}
	
	public List<Equipamento>getTodosEquipamentos(){
		return new Dao<Equipamento>(Equipamento.class).buscaTodos();
	}
	
	public void remover(Equipamento p){
		new Dao<Equipamento>(Equipamento.class).remove(p.getId());
	}
	
	public void carregar(Equipamento p){
		idTipoEquipamento=p.getTipoequipamento().getId();
		equipamento= p;
	}
	
	public List<TipoEquipamento> getTodosTipos(){
		return new Dao<TipoEquipamento>(TipoEquipamento.class).buscaTodos();
	}

}

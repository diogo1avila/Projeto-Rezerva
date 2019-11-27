package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.Dao;
import modelo.TipoEquipamento;


@ManagedBean
@ViewScoped
public class TipoEquipamentoController {
	
	public TipoEquipamento getTipoequipamento() {
		return tipoequipamento;
	}

	public void setTipoequipamento(TipoEquipamento tipoequipamento) {
		this.tipoequipamento = tipoequipamento;
	}

	TipoEquipamento tipoequipamento = new TipoEquipamento();
	
	public void gravar(){
		if(tipoequipamento.getId()== null)
			new Dao<TipoEquipamento>(TipoEquipamento.class).adiciona(tipoequipamento);
		else
			new Dao<TipoEquipamento>(TipoEquipamento.class).atualiza(tipoequipamento);
	}
	
	
	public List<TipoEquipamento>getTodosTipos(){
		return new Dao<TipoEquipamento>(TipoEquipamento.class).buscaTodos();
	}
	
	public void remover(TipoEquipamento p){
		new Dao<TipoEquipamento>(TipoEquipamento.class).remove(p.getId());
	}
	
	public void carregar(TipoEquipamento t){
		tipoequipamento= t;
	}
	

}

package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.Dao;
import modelo.Equipamento;
import modelo.EquipamentosLab;
import modelo.Laboratorio;
import modelo.TipoLab;

@ManagedBean
@ViewScoped
public class LaboratorioController {
	private Laboratorio laboratorio = new Laboratorio();
	private Integer idTipoLab;
	private Integer qtde;
	private Integer equipamentoId;

	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	public Integer getEquipamentoId() {
		return equipamentoId;
	}

	public void setEquipamentoId(Integer equipamentoId) {
		this.equipamentoId = equipamentoId;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public Integer getIdTipoLab() {
		return idTipoLab;
	}

	public void setIdTipoLab(Integer idTipoLab) {
		this.idTipoLab = idTipoLab;
	}

	public List<Equipamento> getTodosEquipamentos() {
		return new Dao<Equipamento>(Equipamento.class).buscaTodos();
	}

	public void gravarItem() {
		Equipamento p = new Dao<Equipamento>(Equipamento.class).buscaPorId(equipamentoId);
		EquipamentosLab item = new EquipamentosLab();
		item.setEquipamento(p);
		item.setQtde(qtde);
		item.setLaboratorio(laboratorio);

		laboratorio.getItens().add(item);
		qtde = 0;
		equipamentoId = null;
	}

	public List<EquipamentosLab> getItensDaComanda() {
		return laboratorio.getItens();
	}

	public void removerItem(EquipamentosLab item) {

	}

	public void gravar() {
		TipoLab t = new Dao<TipoLab>(TipoLab.class).buscaPorId(idTipoLab);
		laboratorio.setTipolab(t);
		if (laboratorio.getId() == null)
			new Dao<Laboratorio>(Laboratorio.class).adiciona(laboratorio);
		else
			new Dao<Laboratorio>(Laboratorio.class).atualiza(laboratorio);
	}

	public List<Laboratorio> getTodosLaboratorios() {
		return new Dao<Laboratorio>(Laboratorio.class).buscaTodos();
	}

	public void remover(Laboratorio p) {
		new Dao<Laboratorio>(Laboratorio.class).remove(p.getId());
	}

	public List<TipoLab> getTodosTipos() {
		return new Dao<TipoLab>(TipoLab.class).buscaTodos();
	}

}

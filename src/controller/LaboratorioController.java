package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.Dao;
import modelo.Laboratorio;
import modelo.TipoLab;


@ManagedBean
@ViewScoped
public class LaboratorioController {
	private Laboratorio laboratorio = new Laboratorio();
	private Integer idTipoLab;
	
	

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

	public void gravar(){
		TipoLab t = new Dao<TipoLab>(TipoLab.class).buscaPorId(idTipoLab);
		laboratorio.setTipolab(t);
		if(laboratorio.getId()==null)
			new Dao<Laboratorio>(Laboratorio.class).adiciona(laboratorio);
		else
			new Dao<Laboratorio>(Laboratorio.class).atualiza(laboratorio);
	}
	
	public List<Laboratorio>getTodosLaboratorios(){
		return new Dao<Laboratorio>(Laboratorio.class).buscaTodos();
	}
	
	public void remover(Laboratorio p){
		new Dao<Laboratorio>(Laboratorio.class).remove(p.getId());
	}
	
	public void carregar(Laboratorio p){
		idTipoLab=p.getTipolab().getId();
		laboratorio= p;
	}
	
	public List<TipoLab> getTodosTipos(){
		return new Dao<TipoLab>(TipoLab.class).buscaTodos();
	}

}

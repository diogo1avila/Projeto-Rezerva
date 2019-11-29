package controller;

import java.util.List;


import javax.faces.bean.ViewScoped;

import DAO.Dao;
import modelo.AvaliacaoLab;
import modelo.Laboratorio;
import modelo.Pessoa;

@javax.faces.bean.ManagedBean
@ViewScoped
public class AvaliacaoLabController {
	private AvaliacaoLab AvaliacaoLab = new AvaliacaoLab();
	private Integer idPessoa, idLaboratorio;

	public AvaliacaoLab getAvaliacaoLab() {
		return AvaliacaoLab;
	}

	public void setAvaliacaoLab(AvaliacaoLab avaliacaoLab) {
		AvaliacaoLab = avaliacaoLab;
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

	public void setIdLaboratorio(Integer idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}

	public void gravar() {
		Pessoa p = new Dao<Pessoa>(Pessoa.class).buscaPorId(idPessoa);
		AvaliacaoLab.setPessoa(p);
		Laboratorio l = new Dao<Laboratorio>(Laboratorio.class).buscaPorId(idLaboratorio);
		AvaliacaoLab.setLaboratorio(l);
		if (AvaliacaoLab.getId() == null)
			new Dao<AvaliacaoLab>(AvaliacaoLab.class).adiciona(AvaliacaoLab);
		else
			new Dao<AvaliacaoLab>(AvaliacaoLab.class).atualiza(AvaliacaoLab);
	}

	public List<AvaliacaoLab> getTodosAvaliacaoLabs() {
		return new Dao<AvaliacaoLab>(AvaliacaoLab.class).buscaTodos();
	}

	public void remover(AvaliacaoLab p) {
		new Dao<AvaliacaoLab>(AvaliacaoLab.class).remove(p.getId());
	}

	public void carregar(AvaliacaoLab p) {
		idPessoa = p.getPessoa().getId();
		idLaboratorio = p.getLaboratorio().getId();
		AvaliacaoLab = p;
	}

	public List<Pessoa> getTodosPessoa() {
		return new Dao<Pessoa>(Pessoa.class).buscaTodos();
	}

	public List<Laboratorio> getTodosLaboratorio() {
		return new Dao<Laboratorio>(Laboratorio.class).buscaTodos();
	}

}

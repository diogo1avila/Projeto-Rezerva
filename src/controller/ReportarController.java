package controller;

import java.util.List;


import javax.faces.bean.ViewScoped;

import DAO.Dao;
import modelo.Laboratorio;
import modelo.Pessoa;
import modelo.Reportar;

@javax.faces.bean.ManagedBean
@ViewScoped
public class ReportarController {
	private Reportar reportar = new Reportar();
	private Integer idPessoa, idLaboratorio;

	public Reportar getReportar() {
		return reportar;
	}

	public void setReportar(Reportar reportar) {
		this.reportar = reportar;
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
		reportar.setPessoa(p);
		Laboratorio l = new Dao<Laboratorio>(Laboratorio.class).buscaPorId(idLaboratorio);
		reportar.setLaboratorio(l);
		if (reportar.getId() == null)
			new Dao<Reportar>(Reportar.class).adiciona(reportar);
		else
			new Dao<Reportar>(Reportar.class).atualiza(reportar);
	}

	public List<Reportar> getTodosReportars() {
		return new Dao<Reportar>(Reportar.class).buscaTodos();
	}

	public void remover(Reportar p) {
		new Dao<Reportar>(Reportar.class).remove(p.getId());
	}

	public void carregar(Reportar p) {
		idPessoa = p.getPessoa().getId();
		idLaboratorio = p.getLaboratorio().getId();
		reportar = p;
	}

	public List<Pessoa> getTodosPessoa() {
		return new Dao<Pessoa>(Pessoa.class).buscaTodos();
	}

	public List<Laboratorio> getTodosLaboratorio() {
		return new Dao<Laboratorio>(Laboratorio.class).buscaTodos();
	}

}

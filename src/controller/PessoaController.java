package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.Dao;
import modelo.Pessoa;

import modelo.TipoPessoa;


@ManagedBean
@ViewScoped
public class PessoaController {
	
	private Pessoa pessoa = new Pessoa();
	private Integer idTipoPessoa;
	
	public Integer getIdTipoPessoa() {
		return idTipoPessoa;
	}

	public void setIdTipoPessoa(Integer idTipoPessoa) {
		this.idTipoPessoa = idTipoPessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void gravar(){
		TipoPessoa t = new Dao<TipoPessoa>(TipoPessoa.class).buscaPorId(idTipoPessoa);
		pessoa.setTipopessoa(t);
		if(pessoa.getId()==null)
			new Dao<Pessoa>(Pessoa.class).adiciona(pessoa);
		else
			new Dao<Pessoa>(Pessoa.class).atualiza(pessoa);
	}
	
	public List<Pessoa>getTodosPessoas(){
		return new Dao<Pessoa>(Pessoa.class).buscaTodos();
	}
	
	public void remover(Pessoa p){
		new Dao<Pessoa>(Pessoa.class).remove(p.getId());
	}
	
	public void carregar(Pessoa p){
		idTipoPessoa=p.getTipopessoa().getId();
		pessoa= p;
	}
	
	public List<TipoPessoa> getTodosTipos(){
		return new Dao<TipoPessoa>(TipoPessoa.class).buscaTodos();
	}

}

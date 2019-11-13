package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.Dao;
import modelo.TipoPessoa;


@ManagedBean
@ViewScoped
public class TipoPessoaController {
	private TipoPessoa tipopessoa = new TipoPessoa();

	public TipoPessoa getTipoPessoa() {
		return tipopessoa;
	}

	public void setTipoPessoa(TipoPessoa tipopessoa) {
		this.tipopessoa = tipopessoa;
	}
	
	
	public void gravar(){
		if(tipopessoa.getId()== null)
			new Dao<TipoPessoa>(TipoPessoa.class).adiciona(tipopessoa);
		else
			new Dao<TipoPessoa>(TipoPessoa.class).atualiza(tipopessoa);
	}
	
	
	public List<TipoPessoa>getTodosTipos(){
		return new Dao<TipoPessoa>(TipoPessoa.class).buscaTodos();
	}
	
	public void remover(TipoPessoa p){
		new Dao<TipoPessoa>(TipoPessoa.class).remove(p.getId());
	}
	
	public void carregar(TipoPessoa t){
		tipopessoa= t;
	}

}

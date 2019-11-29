package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.Dao;
import modelo.TipoLab;

@ManagedBean
@ViewScoped
public class TipoLabController {

	private TipoLab tipolab = new TipoLab();

	public TipoLab getTipoLab() {
		return tipolab;
	}

	public void setTipoLab(TipoLab tipolab) {
		this.tipolab = tipolab;
	}

	public void gravar() {
		if (tipolab.getId() == null)
			new Dao<TipoLab>(TipoLab.class).adiciona(tipolab);
		else
			new Dao<TipoLab>(TipoLab.class).atualiza(tipolab);
	}

	public List<TipoLab> getTodosTipos() {
		return new Dao<TipoLab>(TipoLab.class).buscaTodos();
	}

	public void remover(TipoLab p) {
		new Dao<TipoLab>(TipoLab.class).remove(p.getId());
	}

	public void carregar(TipoLab t) {
		tipolab = t;
	}

}

package br.fepi.tcc.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.fepi.tcc.model.Usuario;
import br.fepi.tcc.negocio.CadastroUsuario;
import br.fepi.tcc.repositorio.Usuarios;
import br.fepi.tcc.util.DataSource;

@ManagedBean
@ViewScoped
public class CadastroUsuariosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	public void prepararCadastro() {
		if (this.usuario == null) {
			this.usuario = new Usuario();
		}
	}
	
	public void salvar(){
		
		EntityManager em = DataSource.getEntityManager();
		EntityTransaction et = em.getTransaction();
		FacesContext faces = FacesContext.getCurrentInstance();
		
		try {
			et.begin();
			CadastroUsuario cadastro = new CadastroUsuario(new Usuarios(em));
			cadastro.salvar(usuario);
			this.usuario = new Usuario();
			faces.addMessage(null, new FacesMessage("Salvo com sucesso."));
			et.commit();
		} finally{
			em.close();
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}

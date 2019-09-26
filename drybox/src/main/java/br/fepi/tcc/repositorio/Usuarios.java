package br.fepi.tcc.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.fepi.tcc.model.Usuario;

public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;
	
private EntityManager em;
	
	public Usuarios(EntityManager em) {
		this.em = em;
	}
	
	public Usuario usuarioId(Long id) {
		return em.find(Usuario.class, id);
	}
	
	public List<Usuario> todos(){
		TypedQuery<Usuario> query = em.createQuery("from Usuario u order by u.id", Usuario.class);
		return 	query.getResultList();
	}
	
	public void adicionar (Usuario usuario) {
		this.em.persist(usuario);
	}
	
	/**
	 * Faz o insert ou update
	 * @param usuario
	 */
	public void guardar (Usuario usuario) {
		this.em.merge(usuario);
	}
	
	/**
	 * Remove usuario
	 * @param usuario
	 */
	public void remover(Usuario usuario) {
		this.em.remove(usuario);
	}

}

package br.fepi.tcc.negocio;

import java.io.Serializable;

import br.fepi.tcc.model.Usuario;
import br.fepi.tcc.repositorio.Usuarios;

public class CadastroUsuario implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuarios usuarios;
	
	public CadastroUsuario(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	
	/**
	 * Método para salvar usuários
	 * @param usuario
	 */
	
	public void salvar(Usuario usuario) {
		this.usuarios.guardar(usuario);
	}
	
	/**
	 * Método de exclusão de usuários
	 * @param usuario
	 */
	
	public void excluir (Usuario usuario) {
		usuario = this.usuarios.usuarioId(usuario.getId());
		this.usuarios.remover(usuario);
	}

}

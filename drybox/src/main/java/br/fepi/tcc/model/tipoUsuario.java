package br.fepi.tcc.model;

import java.io.Serializable;

public enum tipoUsuario implements Serializable {
	ADMINISTRADOR("Administrador"), COMUM("Comum");
	
private String tipo;
	
	tipoUsuario(String tipo)
	{
		this.tipo = tipo;
	}
	
	public String getTipo()
	{
		return tipo;
	}
}

package com.umbrella.enums;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public enum CategoriaEnum {

	HATCH(1, "hatch"), SEDAN(2, "sedan"), MINIVAN(3, "minivan"), ESPORTIVO(4, "esportivo"), UTILITARIO(5, "utilitario");

	@Enumerated(EnumType.ORDINAL)
	public int id;
	public String descricao;

	private CategoriaEnum(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

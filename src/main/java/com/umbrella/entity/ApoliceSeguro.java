package com.umbrella.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApoliceSeguro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	@Column
	private Double valorFranquia;
	@Column
	private Boolean protecaoTerceiro;
	@Column
	private Boolean protecaoCausasNaturais;
	@Column
	private Boolean protecaoRoubo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Double getValorFranquia() {
		return valorFranquia;
	}

	public void setValorFranquia(Double valorFranquia) {
		this.valorFranquia = valorFranquia;
	}

	public Boolean getProtecaoTerceiro() {
		return protecaoTerceiro;
	}

	public void setProtecaoTerceiro(Boolean protecaoTerceiro) {
		this.protecaoTerceiro = protecaoTerceiro;
	}

	public Boolean getProtecaoCausasNaturais() {
		return protecaoCausasNaturais;
	}

	public void setProtecaoCausasNaturais(Boolean protecaoCausasNaturais) {
		this.protecaoCausasNaturais = protecaoCausasNaturais;
	}

	public Boolean getProtecaoRoubo() {
		return protecaoRoubo;
	}

	public void setProtecaoRoubo(Boolean protecaoRoubo) {
		this.protecaoRoubo = protecaoRoubo;
	}

}

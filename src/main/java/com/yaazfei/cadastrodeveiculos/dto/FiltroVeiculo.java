package com.yaazfei.cadastrodeveiculos.dto;

public class FiltroVeiculo {
	
	private String veiculo;
	private String marca; 
	private Integer ano;
	private Boolean vendido;
	


	public FiltroVeiculo(String veiculo, String marca, Integer ano, Boolean vendido) {
		this.veiculo = veiculo;
		this.marca = marca;
		this.ano = ano;
		this.vendido = vendido;
	}


	public String getVeiculo() {
		return veiculo;
	}


	public String getMarca() {
		return marca;
	}


	public Integer getAno() {
		return ano;
	}


	public Boolean getVendido() {
		return vendido;
	}

	@Override
	public String toString() {
		return "FiltroVeiculo [veiculo=" + veiculo + ", marca=" + marca + ", ano=" + ano + ", vendido=" + vendido + "]";
	}
	
	
}

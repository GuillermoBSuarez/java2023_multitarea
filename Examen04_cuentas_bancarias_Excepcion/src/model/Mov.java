package model;

import java.time.LocalDateTime;

public class Mov {
	private Double cantidad;
	private LocalDateTime fechaHora;
	private String tipoMov;
	
	public Mov(Double cantidad, LocalDateTime fechaHora, String tipoMov) {
		super();
		this.cantidad = cantidad;
		this.fechaHora = fechaHora;
		this.tipoMov = tipoMov;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getTipoMov() {
		return tipoMov;
	}
	public void setTipoMov(String tipoMov) {
		this.tipoMov = tipoMov;
	}
}

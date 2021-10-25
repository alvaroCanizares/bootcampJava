package es.curso.modelo.entidades;

import java.sql.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class Pedido {
	private int id;
	private double importe;
	private String fecha;
	
	public Pedido() {
		super();
	}
	
	public Pedido(int id, double importe, String fecha) {
		super();
		this.id = id;
		this.importe = importe;
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", importe=" + importe + ", fecha=" + fecha + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}

package br.com.secretary.itceap.beans;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="tb_predioS")
public class PredioS {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="id")
	private long id;
	@Column(name ="Predio" , nullable=false, length=50)
	private String predio;
	@Column(name ="Quantidade" , nullable=false, length=300)
	private int quantidade;
	@Column(name="Status")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar status;
	
	public Calendar getStatus() {
		return status;
	}
	public void setStatus(Calendar status) {
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getPredio() {
		return predio;
	}
	public void setPredio(String predio) {
		this.predio = predio;
	}
}

package br.com.alura.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.alura.mvc.mudi.model.Oferta;

public class RequisicaoOfertaDto {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");	
	private Long pedidoId;
	
	@NotNull(message = "O campo valor é obrigatório!")
	@Pattern(regexp = "^\\d+(\\.\\d{2})?$", message = "O campo valor deve estar no formato 123.00!")
	private String valor;
	
	@NotNull(message = "O campo data da entrega é obrigatório!")
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "O campo data da entrega deve estar no formato dd/MM/aaaa!")
	private String dataDaEntrega;
	private String comentario;

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDataDaEntrega() {
		return dataDaEntrega;
	}

	public void setDataDaEntrega(String dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public Oferta toOferta() {
		Oferta oferta = new Oferta();
		oferta.setId(this.pedidoId);
		oferta.setValor(new BigDecimal(this.valor));
		oferta.setDataDaEntrega(LocalDate.parse(this.dataDaEntrega, formatter));
		oferta.setComentario(this.comentario);
		return oferta;
	}
}

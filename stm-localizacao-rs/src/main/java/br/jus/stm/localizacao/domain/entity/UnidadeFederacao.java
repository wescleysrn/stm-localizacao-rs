package br.jus.stm.localizacao.domain.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "tb_uf")
@EqualsAndHashCode
public class UnidadeFederacao implements Serializable {

	@Id
	@Column(name = "codigo_ibge", length = 2)
	private String codigoIBGE;

	@Column(length = 2)
	private String sigla;

	@Column(name = "nome", length = 40)
	private String nome;

	@Column(name = "id_sei")
	private Long idSei;

	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "regiao_fkc"), name = "regiao_fk")
	@OrderBy("ix_tb_uf_regiao_fk")
	private Regiao regiao;

}

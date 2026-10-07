package br.jus.stm.localizacao.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "tb_municipio")
@EqualsAndHashCode
public class Municipio implements Serializable {

	@Id
	@Column(name = "codigo_ibge_completo", length = 7)
	private String codigoIBGECompleto;

	@Column(name = "codigo_ibge", length = 5)
	private String codigoIBGE;

	@Column(name = "nome", length = 200)
	private String nome;

	@Column(name = "id_sei")
	private Long idSei;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "micro_regiao_fkc"), name = "micro_regiao_fk")
	private MicroRegiao microRegiao;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "uf_fkc"), name = "uf_fk")
	private UnidadeFederacao uf;

}

package br.jus.stm.localizacao.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "tb_regiao")
@EqualsAndHashCode
@Getter
@Setter
public class Regiao implements Serializable {

	@Id
	@Column(name = "sigla", length = 2)
	private String sigla;

	@Column(name = "nome", length = 50)
	private String nome;

}

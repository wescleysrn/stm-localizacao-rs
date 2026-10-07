package br.jus.stm.localizacao.domain.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "tb_micro_regiao")
@EqualsAndHashCode
public class MicroRegiao implements Serializable {

	@Id
	@Column(name = "codigo_ibge_completo", length = 5)
	private String codigoIBGECompleto;

	@Column(name = "codigo_ibge", length = 3)
	private String codigoIBGE;

	@Column(name = "nome", length = 100)
	private String nome;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "meso_regiao_fkc"), name = "meso_regiao_fk")
	private MesoRegiao mesoRegiao;

}

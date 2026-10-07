package br.jus.stm.localizacao.domain.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "tb_sub_distrito")
@EqualsAndHashCode
public class SubDistrito implements Serializable {

	@Id
	@Column(name = "codigo_ibge_completo", length = 11)
	private String codigoIBGECompleto;

	@Column(name = "codigo_ibge", length = 2)
	private String codigoIBGE;

	@Column(name = "nome", length = 150)
	private String nome;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "distrito_fkc"), name = "distrito_fk")
	private Distrito distrito;

}

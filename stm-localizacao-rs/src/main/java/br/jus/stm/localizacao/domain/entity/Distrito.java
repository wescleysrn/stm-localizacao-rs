package br.jus.stm.localizacao.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "tb_distrito")
public class Distrito implements Serializable {

	@Id
	@Column(name = "codigo_ibge_completo", length = 9)
	private String codigoIBGECompleto;

	@Column(name = "codigo_ibge", length = 2)
	private String codigoIBGE;

	@Column(name = "nome", length = 150)
	private String nome;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "municipio_fkc"), name = "municipio_fk")
	private Municipio municipio;

	@OneToMany(mappedBy = "distrito", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@Fetch(FetchMode.SUBSELECT)
	private List<SubDistrito> subDistritos;

}

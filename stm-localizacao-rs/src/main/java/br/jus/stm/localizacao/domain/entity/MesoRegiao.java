package br.jus.stm.localizacao.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "tb_meso_regiao")
@EqualsAndHashCode
@Getter
@Setter
public class MesoRegiao implements Serializable {

	@Id
	@Column(name = "codigo_ibge_completo", length = 4)
	private String codigoIBGECompleto;

	@Column(name = "codigo_ibge", length = 2)
	private String codigoIBGE;

	@Column(name = "nome", length = 100)
	private String nome;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "uf_fkc"), name = "uf_fk")
	private UnidadeFederacao uf;

	@JsonIgnore
	@OneToMany(mappedBy = "mesoRegiao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Fetch(FetchMode.SUBSELECT)
	private Set<MicroRegiao> microRegiaos;

}

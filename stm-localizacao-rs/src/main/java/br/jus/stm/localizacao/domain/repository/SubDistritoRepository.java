package br.jus.stm.localizacao.domain.repository;

import br.jus.stm.localizacao.domain.entity.SubDistrito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubDistritoRepository extends JpaRepository<SubDistrito, Long> {

	SubDistrito findByCodigoIBGECompleto(String codigoIBGE);
	
	List<SubDistrito> findByDistritoCodigoIBGECompleto(String codigoIBGE);
	
	List<SubDistrito> findByDistritoMunicipioCodigoIBGECompleto(String codigoIBGE);

}

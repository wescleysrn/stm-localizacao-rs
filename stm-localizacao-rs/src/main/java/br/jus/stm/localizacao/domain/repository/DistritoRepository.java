package br.jus.stm.localizacao.domain.repository;

import br.jus.stm.localizacao.domain.entity.Distrito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistritoRepository extends JpaRepository<Distrito, Long> {

	Distrito findByCodigoIBGECompleto(String codigoIBGE);
	
	List<Distrito> findByMunicipioCodigoIBGECompleto(String codigoIBGE);
	
}

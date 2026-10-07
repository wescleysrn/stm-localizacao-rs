package br.jus.stm.localizacao.mapper;

import br.jus.stm.common.localizacao.dto.MunicipioDTO;
import br.jus.stm.localizacao.domain.entity.Municipio;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@AnnotateWith( value = Component.class, elements = @AnnotateWith.Element( strings = "MunicipioMapper" ) )
public interface MunicipioMapper {

    @Mapping(target = "microRegiao", ignore = true)
    @Mapping(target = "uf", ignore = true)
    Municipio toEntity(MunicipioDTO dto);

    @Mapping(target = "microRegiao", ignore = true)
    @Mapping(target = "uf", ignore = true)
    MunicipioDTO toDTO(Municipio entity);

    @Mapping(target = "microRegiao", ignore = true)
    @Mapping(target = "uf", ignore = true)
    List<Municipio> toList(List<MunicipioDTO> list);

    @Mapping(target = "microRegiao", ignore = true)
    @Mapping(target = "uf", ignore = true)
    List<MunicipioDTO> toDTOList(List<Municipio> list);

}

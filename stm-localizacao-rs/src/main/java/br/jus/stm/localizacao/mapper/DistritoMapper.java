package br.jus.stm.localizacao.mapper;

import br.jus.stm.common.localizacao.dto.DistritoDTO;
import br.jus.stm.localizacao.domain.entity.Distrito;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@AnnotateWith( value = Component.class, elements = @AnnotateWith.Element( strings = "DistritoMapper" ) )
public interface DistritoMapper {

    @Mapping(target = "municipio", ignore = true)
    @Mapping(target = "subDistritos", ignore = true)
    Distrito toEntity(DistritoDTO dto);

    @Mapping(target = "municipio", ignore = true)
    @Mapping(target = "subDistritos", ignore = true)
    DistritoDTO toDTO(Distrito entity);

    @Mapping(target = "municipio", ignore = true)
    @Mapping(target = "subDistritos", ignore = true)
    List<Distrito> toList(List<DistritoDTO> list);

    @Mapping(target = "municipio", ignore = true)
    @Mapping(target = "subDistritos", ignore = true)
    List<DistritoDTO> toDTOList(List<Distrito> list);

}

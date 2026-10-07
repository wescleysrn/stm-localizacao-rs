package br.jus.stm.localizacao.mapper;

import br.jus.stm.common.localizacao.dto.SubDistritoDTO;
import br.jus.stm.localizacao.domain.entity.SubDistrito;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@AnnotateWith( value = Component.class, elements = @AnnotateWith.Element( strings = "SubDistritoMapper" ) )
public interface SubDistritoMapper {

    @Mapping(target = "distrito", ignore = true)
    SubDistrito toEntity(SubDistritoDTO dto);

    @Mapping(target = "distrito", ignore = true)
    SubDistritoDTO toDTO(SubDistrito entity);

    @Mapping(target = "distrito", ignore = true)
    List<SubDistrito> toList(List<SubDistritoDTO> list);

    @Mapping(target = "distrito", ignore = true)
    List<SubDistritoDTO> toDTOList(List<SubDistrito> list);

}

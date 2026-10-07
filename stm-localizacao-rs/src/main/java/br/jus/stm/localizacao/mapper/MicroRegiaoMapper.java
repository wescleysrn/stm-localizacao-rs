package br.jus.stm.localizacao.mapper;

import br.jus.stm.common.localizacao.dto.MicroRegiaoDTO;
import br.jus.stm.localizacao.domain.entity.MicroRegiao;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@AnnotateWith( value = Component.class, elements = @AnnotateWith.Element( strings = "MicroRegiaoMapper" ) )
public interface MicroRegiaoMapper {

    @Mapping(target = "mesoRegiao", ignore = true)
    MicroRegiao toEntity(MicroRegiaoDTO dto);

    @Mapping(target = "mesoRegiao", ignore = true)
    MicroRegiaoDTO toDTO(MicroRegiao entity);

    @Mapping(target = "mesoRegiao", ignore = true)
    List<MicroRegiao> toList(List<MicroRegiaoDTO> list);

    @Mapping(target = "mesoRegiao", ignore = true)
    List<MicroRegiaoDTO> toDTOList(List<MicroRegiao> list);

}

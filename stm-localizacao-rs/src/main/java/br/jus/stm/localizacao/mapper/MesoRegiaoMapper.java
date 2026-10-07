package br.jus.stm.localizacao.mapper;

import br.jus.stm.common.localizacao.dto.MesoRegiaoDTO;
import br.jus.stm.localizacao.domain.entity.MesoRegiao;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@AnnotateWith( value = Component.class, elements = @AnnotateWith.Element( strings = "MesoRegiaoMapper" ) )
public interface MesoRegiaoMapper {

    @Mapping(target = "microRegiaos", ignore = true)
    @Mapping(target = "uf", ignore = true)
    MesoRegiao toEntity(MesoRegiaoDTO dto);

    @Mapping(target = "microRegiaos", ignore = true)
    @Mapping(target = "uf", ignore = true)
    MesoRegiaoDTO toDTO(MesoRegiao entity);

    @Mapping(target = "microRegiaos", ignore = true)
    @Mapping(target = "uf", ignore = true)
    List<MesoRegiao> toList(List<MesoRegiaoDTO> list);

    @Mapping(target = "microRegiaos", ignore = true)
    @Mapping(target = "uf", ignore = true)
    List<MesoRegiaoDTO> toDTOList(List<MesoRegiao> list);

}

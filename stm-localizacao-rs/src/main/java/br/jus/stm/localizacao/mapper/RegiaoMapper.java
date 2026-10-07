package br.jus.stm.localizacao.mapper;

import br.jus.stm.common.localizacao.dto.RegiaoDTO;
import br.jus.stm.localizacao.domain.entity.Regiao;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@AnnotateWith( value = Component.class, elements = @AnnotateWith.Element( strings = "RegiaoMapper" ) )
public interface RegiaoMapper {

    Regiao toEntity(RegiaoDTO dto);

    RegiaoDTO toDTO(Regiao entity);

    List<Regiao> toList(List<RegiaoDTO> list);

    List<RegiaoDTO> toDTOList(List<Regiao> list);

}

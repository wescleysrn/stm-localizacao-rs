package br.jus.stm.localizacao.mapper;

import br.jus.stm.common.localizacao.dto.UnidadeFederacaoDTO;
import br.jus.stm.localizacao.domain.entity.UnidadeFederacao;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@AnnotateWith( value = Component.class, elements = @AnnotateWith.Element( strings = "UnidadeFederacaoMapper" ) )
public interface UnidadeFederacaoMapper {

    @Mapping(target = "regiao", ignore = true)
    UnidadeFederacao toEntity(UnidadeFederacaoDTO dto);

    @Mapping(target = "regiao", ignore = true)
    UnidadeFederacaoDTO toDTO(UnidadeFederacao entity);

    @Mapping(target = "regiao", ignore = true)
    List<UnidadeFederacao> toList(List<UnidadeFederacaoDTO> list);

    @Mapping(target = "regiao", ignore = true)
    List<UnidadeFederacaoDTO> toDTOList(List<UnidadeFederacao> list);

}

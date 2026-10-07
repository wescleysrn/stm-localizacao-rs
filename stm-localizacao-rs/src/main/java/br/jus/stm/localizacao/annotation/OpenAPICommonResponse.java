package br.jus.stm.localizacao.annotation;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ApiResponses({
    @ApiResponse(responseCode = "204",  description = "Não foi encontrado registros para os parametros informados.", content = @Content),
    @ApiResponse(responseCode = "400",  description = "Parâmetros inválido.", content = @Content),
    @ApiResponse(responseCode = "500",  description = "Ocorreu um erro interno ao consumir o serviço.", content = @Content)
})
public @interface OpenAPICommonResponse {

}

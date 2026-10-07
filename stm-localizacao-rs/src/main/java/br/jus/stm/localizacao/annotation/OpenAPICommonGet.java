package br.jus.stm.localizacao.annotation;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation
@OpenAPICommonResponse
public @interface OpenAPICommonGet {

    @AliasFor(annotation = Operation.class, attribute = "summary")
    String summary() default "";

}

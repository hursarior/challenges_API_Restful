package com.Restful.Challenges.Api.Modelos;

import jakarta.validation.constraints.NotBlank;

public record DtoTopico(

    @NotBlank
    String titulo, 

    @NotBlank
    String mensaje, 

    @NotBlank
    String estatus_tpc,

    @NotBlank
    String autor,
    
    @NotBlank
    String curso
){

    



}

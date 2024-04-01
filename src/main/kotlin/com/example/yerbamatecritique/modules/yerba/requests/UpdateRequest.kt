package com.example.yerbamatecritique.modules.yerba.requests

import jakarta.validation.constraints.NotBlank

data class UpdateRequest(
    @field:NotBlank
    val name: String,

    @field:NotBlank
    val producer: String,

    @field:NotBlank
    val flavour: String,
)
package com.example.yerbamatecritique.modules.yerba.application

import com.example.yerbamatecritique.modules.yerba.domain.Yerba
import jakarta.validation.constraints.NotBlank

data class YerbaDto(
    @field:NotBlank
    val name: String,

    @field:NotBlank()
    val producer: String,

    @field:NotBlank
    val flavour: String,
) {
    fun toYerba(id: String? = null) = Yerba(id, name, producer, flavour)
}
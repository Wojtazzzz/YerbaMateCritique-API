package com.example.yerbamatecritique.modules.yerba

import jakarta.validation.constraints.NotBlank
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("YERBA")
data class Yerba(
    @Id
    var id: String?,

    @field:NotBlank
    val name: String,

    @field:NotBlank
    val producer: String,

    @field:NotBlank
    val flavour: String,
)

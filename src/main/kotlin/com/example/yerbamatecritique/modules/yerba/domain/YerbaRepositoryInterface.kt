package com.example.yerbamatecritique.modules.yerba.domain

import java.util.*

interface YerbaRepositoryInterface {
    fun findById(id: String): Optional<Yerba>

    fun getAll(): Iterable<Yerba>

    fun add(yerba: Yerba)

    fun edit(yerba: Yerba)

    fun deleteById(id: String)

    fun existsById(id: String): Boolean
}
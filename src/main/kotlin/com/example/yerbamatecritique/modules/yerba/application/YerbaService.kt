package com.example.yerbamatecritique.modules.yerba.application

import com.example.yerbamatecritique.modules.yerba.application.exceptions.YerbaNotFound
import com.example.yerbamatecritique.modules.yerba.domain.Yerba
import com.example.yerbamatecritique.modules.yerba.infrastructure.H2YerbaRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class YerbaService(
    private val repository: H2YerbaRepository
) {
    fun findAll() = repository.getAll().toList()

    fun findById(id: String): Yerba {
        val yerba = repository.findById(id).getOrNull()

        if (yerba === null) {
            throw YerbaNotFound()
        }

        return yerba
    }

    fun add(data: YerbaDto) = repository.add(data.toYerba())

    fun edit(id: String, data: YerbaDto) {
        if (!repository.existsById(id)) {
            throw YerbaNotFound()
        }

        repository.edit(data.toYerba(id))
    }

    fun deleteById(id: String) {
        if (!repository.existsById(id)) {
            throw YerbaNotFound()
        }

        repository.deleteById(id)
    }
}

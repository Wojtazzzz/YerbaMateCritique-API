package com.example.yerbamatecritique.modules.yerba

import com.example.yerbamatecritique.exceptions.YerbaNotFound
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class YerbaService(val db: YerbaRepository) {
    fun findAll() = db.findAll().toList()

    fun findById(id: String): Yerba {
        val yerba = db.findById(id).getOrNull()

        if (yerba === null) {
            throw YerbaNotFound("Yerba not found.")
        }

        return yerba
    }

    fun add(yerba: Yerba) {
        db.save(yerba)
    }

    fun edit(yerba: Yerba) {
        if (!this.existsById(yerba.id)) {
            throw YerbaNotFound("Yerba not found.")
        }

        db.save(yerba)
    }

    fun deleteById(id: String) {
        if (!this.existsById(id)) {
            throw YerbaNotFound("Yerba not found.")
        }

        db.deleteById(id)
    }

    fun existsById(id: String?): Boolean {
        if (id !is String || id.isEmpty()) {
            return false
        }

        return db.existsById(id)
    }

}
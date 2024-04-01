package com.example.yerbamatecritique.modules.yerba

import com.example.yerbamatecritique.exceptions.YerbaNotFound
import org.springframework.stereotype.Service

@Service
class YerbaService(val db: YerbaRepository) {
    fun findAll() = db.findAll().toList()

    fun add(yerba: Yerba) {
        db.save(yerba)
    }

    fun edit(yerba: Yerba) {
        if (!this.existsById(yerba.id)) {
            throw YerbaNotFound("Yerba not found.")
        }

        db.save(yerba)
    }

    fun existsById(id: String?): Boolean {
        if (id !is String || id.isEmpty()) {
            return false
        }

        return db.existsById(id)
    }

}
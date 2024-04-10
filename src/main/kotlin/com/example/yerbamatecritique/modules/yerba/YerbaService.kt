package com.example.yerbamatecritique.modules.yerba

import com.example.yerbamatecritique.exceptions.YerbaNotFound
import com.example.yerbamatecritique.modules.yerba.requests.StoreRequest
import com.example.yerbamatecritique.modules.yerba.requests.UpdateRequest
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

    fun add(data: StoreRequest) {
        db.save(Yerba(null, data.name, data.producer, data.flavour))
    }

    fun edit(id: String, data: UpdateRequest) {
        if (db.existsById(id)) {
            throw YerbaNotFound("Yerba not found.")
        }

        db.save(Yerba(id, data.name, data.producer, data.flavour))
    }

    fun deleteById(id: String) {
        if (!db.existsById(id)) {
            throw YerbaNotFound("Yerba not found.")
        }

        db.deleteById(id)
    }
}
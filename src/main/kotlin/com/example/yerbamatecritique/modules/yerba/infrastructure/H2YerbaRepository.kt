package com.example.yerbamatecritique.modules.yerba.infrastructure

import com.example.yerbamatecritique.modules.yerba.domain.Yerba
import com.example.yerbamatecritique.modules.yerba.domain.YerbaRepositoryInterface
import org.springframework.stereotype.Repository

@Repository
class H2YerbaRepository(private val db: H2YerbaRepositoryInterface) : YerbaRepositoryInterface {
    override fun findById(id: String) = db.findById(id)

    override fun getAll(): Iterable<Yerba> = db.findAll()
    override fun add(yerba: Yerba) {
        db.save(yerba)
    }

    override fun edit(yerba: Yerba) {
        db.save(yerba)
    }

    override fun deleteById(id: String) {
        db.deleteById(id)
    }

    override fun existsById(id: String) = db.existsById(id)
}
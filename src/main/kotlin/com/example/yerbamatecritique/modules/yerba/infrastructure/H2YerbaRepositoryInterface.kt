package com.example.yerbamatecritique.modules.yerba.infrastructure

import com.example.yerbamatecritique.modules.yerba.domain.Yerba
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface H2YerbaRepositoryInterface : CrudRepository<Yerba, String>
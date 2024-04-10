package com.example.yerbamatecritique.modules.yerba.infrastructure

import com.example.yerbamatecritique.modules.yerba.application.YerbaDto
import com.example.yerbamatecritique.modules.yerba.application.YerbaService
import com.example.yerbamatecritique.modules.yerba.domain.Yerba
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/yerba")
class YerbaController(private val service: YerbaService) {
    @GetMapping
    fun index(): ResponseEntity<List<Yerba>> {
        return ResponseEntity.ok(service.findAll())
    }

    @GetMapping("/{id}")
    fun show(@PathVariable id: String): ResponseEntity<Yerba> {
        return ResponseEntity.ok(service.findById(id))
    }

    @PostMapping
    fun store(@Valid @RequestBody body: YerbaDto): ResponseEntity<Unit> {
        return ResponseEntity.ok(service.add(body))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @Valid @RequestBody body: YerbaDto): ResponseEntity<Unit> {
        return ResponseEntity.ok(service.edit(id, body))
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Unit> {
        return ResponseEntity.ok(service.deleteById(id))
    }
}
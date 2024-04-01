package com.example.yerbamatecritique.modules.yerba

import com.example.yerbamatecritique.modules.yerba.requests.StoreRequest
import com.example.yerbamatecritique.modules.yerba.requests.UpdateRequest
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/yerba")
class YerbaController(val service: YerbaService) {
    @GetMapping
    fun index() = service.findAll()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun store(@Valid @RequestBody request: StoreRequest) {
        service.add(Yerba(null, request.name, request.producer, request.flavour))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @Valid @RequestBody request: UpdateRequest) {
        service.edit(Yerba(id, request.name, request.producer, request.flavour))
    }
}
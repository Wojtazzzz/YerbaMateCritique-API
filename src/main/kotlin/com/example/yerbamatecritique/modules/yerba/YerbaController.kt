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

    @GetMapping("/{id}")
    fun show(@PathVariable id: String) = service.findById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun store(@Valid @RequestBody body: StoreRequest) {
        service.add(body)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @Valid @RequestBody body: UpdateRequest) {
        service.edit(id, body)
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        service.deleteById(id)
    }
}
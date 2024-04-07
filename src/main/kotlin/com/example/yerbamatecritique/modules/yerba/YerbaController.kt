package com.example.yerbamatecritique.modules.yerba

import com.example.yerbamatecritique.modules.yerba.requests.StoreRequest
import com.example.yerbamatecritique.modules.yerba.requests.UpdateRequest
import com.example.yerbamatecritique.modules.yerba.responses.YerbaCreatedResponse
import com.example.yerbamatecritique.modules.yerba.responses.YerbaDeletedResponse
import com.example.yerbamatecritique.modules.yerba.responses.YerbaUpdatedResponse
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
    @ResponseStatus(HttpStatus.CREATED)
    fun store(@Valid @RequestBody request: StoreRequest): YerbaCreatedResponse {
        service.add(Yerba(null, request.name, request.producer, request.flavour))

        return YerbaCreatedResponse("ok")
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @Valid @RequestBody request: UpdateRequest): YerbaUpdatedResponse {
        service.edit(Yerba(id, request.name, request.producer, request.flavour))

        return YerbaUpdatedResponse("ok")
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: String): YerbaDeletedResponse {
        service.deleteById(id)

        return YerbaDeletedResponse("ok")
    }
}
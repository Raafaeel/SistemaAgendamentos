package br.agenda.sistemaagendamento.controller

import br.agenda.sistemaagendamento.service.UsuarioService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/usuarios")
class UsuarioController(val service: UsuarioService) {

    @GetMapping
    fun listar(): List<br.agenda.sistemaagendamento.DTO.UsuarioResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): br.agenda.sistemaagendamento.DTO.UsuarioResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid dto: br.agenda.sistemaagendamento.DTO.UsuarioDTO,
                  uriBuilder: UriComponentsBuilder
    ): ResponseEntity<br.agenda.sistemaagendamento.DTO.UsuarioResponseDTO> {
        val userResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/usuarios/${userResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(userResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: br.agenda.sistemaagendamento.DTO.UsuarioDTO
    ): br.agenda.sistemaagendamento.DTO.UsuarioResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}
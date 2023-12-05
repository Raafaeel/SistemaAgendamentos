package br.agenda.sistemaagendamento.controller

import br.agenda.sistemaagendamento.DTO.AgendamentoDTO
import br.agenda.sistemaagendamento.DTO.AgendamentoResponseDTO
import br.agenda.sistemaagendamento.service.AgendamentoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/Agendamento")
class AgendamentoController (val service: AgendamentoService) {
    @GetMapping
    fun listar(
            @RequestParam(required = false) nomeEvento: String?,
            @PageableDefault(size = 10) paginacao: Pageable)
            : Page<AgendamentoResponseDTO> {
        return service.listar(nomeEvento, paginacao)
    }


    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): AgendamentoResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastra (@RequestBody @Valid dto: AgendamentoDTO){
        service.cadastrar(dto)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long, @RequestBody @Valid dto: AgendamentoDTO) : AgendamentoResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }

}
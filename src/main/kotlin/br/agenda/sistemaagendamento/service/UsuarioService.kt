package br.agenda.sistemaagendamento.service

import br.agenda.sistemaagendamento.exceptions.NotFoundException
import br.agenda.sistemaagendamento.repository.UsuarioRepository
import org.springframework.stereotype.Service

private const val USUARIO_NOT_FOUND_MESSAGE = "Usuário não encontrado!"

@Service
class UsuarioService(
    private val repository: UsuarioRepository,
    private val converter: br.agenda.sistemaagendamento.converters.UsuarioConverter
) {
    fun listar(): List<br.agenda.sistemaagendamento.DTO.UsuarioResponseDTO> {
        return repository.findAll()
            .map(converter::toUsuarioResponseDTO)
    }

    fun buscarPorId(id: Long): br.agenda.sistemaagendamento.DTO.UsuarioResponseDTO {
        val usuario = repository.findById(id)
            .orElseThrow { NotFoundException(USUARIO_NOT_FOUND_MESSAGE) }
        return converter.toUsuarioResponseDTO(usuario)
    }

    fun cadastrar(dto: br.agenda.sistemaagendamento.DTO.UsuarioDTO): br.agenda.sistemaagendamento.DTO.UsuarioResponseDTO {
        return converter.toUsuarioResponseDTO(
            repository.save(converter.toUsuario(dto)))
    }

    fun atualizar(id: Long, dto: br.agenda.sistemaagendamento.DTO.UsuarioDTO): br.agenda.sistemaagendamento.DTO.UsuarioResponseDTO {
        val usuario = repository.findById(id)
            .orElseThrow { NotFoundException(USUARIO_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                cidade = dto.cidade,
                telefone = dto.telefone
            )
        return converter.toUsuarioResponseDTO(repository.save(usuario))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

}
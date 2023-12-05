package br.agenda.sistemaagendamento.converters


import br.agenda.sistemaagendamento.model.Usuario
import org.springframework.stereotype.Component

@Component
class UsuarioConverter {
    fun toUsuarioResponseDTO(usuario: Usuario): br.agenda.sistemaagendamento.DTO.UsuarioResponseDTO {
        return br.agenda.sistemaagendamento.DTO.UsuarioResponseDTO(
                id = usuario.id,
                nome = usuario.nome,
                cidade = usuario.cidade,
                telefone = usuario.telefone
        )
    }

    fun toUsuario(dto: br.agenda.sistemaagendamento.DTO.UsuarioDTO): Usuario {
        return Usuario(
            nome = dto.nome,
            cidade = dto.cidade,
            telefone = dto.telefone
        )
    }
}

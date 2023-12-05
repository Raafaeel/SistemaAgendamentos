package br.agenda.sistemaagendamento.repository


import br.agenda.sistemaagendamento.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Long> {
}

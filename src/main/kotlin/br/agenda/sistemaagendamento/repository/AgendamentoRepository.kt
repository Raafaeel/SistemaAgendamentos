package br.agenda.sistemaagendamento.repository


import br.agenda.sistemaagendamento.model.Agendamento
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AgendamentoRepository: JpaRepository<Agendamento, Long> {

    fun findByNome(nomeEvento: String, paginacao: Pageable): Page<Agendamento>
}
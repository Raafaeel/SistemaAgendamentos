package br.agenda.sistemaagendamento.repository


import br.agenda.sistemaagendamento.model.Servico
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ServicoRepository: JpaRepository<Servico, Long> {
}
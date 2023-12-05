package br.agenda.sistemaagendamento.DTO

import br.agenda.sistemaagendamento.model.Servico
import br.agenda.sistemaagendamento.model.StatusServico
import java.time.LocalDate
import java.time.LocalDateTime

data class AgendamentoResponseDTO(
        val id: Long?,
        val nome: String,
        val data: LocalDate,
        val dataInicioInsc: LocalDateTime,
        val dataFimInsc: LocalDateTime,
        val descricao: String,
        val status: StatusServico,
        val valor: Float,
        val agendados: List<Servico>
)


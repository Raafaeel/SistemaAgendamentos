package br.agenda.sistemaagendamento.converters

import br.agenda.sistemaagendamento.model.Agendamento
import org.springframework.stereotype.Component

@Component
class AgendamentoConverter {
    fun toAgendamento(dto: br.agenda.sistemaagendamento.DTO.AgendamentoDTO): Agendamento {
        return Agendamento(
                nome = dto.nome,
                data = dto.data,
                dataInicioServico =  dto.dataInicioInsc,
                dataFimServico = dto.dataFimInsc,
                descricao = dto.descricao,
                status = dto.status,
                valor = dto.valor
        )
    }
    fun toAgendaResponseDTO(agendamentos: Agendamento): br.agenda.sistemaagendamento.DTO.AgendamentoResponseDTO {
        return br.agenda.sistemaagendamento.DTO.AgendamentoResponseDTO(
                id = agendamentos.id,
                nome = agendamentos.nome,
                data = agendamentos.data,
                dataInicioInsc = agendamentos.dataInicioServico,
                dataFimInsc = agendamentos.dataFimServico,
                descricao = agendamentos.descricao,
                status = agendamentos.status,
                valor = agendamentos.valor,
                agendados = agendamentos.agendados
        )
    }
}
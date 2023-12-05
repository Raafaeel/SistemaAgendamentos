package br.agenda.sistemaagendamento.exceptions

import java.lang.RuntimeException

class NotFoundException (override val message: String) : RuntimeException()


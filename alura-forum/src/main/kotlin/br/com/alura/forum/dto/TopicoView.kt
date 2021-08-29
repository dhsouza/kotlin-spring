package br.com.alura.forum.dto

import br.com.alura.forum.model.StatusTopico
import br.com.alura.forum.model.Topico
import java.time.LocalDateTime

data class TopicoView(
    val id: Long? = null,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    val dataCriacao: LocalDateTime = LocalDateTime.now()
)


fun Topico.toTopicoView(): TopicoView {
    return with(this) {
        TopicoView(
            id = id,
            titulo = titulo,
            mensagem = mensagem,
            dataCriacao = dataCriacao,
            status = status
        )
    }
}
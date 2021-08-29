package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private var topicos: MutableList<Topico>
) {

    init {
        repeat(3) { index ->
            topicos.add(Topico(
                id = index.toLong(),
                titulo = "Dúvidas Kotlin $index",
                mensagem = "Variáveis no Kotlin $index",
                curso = Curso(
                    id = index.toLong(),
                    nome = "Kotlin $index",
                    categoria = "Programador $index"
                ),
                autor = Usuario(
                    id = index.toLong(),
                    nome = "Ana da Silva $index",
                    email = "ana@email.com $index"
                )
            ))
        }
    }

    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.first {
            it.id == id
        }
    }
}

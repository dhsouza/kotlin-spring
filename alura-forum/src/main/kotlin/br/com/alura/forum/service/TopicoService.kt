package br.com.alura.forum.service

import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.dto.toTopicoView
import br.com.alura.forum.mapper.NovoTopicoFormMapper
import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private val topicos: MutableList<Topico>,
    private val novoTopicoFormMapper: NovoTopicoFormMapper
) {

    init {
        repeat(3) { index ->
            topicos.add(
                Topico(
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
                )
            )
        }
    }

    fun listar(): List<TopicoView> {
        return topicos.map {
            it.toTopicoView()
        }
    }

    fun buscarPorId(id: Long): TopicoView {
        return topicos.map {
            it.toTopicoView()
        }.first {
            it.id == id
        }
    }

    fun cadastrar(form: NovoTopicoForm) {
        topicos.add(
            novoTopicoFormMapper.toTopico(topicos.size.toLong(), form)
        )
    }
}

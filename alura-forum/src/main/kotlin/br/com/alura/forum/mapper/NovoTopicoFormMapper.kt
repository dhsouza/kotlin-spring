package br.com.alura.forum.mapper

import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.model.Topico
import br.com.alura.forum.service.AutorService
import br.com.alura.forum.service.CursoService
import org.springframework.stereotype.Component

@Component
class NovoTopicoFormMapper(
    private val cursoService: CursoService,
    private val autorService: AutorService
) {

    fun toTopico(id: Long, topicoForm: NovoTopicoForm): Topico {
        return with(topicoForm) {
            Topico(
                id = id,
                titulo = titulo,
                mensagem = mensagem,
                curso = cursoService.buscaPorId(idCurso),
                autor = autorService.buscaPorId(idAutor),
            )
        }
    }
}
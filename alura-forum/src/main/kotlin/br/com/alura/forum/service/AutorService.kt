package br.com.alura.forum.service

import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class AutorService(var usuarios: List<Usuario>) {

    init {
        val usuario = Usuario(
            id = 1,
            nome = "João",
            email = "joao@email.com"
        )

        usuarios = listOf(usuario)
    }

    fun buscaPorId(id: Long): Usuario {
        return usuarios.first {
            it.id == id
        }
    }

}

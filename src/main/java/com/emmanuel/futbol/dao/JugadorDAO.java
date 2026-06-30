package com.emmanuel.futbol.dao;

import com.emmanuel.futbol.model.Jugador;
import java.util.List;
import java.util.Optional;

/**
*separa la logica de los de acceso a los datos
*/
public interface JugadorDAO {
    List<Jugador> buscarTodos();
    Optional<Jugador> buscarPorId(Long id);
    Jugador guardar(Jugador jugador);
    void eliminar(Long id);
}

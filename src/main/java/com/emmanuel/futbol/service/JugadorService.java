package com.emmanuel.futbol.service;

import com.emmanuel.futbol.dao.JugadorDAO;
import com.emmanuel.futbol.model.Jugador;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
*sirve para garantizar una unica instancia de esta clase
*para compartirla con quien la necesite
*para inyectar una sola instancia nada mas 
*/
@Service
public class JugadorService {

    private final JugadorDAO jugadorDAO;

    public JugadorService(JugadorDAO jugadorDAO) {
        this.jugadorDAO = jugadorDAO;
    }

    public List<Jugador> obtenerTodos() {
        return jugadorDAO.buscarTodos();
    }

    public Jugador crear(String nombre, String posicion, String equipo, Integer numero, Integer goles) {
        Jugador jugador = Jugador.builder()
                .nombre(nombre)
                .posicion(posicion)
                .equipo(equipo)
                .numero(numero)
                .goles(goles)
                .build();
        return jugadorDAO.guardar(jugador);
    }

    public Optional<Jugador> actualizar(Long id, String nombre, String posicion, String equipo, Integer numero, Integer goles) {
        return jugadorDAO.buscarPorId(id).map(j -> {
            j.setNombre(nombre);
            j.setPosicion(posicion);
            j.setEquipo(equipo);
            j.setNumero(numero);
            j.setGoles(goles);
            return jugadorDAO.guardar(j);
        });
    }

    public void eliminar(Long id) {
        jugadorDAO.eliminar(id);
    }
}

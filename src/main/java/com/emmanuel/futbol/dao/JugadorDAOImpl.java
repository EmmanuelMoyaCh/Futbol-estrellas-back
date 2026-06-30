package com.emmanuel.futbol.dao;

import com.emmanuel.futbol.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

interface JugadorJpaRepository extends JpaRepository<Jugador, Long> {}

/**
*implementa el dao antes establecido
*/
@Repository
public class JugadorDAOImpl implements JugadorDAO {

    private final JugadorJpaRepository jpaRepository;

    public JugadorDAOImpl(JugadorJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Jugador> buscarTodos() {
        return jpaRepository.findAll();
    }

    @Override
    public Optional<Jugador> buscarPorId(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Jugador guardar(Jugador jugador) {
        return jpaRepository.save(jugador);
    }

    @Override
    public void eliminar(Long id) {
        jpaRepository.deleteById(id);
    }
}

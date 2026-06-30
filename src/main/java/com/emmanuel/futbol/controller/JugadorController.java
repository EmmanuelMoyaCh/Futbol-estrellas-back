package com.emmanuel.futbol.controller;

import com.emmanuel.futbol.model.Jugador;
import com.emmanuel.futbol.service.JugadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
*hace que spring cree una unica instancia para atender
*a todas las peticiones que se realicen
*/
@RestController
@RequestMapping("/api/jugadores")
@CrossOrigin(originPatterns = "*")
public class JugadorController {

    private final JugadorService service;

    public JugadorController(JugadorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Jugador> obtenerTodos() {
        return service.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<Jugador> crear(@RequestBody Map<String, Object> body) {
        Jugador jugador = service.crear(
            (String) body.get("nombre"),
            (String) body.get("posicion"),
            (String) body.get("equipo"),
            (Integer) body.get("numero"),
            (Integer) body.get("goles")
        );
        return ResponseEntity.ok(jugador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> actualizar(@PathVariable Long id, @RequestBody Map<String, Object> body) {
        return service.actualizar(
            id,
            (String) body.get("nombre"),
            (String) body.get("posicion"),
            (String) body.get("equipo"),
            (Integer) body.get("numero"),
            (Integer) body.get("goles")
        ).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

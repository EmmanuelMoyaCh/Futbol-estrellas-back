package com.emmanuel.futbol.model;

import jakarta.persistence.*;

@Entity
@Table(name = "jugadores")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String posicion;
    private String equipo;
    private Integer numero;
    private Integer goles;

    protected Jugador() {}

    private Jugador(Builder builder) {
        this.nombre = builder.nombre;
        this.posicion = builder.posicion;
        this.equipo = builder.equipo;
        this.numero = builder.numero;
        this.goles = builder.goles;
    }

    public static Builder builder() {
        return new Builder();
    }

/**
 * Builder fue usado principalmente para ayudar a que los elementos se vayan
 * creando de manera consecutiva, evitando así confundir el orden de los
 * parámetros. Ayuda a evitar sobrecargas de constructores y hace el código
 * más legible.
 */
    public static class Builder {
        private String nombre;
        private String posicion;
        private String equipo;
        private Integer numero;
        private Integer goles;

        public Builder nombre(String nombre) { this.nombre = nombre; return this; }
        public Builder posicion(String posicion) { this.posicion = posicion; return this; }
        public Builder equipo(String equipo) { this.equipo = equipo; return this; }
        public Builder numero(Integer numero) { this.numero = numero; return this; }
        public Builder goles(Integer goles) { this.goles = goles; return this; }

        public Jugador build() {
            return new Jugador(this);
        }
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getPosicion() { return posicion; }
    public void setPosicion(String posicion) { this.posicion = posicion; }
    public String getEquipo() { return equipo; }
    public void setEquipo(String equipo) { this.equipo = equipo; }
    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }
    public Integer getGoles() { return goles; }
    public void setGoles(Integer goles) { this.goles = goles; }
}

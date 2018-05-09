package aerolinea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "Vuelos")
public class Vuelos {

    @Id
    @Column(name = "id_vuelo")
    private String idVuelo;
    @Column(name = "ciudad_orogen")
    private String ciudadOrigen;
    @Column(name = "ciudad_destino")
    private String ciudadDestino;
    @Column(name = "fecha_ida")
    private Date fechaIda;
    @Column(name = "fecha_regreso")
    private Date fechaRegreso;
    @Column(name = "tipo_viaje")
    private Integer tipoViaje;
    @Column(name = "tipo_persona")
    private Integer tipoPersona;
    @Column(name = "SILLAS_DISPONIBLES")
    private Integer sillasDisponibles;
    @Column(name = "HORARIO_IDA")
    private Date horarioIda;
    @Column(name = "superpromo")
    private Double superPromo;
    @Column(name = "economica")
    private Double economica;
    @Column(name = "ejecutivo")
    private Double ejecutivo;
    @Column(name = "primera_clase")
    private Double primersClase;
    @Column(name = "HORARIO_REGRESO")
    private Date horarioRegreso;

    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public Date getFechaIda() {
        return fechaIda;
    }

    public void setFechaIda(Date fechaIda) {
        this.fechaIda = fechaIda;
    }

    public Date getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(Date fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    public Integer getTipoViaje() {
        return tipoViaje;
    }

    public void setTipoViaje(Integer tipoViaje) {
        this.tipoViaje = tipoViaje;
    }

    public Integer getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(Integer tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public Integer getSillasDisponibles() {
        return sillasDisponibles;
    }

    public void setSillasDisponibles(Integer sillasDisponibles) {
        this.sillasDisponibles = sillasDisponibles;
    }

    public Date getHorario() {
        return horarioIda;
    }

    public void setHorario(Date horarioIda) {
        this.horarioIda = horarioIda;
    }

    public Double getSuperPromo() {
        return superPromo;
    }

    public void setSuperPromo(Double superPromo) {
        this.superPromo = superPromo;
    }

    public Double getEconomica() {
        return economica;
    }

    public void setEconomica(Double economica) {
        this.economica = economica;
    }

    public Double getEjecutivo() {
        return ejecutivo;
    }

    public void setEjecutivo(Double ejecutivo) {
        this.ejecutivo = ejecutivo;
    }

    public Double getPrimersClase() {
        return primersClase;
    }

    public void setPrimersClase(Double primersClase) {
        this.primersClase = primersClase;
    }


}


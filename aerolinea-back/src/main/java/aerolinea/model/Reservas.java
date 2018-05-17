package aerolinea.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "Reservas")
public class Reservas {

    @Id
    @Column(name = "cedula")
    private String cedula;
    @Column(name = "numero_reserva")
    private String numeroReserva;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    @Column(name = "FECHA_RESERVA")
    private Date fechaReserva;
    @Column(name = "VALOR_RESERVA")
    private Double valorReserva;
    @ManyToOne
    @JoinColumn(name = "id_vuelo")
    private Vuelos vuelos;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(String numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechanacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Vuelos getVuelos() {
        return vuelos;
    }

    public void setVuelos(Vuelos vuelos) {
        this.vuelos = vuelos;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Double getValorReserva() {
        return valorReserva;
    }

    public void setValorReserva(Double valorReserva) {
        this.valorReserva = valorReserva;
    }
}


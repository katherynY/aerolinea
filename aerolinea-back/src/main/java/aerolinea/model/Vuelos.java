package aerolinea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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

    //Propiedades formatiadas
    @Transient
    private String horaDestino;
    @Transient
    private String horaOrigen;
    @Transient
    private String superpromoSTRING;
    @Transient
    private String economicaSTRING;
    @Transient
    private String ejecutivoSTRING;
    @Transient
    private String primeraClaseSTRING;
    @Transient
    private String fechaIdaSTRING;
    @Transient
    private String fechaRegresoSTRING;

    @Transient
    DecimalFormat formateador = new DecimalFormat("###,###.##");

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
        this.fechaIdaSTRING = new SimpleDateFormat("dd/MM/yyyy").format(fechaIda);
        return fechaIda;
    }

    public void setFechaIda(Date fechaIda) {
        this.fechaIda = fechaIda;
    }

    public Date getFechaRegreso() {
        this.fechaRegresoSTRING = new SimpleDateFormat("dd/MM/yyyy").format(fechaRegreso);
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

    public Double getSuperPromo() {
        this.superpromoSTRING = formateador.format(this.superPromo);
        return superPromo;
    }

    public void setSuperPromo(Double superPromo) {
        this.superPromo = superPromo;
    }

    public Double getEconomica() {
        this.economicaSTRING = formateador.format(this.economica);
        return economica;
    }

    public void setEconomica(Double economica) {
        this.economica = economica;
    }

    public Double getEjecutivo() {
        this.ejecutivoSTRING = formateador.format(ejecutivo);
        return ejecutivo;
    }

    public void setEjecutivo(Double ejecutivo) {
        this.ejecutivo = ejecutivo;
    }

    public Double getPrimersClase() {
        this.primeraClaseSTRING = formateador.format(this.primersClase);
        return primersClase;
    }

    public void setPrimersClase(Double primersClase) {
        this.primersClase = primersClase;
    }

    public Date getHorarioRegreso() {
        this.horaDestino = new SimpleDateFormat("HH:mm:ss").format(horarioRegreso);
        return horarioRegreso;
    }

    public void setHorarioRegreso(Date horarioRegreso) {
        this.horarioRegreso = horarioRegreso;
    }

    public String getHoraDestino() {
        return horaDestino;
    }

    public void setHoraDestino(String horaDestino) {
        this.horaDestino = horaDestino;
    }

    public String getHoraOrigen() {
        return horaOrigen;
    }

    public void setHoraOrigen(String horaOrigen) {
        this.horaOrigen = horaOrigen;
    }

    public String getSuperpromoSTRING() {
        return superpromoSTRING;
    }

    public void setSuperpromoSTRING(String superpromoSTRING) {
        this.superpromoSTRING = superpromoSTRING;
    }

    public String getEconomicaSTRING() {
        return economicaSTRING;
    }

    public void setEconomicaSTRING(String economicaSTRING) {
        this.economicaSTRING = economicaSTRING;
    }

    public String getEjecutivoSTRING() {
        return ejecutivoSTRING;
    }

    public void setEjecutivoSTRING(String ejecutivoSTRING) {
        this.ejecutivoSTRING = ejecutivoSTRING;
    }

    public String getPrimeraClaseSTRING() {
        return primeraClaseSTRING;
    }

    public void setPrimeraClaseSTRING(String primeraClaseSTRING) {
        this.primeraClaseSTRING = primeraClaseSTRING;
    }

    public Date getHorarioIda() {
        this.horaOrigen = new SimpleDateFormat("HH:mm:ss").format(horarioIda);
        return horarioIda;
    }

    public void setHorarioIda(Date horarioIda) {
        this.horarioIda = horarioIda;
    }

    public String getFechaIdaSTRING() {
        return fechaIdaSTRING;
    }

    public void setFechaIdaSTRING(String fechaIdaSTRING) {
        this.fechaIdaSTRING = fechaIdaSTRING;
    }

    public String getFechaRegresoSTRING() {
        return fechaRegresoSTRING;
    }

    public void setFechaRegresoSTRING(String fechaRegresoSTRING) {
        this.fechaRegresoSTRING = fechaRegresoSTRING;
    }
}


package idat.com.bar_android.models;


import java.util.Date;

public class PedidoUpdateModel {

    private Long codigo;
    private String telefono;
    private String dni;
    private StatusModel estado;
    private String fecha;

    public PedidoUpdateModel() {
    }



    public PedidoUpdateModel(Long codigo, String telefono, String dni, StatusModel estado, String fecha) {
        this.codigo = codigo;
        this.telefono = telefono;
        this.dni = dni;
        this.estado = estado;
        this.fecha = fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getFecha() {
        return fecha;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public StatusModel getEstado() {
        return estado;
    }

    public void setEstado(StatusModel estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "PedidoUpdateModel{" + "codigo=" + codigo + ", telefono=" + telefono + ", dni=" + dni + ", estado=" + estado + '}';
    }

}

package idat.com.bar_android.models;

import java.util.Date;

public class OrderItemModel {

    private Integer n_pedido;
    private String nombre_cliente;
    private String dni;
    private String dni_recibidor;
    private Double costo_total;
    private Date fecha;

    public OrderItemModel(Integer n_pedido, String nombre_cliente, String dni, String dni_recibidor, Double costo_total, Date fecha) {
        this.n_pedido = n_pedido;
        this.nombre_cliente = nombre_cliente;
        this.dni = dni;
        this.dni_recibidor = dni_recibidor;
        this.costo_total = costo_total;
        this.fecha = fecha;
    }

    public OrderItemModel() {
    }

    public Integer getN_pedido() {
        return n_pedido;
    }

    public void setN_pedido(Integer n_pedido) {
        this.n_pedido = n_pedido;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni_recibidor() {
        return dni_recibidor;
    }

    public void setDni_recibidor(String dni_recibidor) {
        this.dni_recibidor = dni_recibidor;
    }

    public Double getCosto_total() {
        return costo_total;
    }

    public void setCosto_total(Double costo_total) {
        this.costo_total = costo_total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}

package idat.com.bar_android.models;

import java.util.ArrayList;
import java.util.Date;

public class OrderModel {
    private Integer cod_pedido;
    private Date fecha_solicitud;
    private Date fecha_envio;
    private String dni_recibidor;
    private Double precio_total;
    private StatusModel estado;
    private ClientModel cliente;
    private ArrayList<ProductModel> productos;


    public OrderModel() {
    }

    public OrderModel(Integer cod_pedido, Date fecha_solicitud, Date fecha_envio, String dni_recibidor, Double precio_total, StatusModel estado, ClientModel cliente, ArrayList<ProductModel> productos) {
        this.cod_pedido = cod_pedido;
        this.fecha_solicitud = fecha_solicitud;
        this.fecha_envio = fecha_envio;
        this.dni_recibidor = dni_recibidor;
        this.precio_total = precio_total;
        this.estado = estado;
        this.cliente = cliente;
        this.productos = productos;
    }

    public Integer getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(Integer cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    public Date getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(Date fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public Date getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(Date fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public String getDni_recibidor() {
        return dni_recibidor;
    }

    public void setDni_recibidor(String dni_recibidor) {
        this.dni_recibidor = dni_recibidor;
    }

    public Double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(Double precio_total) {
        this.precio_total = precio_total;
    }

    public StatusModel getEstado() {
        return estado;
    }

    public void setEstado(StatusModel estado) {
        this.estado = estado;
    }

    public ClientModel getCliente() {
        return cliente;
    }

    public void setCliente(ClientModel cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ProductModel> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<ProductModel> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "cod_pedido=" + cod_pedido +
                ", fecha_solicitud=" + fecha_solicitud +
                ", fecha_envio=" + fecha_envio +
                ", dni_recibidor='" + dni_recibidor + '\'' +
                ", precio_total=" + precio_total +
                ", estado=" + estado +
                ", cliente=" + cliente +
                ", productos=" + productos +
                '}';
    }
}

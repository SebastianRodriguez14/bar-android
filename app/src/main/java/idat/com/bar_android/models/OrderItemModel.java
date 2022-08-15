package idat.com.bar_android.models;

import java.util.Date;

public class OrderItemModel {

    private Integer cod_pedido;
    private ClientModel cliente;
    private String dni_recibidor;
    private Double precio_total;
    private Date fecha_envio;

    public OrderItemModel(Integer cod_pedido, ClientModel cliente, String dni_recibidor, Double precio_total, Date fecha_envio) {
        this.cod_pedido = cod_pedido;
        this.cliente = cliente;
        this.dni_recibidor = dni_recibidor;
        this.precio_total = precio_total;
        this.fecha_envio = fecha_envio;
    }

    public OrderItemModel() {
    }

    @Override
    public String toString() {
        return "OrderItemModel{" +
                "cod_pedido=" + cod_pedido +
                ", cliente=" + cliente.toString() +
                ", dni_recibidor='" + dni_recibidor + '\'' +
                ", precio_total=" + precio_total +
                ", fecha_envio=" + fecha_envio +
                '}';
    }

    public Integer getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(Integer cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    public ClientModel getCliente() {
        return cliente;
    }

    public void setCliente(ClientModel cliente) {
        this.cliente = cliente;
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

    public Date getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(Date fecha_envio) {
        this.fecha_envio = fecha_envio;
    }
}

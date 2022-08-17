package idat.com.bar_android.models;

public class DetailModel {
    private Integer idpedido;
    private Integer idproducto;
    private Integer cantidad;
    private Double subtotal;

    public DetailModel(Integer idpedido, Integer idproducto, Integer cantidad, Double subtotal) {
        this.idpedido = idpedido;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public DetailModel() {
    }

    public Integer getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "DetailModel{" +
                "idpedido=" + idpedido +
                ", idproducto=" + idproducto +
                ", cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                '}';
    }
}


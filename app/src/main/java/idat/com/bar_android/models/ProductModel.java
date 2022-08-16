package idat.com.bar_android.models;

public class ProductModel {
    private Integer codigo;
    private String descripcion;
    private Double precio;
    private String imagen;
    private Boolean estado;
    private BrandModel marca;

    public ProductModel() {
    }

    public ProductModel(Integer codigo, String descripcion, Double precio, String imagen, Boolean estado, BrandModel marca) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.estado = estado;
        this.marca = marca;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public BrandModel getMarca() {
        return marca;
    }

    public void setMarca(BrandModel marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", imagen='" + imagen + '\'' +
                ", estado=" + estado +
                ", marca=" + marca +
                '}';
    }
}

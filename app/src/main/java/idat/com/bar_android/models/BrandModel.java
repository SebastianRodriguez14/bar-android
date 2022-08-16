package idat.com.bar_android.models;

public class BrandModel {
    private Integer codigo;
    private String nombre;
    private Boolean estado;
    private CategoryModel categoria;

    public BrandModel() {
    }

    public BrandModel(Integer codigo, String nombre, Boolean estado, CategoryModel categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.categoria = categoria;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public CategoryModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoryModel categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "BrandModel{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", estado=" + estado +
                ", categoria=" + categoria +
                '}';
    }
}

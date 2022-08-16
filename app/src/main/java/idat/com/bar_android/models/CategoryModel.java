package idat.com.bar_android.models;

public class CategoryModel {
    private Integer codigo;
    private String nombre;


    public CategoryModel() {
    }
    public CategoryModel(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                '}';
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
}


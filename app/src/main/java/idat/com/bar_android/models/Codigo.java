package idat.com.bar_android.models;

public class Codigo {
    private static String codigo;

    public Codigo() {
    }

    public static String getCodigo() {
        return codigo;
    }

    public static void setCodigo(String codigo) {
        Codigo.codigo = codigo;
    }
}

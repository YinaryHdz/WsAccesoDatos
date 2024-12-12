package convertidorPersonalizadoCompleto;

/**
 *  @descrition Clase que representa un numero de telefono
 */

public class Telefono {
    private int codigo;
    private int numero;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    @Override
    public String toString() {
        return "Telefono [codigo=" + codigo + ", numero=" + numero + "]";
    }
}


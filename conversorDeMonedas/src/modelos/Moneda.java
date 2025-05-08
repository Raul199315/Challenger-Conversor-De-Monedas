package modelos;

public class Moneda {

    private String pais;
    private double valor;

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Moneda(double valor, String pais) {
        this.valor = valor;
        this.pais = pais;


    }

    @Override
    public String toString() {
        return  pais + " " + valor;

    }
}

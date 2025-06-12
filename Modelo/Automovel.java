package modell;

public class Automovel {
  
    private String placa;
    private String modelo;
    private String marca;
    private int ano;
    private double valor;


    public Automovel(String placa, String modelo, String marca, int ano, double valor) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.valor = valor;
    }

   
    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public String getMarca() { return marca; }
    public int getAno() { return ano; }
    public double getValor() { return valor; }


    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setAno(int ano) { this.ano = ano; }
    public void setValor(double valor) { this.valor = valor; }


    public String toString() {
        return placa + "," + modelo + "," + marca + "," + ano + "," + valor;
    }

    public static Automovel fromCSV(String linha) {
        String[] partes = linha.split(",");
        return new Automovel(
            partes[0],
            partes[1],
            partes[2],
            Integer.parseInt(partes[3]),
            Double.parseDouble(partes[4])
        );
    }
}

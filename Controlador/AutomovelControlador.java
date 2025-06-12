package controller;

import modell.Automovel;
import java.io.*;
import java.util.*;

public class AutomovelController {
    private List<Automovel> lista = new ArrayList<>();
    private final String arquivo = "automoveis.txt";

    public AutomovelController() {
        carregarDoArquivo();
    }

    public boolean adicionar(Automovel a) {
        if (buscar(a.getPlaca()) != null) return false;
        lista.add(a);
        return true;
    }

    public boolean remover(String placa) {
        Automovel a = buscar(placa);
        if (a != null) {
            lista.remove(a);
            return true;
        }
        return false;
    }

    public boolean alterar(String placa, String modelo, String marca, int ano, double valor) {
        Automovel a = buscar(placa);
        if (a != null) {
            a.setModelo(modelo);
            a.setMarca(marca);
            a.setAno(ano);
            a.setValor(valor);
            return true;
        }
        return false;
    }

    public Automovel buscar(String placa) {
        for (Automovel a : lista) {
            if (a.getPlaca().equalsIgnoreCase(placa)) return a;
        }
        return null;
    }

    public List<Automovel> listarOrdenado(String por) {
        List<Automovel> copia = new ArrayList<>(lista);
        switch (por.toLowerCase()) {
            case "modelo" -> copia.sort(Comparator.comparing(Automovel::getModelo));
            case "marca" -> copia.sort(Comparator.comparing(Automovel::getMarca));
            default -> copia.sort(Comparator.comparing(Automovel::getPlaca));
        }
        return copia;
    }

    public void salvar() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Automovel a : lista) {
                bw.write(a.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    private void carregarDoArquivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                lista.add(Automovel.fromCSV(linha));
            }
        } catch (IOException e) {
            // Arquivo não encontrado? Sem problemas, começamos vazio.
        }
    }
}

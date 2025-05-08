package modelos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Convertir {

    /// Variables
    private String monedaBAse;
    private int indiceListaMonedas;

    public Convertir() {
    }

    public int getIndiceListaMonedas() {
        return indiceListaMonedas;
    }

    public void setIndiceListaMonedas(int indiceListaMonedas) {
        this.indiceListaMonedas = indiceListaMonedas;
    }

    public String getMonedaBAse() {
        return monedaBAse;
    }

    public void setMonedaBAse(String monedaBAse) {
        this.monedaBAse = monedaBAse;
    }

    public void conversor(String monedaBAse,String monedaSegundaria, int indiceListaMonedas, String texto,double valor ) throws IOException, InterruptedException {


        List<String> monedasSeleccionadas = Arrays.asList("COP","USD","BRL");


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/f697fcad778d60f1967ad1db/latest/"+monedaBAse))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);

        JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");

        /// /lista de monedas para convertir
        List<Moneda> listaMonedasFiltradas = new ArrayList<>();
        double valorCOmvertir;
        for (String moneda : monedasSeleccionadas) {
            if (conversionRates.has(moneda)) {
                ///  agregamos las monedas selecionadas a la lista como objetos de la Clase Moneda
                listaMonedasFiltradas.add(new Moneda(conversionRates.get(moneda).getAsDouble(), moneda));

            }
        }
        ///  multiplicamos la moneda base por la moneda a la cual deseamos convertir y la
        /// guardamos en la variable conversion
        double conversion = listaMonedasFiltradas.get(indiceListaMonedas).getValor()*valor;
        /// mostramos el resultado al usuario
        System.out.println(valor + texto + conversion+ " " + monedaSegundaria);
    }
        }






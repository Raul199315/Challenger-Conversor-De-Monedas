package principal;

import modelos.Convertir;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

      ///  lista de monedas
      /// BRL BRASIL
      /// COP COLOMBIA
      /// CLP CHILE
      /// ARS ARGENTINA
      ///  menu
      Scanner teclado = new Scanner(System.in);
      Scanner teclado1 = new Scanner(System.in);
      boolean bandera = true;
      int opcion = 0;
      double valor;

      Convertir conversor = new Convertir();

      while (bandera) {
        System.out.println("""
                ******************************************************
                Bienvenido/a al conversort de monedas
                
                Elije una opcion
                1) Dolar => Peso Colombiano
                2) Peso Colombiano => Dolar
                3) Dolar => Real Brasileño
                4) Real Brasileño => Dolar
                5) Peso Colobiano => Real Brasileño
                6) salir 
                
                """);
        opcion = teclado.nextInt();
        if (opcion == 1) {
          System.out.println("**************************************************");
          System.out.println("Ingrese el valor que desea convertir");
          valor = teclado.nextDouble();
          conversor.conversor("USD", "Pesos", 0, " Dolares en Pesos Colombianos son: ", valor);

        } else if (opcion == 2) {
          System.out.println("Ingrese el valor que desea convertir");
          valor = teclado.nextDouble();
          conversor.conversor("COP", "USD", 1, " Pesos Colombianos en Dolares son: ", valor);
        } else if (opcion == 3) {
          System.out.println("Ingrese el valor que desea convertir");
          valor = teclado.nextDouble();
          conversor.conversor("USD", "BRL", 2, " Dolares en Reales Brasileños son: ", valor);
        } else if (opcion == 4) {
          System.out.println("Ingrese el valor que desea convertir");
          valor = teclado.nextDouble();
          conversor.conversor("BRL", "USD", 1, " Reales Brasileños en Dolares  son: ", valor);
        } else if (opcion == 5) {
          System.out.println("Ingrese el valor que desea convertir");
          System.out.println("Ingrese el valor que desea convertir");
          valor = teclado.nextDouble();

          conversor.conversor("COP", "BRL", 2, " Pesos Colombianos en Reales Brasileños son: ", valor);
        } else if (opcion == 6) {
          System.out.println("Saliendo........................");
          bandera = false;
        }

      }
    }
}

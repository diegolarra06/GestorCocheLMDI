package vista;

import java.util.List;
import java.util.Scanner;
import java.sql.ResultSet;

public class VistaConsola {
    private Scanner sc = new Scanner(System.in);

    public void mostrarMenuPrincipal() {
        System.out.println("\n--- CONTROL DE GASTOS ---");
        System.out.println("1. Registrar");
        System.out.println("2. Login");
        System.out.println("3. Salir");
        System.out.print("Elige opción: ");
    }

    public void mostrarMenuUsuario() {
        System.out.println("\n--- MENÚ USUARIO ---");
        System.out.println("1. Añadir coche");
        System.out.println("2. Ver mis coches");
        System.out.println("3. Añadir propietario");
        System.out.println("4. Añadir gasto a coche");
        System.out.println("5. Ver gastos de coche");
        System.out.println("6. Cerrar sesión");
        System.out.print("Elige opción: ");
    }

    public void mostrarCoches(List<String> matriculas) {
        System.out.println("\n--- TUS COCHES ---");
        if (matriculas.isEmpty()) {
            System.out.println("No tienes coches.");
        } else {
            for (String mat : matriculas) {
                System.out.println(mat);
            }
        }
    }

    public void mostrarGastos(ResultSet gastos) throws java.sql.SQLException {
        System.out.println("\n--- GASTOS ---");
        System.out.println("Fecha\t\tTipo\t\tImporte\t\tDescripción");
        while (gastos.next()) {
            System.out.println(
                gastos.getString("fecha") + "\t" +
                gastos.getString("tipo de gasto") + "\t" +
                gastos.getDouble("importe") + "€\t\t" +
                gastos.getString("descripcion")
            );
        }
    }

    public String pedirTexto(String mensaje) {
        System.out.print(mensaje + ": ");
        return sc.nextLine();
    }

    public int pedirEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje + ": ");
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("¡Debes introducir un número!");
            }
        }
    }

    public double pedirDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje + ": ");
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("¡Debes introducir un número válido!");
            }
        }
    }

    public String pedirTipoGasto() {
        while (true) {
            System.out.print("Tipo de gasto (gasolina/revision/itv/aceite/otros): ");
            String input = sc.nextLine().toLowerCase();
            if (List.of("gasolina","revision","itv","aceite","otros").contains(input)) {
                return input;
            }
            System.out.println("¡Tipo no válido!");
        }
    }

    public String pedirFecha() {
        System.out.print("Fecha (YYYY-MM-DD): ");
        return sc.nextLine();
    }
}

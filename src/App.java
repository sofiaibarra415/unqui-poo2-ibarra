import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Crear empresa
        Empresa empresa = new Empresa("Mi Empresa SA", "20-12345678-9");

        // Crear empleado permanente
        EmpleadoPermanente permanente = new EmpleadoPermanente(
            "Juan Perez",
            "Av. Siempreviva 123",
            "casado",
            LocalDate.of(1985, 5, 10),
            1000,
            2,
            5
        );

        // Crear empleado temporario
        EmpleadoTemporario temporario = new EmpleadoTemporario(
            "Maria Garcia",
            "Calle Falsa 456",
            "soltera",
            LocalDate.of(1990, 3, 20),
            800,
            "2026-12-31",
            10
        );

        // Agregar empleados a la empresa
        empresa.agregarEmpleado(permanente);
        empresa.agregarEmpleado(temporario);

        // Script I - Calcular totales
        System.out.println("=== Totales ===");
        System.out.println("Total Sueldos Brutos: " + empresa.calcularTotalSueldosBrutos());
        System.out.println("Total Retenciones: " + empresa.calcularTotalRetenciones());
        System.out.println("Total Sueldos Netos: " + empresa.calcularTotalSueldosNetos());

        // Script II - Liquidar sueldos
        System.out.println("\n=== Liquidacion de Sueldos ===");
        empresa.liquidarSueldos();
    }
}
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Recibo {

    private String nombreEmpleado;
    private String direccion;
    private LocalDate fechaEmision;
    private double sueldoBruto;
    private double sueldoNeto;
    private List<Concepto> conceptos;

    public Recibo(String nombreEmpleado, String direccion, double sueldoBruto, double sueldoNeto) {
        this.nombreEmpleado = nombreEmpleado;
        this.direccion = direccion;
        this.fechaEmision = LocalDate.now();
        this.sueldoBruto = sueldoBruto;
        this.sueldoNeto = sueldoNeto;
        this.conceptos = new ArrayList<>();
    }

    public void agregarConcepto(Concepto concepto) {
        conceptos.add(concepto);
    }


    public void mostrarDesglose() {
        System.out.println("=== Recibo de Haberes ===");
        System.out.println("Empleado: " + nombreEmpleado);
        System.out.println("Direccion: " + direccion);
        System.out.println("Fecha: " + fechaEmision);
        System.out.println("--- Conceptos ---");
        conceptos.forEach(c -> System.out.println(c.getNombre() + ": " + c.getMonto()));
        System.out.println("Sueldo Bruto: " + sueldoBruto);
        System.out.println("Sueldo Neto: " + sueldoNeto);
    }
}
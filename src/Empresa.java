import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String nombre;
    private String cuit;
    private List<Empleado> empleados;

    public Empresa(String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.empleados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCuit() {
        return cuit;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public double calcularTotalSueldosBrutos() {
        return empleados.stream()
            .mapToDouble(e -> e.calcularSueldoBruto())
            .sum();
    }

    public double calcularTotalRetenciones() {
        return empleados.stream()
            .mapToDouble(e -> e.calcularRetenciones())
            .sum();
    }

    public double calcularTotalSueldosNetos() {
        return empleados.stream()
            .mapToDouble(e -> e.calcularSueldoNeto())
            .sum();
    }

    public void liquidarSueldos() {
        empleados.forEach(e -> e.generarReciboHaberes());
    }
}
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public abstract class Empleado {
    
    private String nombre;
    private String direccion;
    private String estadoCivil;
    private double sueldoBasico;
    protected List<Recibo> recibos;
    private LocalDate fechaNacimiento;

    public Empleado(String nombre, String direccion, String estadoCivil, 
                    LocalDate fechaNacimiento, double sueldoBasico) {
        this.nombre = nombre;
        this.recibos = new ArrayList<>();
        this.direccion = direccion;
        this.estadoCivil = estadoCivil;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldoBasico = sueldoBasico;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getEstadoCivil() { return estadoCivil; }
    public void setEstadoCivil(String estadoCivil) { this.estadoCivil = estadoCivil; }
    public double getSueldoBasico() { return sueldoBasico; }
    public void setSueldoBasico(double sueldoBasico) { this.sueldoBasico = sueldoBasico; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public int calcularEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public abstract double calcularSueldoBruto();
    public abstract double calcularRetenciones();

    public double calcularSueldoNeto() {
        return calcularSueldoBruto() - calcularRetenciones();
    }

    public abstract void generarReciboHaberes();
}
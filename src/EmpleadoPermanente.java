import java.time.LocalDate;

public class EmpleadoPermanente extends Empleado {

    private int cantidadHijos;
    private int antiguedad;

    public EmpleadoPermanente(String nombre, String direccion, String estadoCivil,
                               LocalDate fechaNacimiento, double sueldoBasico,
                               int cantidadHijos, int antiguedad) {
        super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
        this.cantidadHijos = cantidadHijos;
        this.antiguedad = antiguedad;
    }

    public int getCantidadHijos() { return cantidadHijos; }
    public void setCantidadHijos(int cantidadHijos) { this.cantidadHijos = cantidadHijos; }
    public int getAntiguedad() { return antiguedad; }
    public void setAntiguedad(int antiguedad) { this.antiguedad = antiguedad; }

    public double calcularSalarioFamiliar() {
        double salario = cantidadHijos * 150;
        if (getEstadoCivil().equals("casado")) {
            salario += 100;
        }
        return salario;
    }

    @Override
    public double calcularSueldoBruto() {
        return getSueldoBasico() + calcularSalarioFamiliar() + (antiguedad * 50);
    }

    @Override
    public double calcularRetenciones() {
        double obraSocial = calcularSueldoBruto() * 0.10 + (cantidadHijos * 20);
        double jubilacion = calcularSueldoBruto() * 0.15;
        return obraSocial + jubilacion;
    }

    @Override
    public void generarReciboHaberes() {
        Recibo recibo = new Recibo(getNombre(), getDireccion(), calcularSueldoBruto(), calcularSueldoNeto());
        recibo.agregarConcepto(new Concepto("Sueldo basico", getSueldoBasico()));
        recibo.agregarConcepto(new Concepto("Salario familiar", calcularSalarioFamiliar()));
        recibo.agregarConcepto(new Concepto("Antiguedad", antiguedad * 50.0));
        recibo.agregarConcepto(new Concepto("Obra social", calcularSueldoBruto() * 0.10 + cantidadHijos * 20));
        recibo.agregarConcepto(new Concepto("Jubilacion", calcularSueldoBruto() * 0.15));
        recibo.mostrarDesglose();
        recibos.add(recibo);
    }
}
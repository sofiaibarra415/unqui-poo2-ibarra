import java.time.LocalDate;

public class EmpleadoTemporario extends Empleado {

    private String fechaFinDesignacion;
    private int horasExtras;

    public EmpleadoTemporario(String nombre, String direccion, String estadoCivil,
                               LocalDate fechaNacimiento, double sueldoBasico,
                               String fechaFinDesignacion, int horasExtras) {
        super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
        this.fechaFinDesignacion = fechaFinDesignacion;
        this.horasExtras = horasExtras;
    }

    public String getFechaFinDesignacion() { return fechaFinDesignacion; }
    public void setFechaFinDesignacion(String fechaFinDesignacion) { this.fechaFinDesignacion = fechaFinDesignacion; }
    public int getHorasExtras() { return horasExtras; }
    public void setHorasExtras(int horasExtras) { this.horasExtras = horasExtras; }

    @Override
    public double calcularSueldoBruto() {
        return getSueldoBasico() + (horasExtras * 40);
    }

    @Override
    public double calcularRetenciones() {
        double obraSocial = calcularSueldoBruto() * 0.10;
        if (calcularEdad() > 50) {
            obraSocial += 25;
        }
        double jubilacion = calcularSueldoBruto() * 0.10 + (horasExtras * 5);
        return obraSocial + jubilacion;
    }

    @Override
    public void generarReciboHaberes() {
        Recibo recibo = new Recibo(getNombre(), getDireccion(), calcularSueldoBruto(), calcularSueldoNeto());
        recibo.agregarConcepto(new Concepto("Sueldo basico", getSueldoBasico()));
        recibo.agregarConcepto(new Concepto("Horas extras", horasExtras * 40.0));
        double montoObraSocial = calcularSueldoBruto() * 0.10 + (calcularEdad() > 50 ? 25 : 0);
        recibo.agregarConcepto(new Concepto("Obra social", montoObraSocial));
        recibo.agregarConcepto(new Concepto("Jubilacion", calcularSueldoBruto() * 0.10 + horasExtras * 5));
        recibo.mostrarDesglose();
        recibos.add(recibo);
    }
}
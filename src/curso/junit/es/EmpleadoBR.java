package curso.junit.es;

public class EmpleadoBR {

    public enum TipoEmpleado {
        VENDEDOR,
        ENCARGADO
    }

    public float calculaSalarioBruto(TipoEmpleado tipo, float ventasMes, float horasExtra) throws BRException {
        if (tipo == null || ventasMes < 0 || horasExtra < 0) {
            throw new BRException("Valores inválidos proporcionados");
        }

        float salarioBase = (tipo == TipoEmpleado.VENDEDOR) ? 1000 : 1500;
        float prima = 0;

        if (ventasMes >= 1000 && ventasMes < 1500) {
            prima = 100;
        } else if (ventasMes >= 1500) {
            prima = 200;
        }

        float salarioBruto = salarioBase + prima + (horasExtra * 20);
        return salarioBruto;
    }


    public float calculaSalarioNeto(float salarioBruto) throws BRException {
        if (salarioBruto < 0) {
            throw new BRException("Salario bruto no puede ser negativo");
        }

        float retencion;

        if (salarioBruto < 1000) {
            retencion = 0;  // No se aplica retención para salarios menores a 1000 euros
        } else if (salarioBruto < 1500) {
            retencion = 0.16f;  // Retención del 16% para salarios entre 1000 y 1500 euros
        } else {
            retencion = 0.18f;  // Retención del 18% para salarios de 1500 euros o más
        }

        float salarioNeto = salarioBruto * (1 - retencion);
        return salarioNeto;
    }



}


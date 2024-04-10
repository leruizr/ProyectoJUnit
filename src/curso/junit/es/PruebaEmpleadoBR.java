package curso.junit.es;

import static org.junit.Assert.*;

import org.junit.Test;

public class PruebaEmpleadoBR {

    @Test
    public void testCalculaSalarioBruto() throws BRException {
        EmpleadoBR empleadoBR = new EmpleadoBR();

        // Calcular salario bruto para un vendedor con 1200 euros de ventas y 5 horas extra
        float salarioBrutoVendedor = empleadoBR.calculaSalarioBruto(EmpleadoBR.TipoEmpleado.VENDEDOR, 1200, 5);
        assertEquals(1300.0f, salarioBrutoVendedor, 0.01f);  // Se espera un salario bruto de 1300 euros

        // Calcular salario bruto para un encargado con 1600 euros de ventas y 8 horas extra
        float salarioBrutoEncargado = empleadoBR.calculaSalarioBruto(EmpleadoBR.TipoEmpleado.ENCARGADO, 1600, 8);
        assertEquals(1800.0f, salarioBrutoEncargado, 0.01f);  // Se espera un salario bruto de 1800 euros

        // Verificar lanzamiento de excepción con valores negativos
        try {
            empleadoBR.calculaSalarioBruto(EmpleadoBR.TipoEmpleado.VENDEDOR, -100, 2);
            fail("Se esperaba una excepción BRException");
        } catch (BRException e) {
            // Éxito esperado
        }
    }

    @Test
    public void testCalculaSalarioNeto() throws BRException {
        EmpleadoBR empleadoBR = new EmpleadoBR();

        float salarioNetoMenor1000 = empleadoBR.calculaSalarioNeto(900);
        assertEquals(900.0f, salarioNetoMenor1000, 0.01f);  // Margen de error de 0.01 para comparación

        float salarioNetoEntre1000y1500 = empleadoBR.calculaSalarioNeto(1200);
        assertEquals(1008.0f, salarioNetoEntre1000y1500, 0.01f);  // Margen de error de 0.01 para comparación

        float salarioNetoMayor1500 = empleadoBR.calculaSalarioNeto(1800);
        assertEquals(1476.0f, salarioNetoMayor1500, 0.01f);  // Margen de error de 0.01 para comparación

        // Verificar lanzamiento de excepción con salario negativo
        try {
            empleadoBR.calculaSalarioNeto(-500);
            fail("Se esperaba una excepción BRException");
        } catch (BRException e) {
            // Éxito esperado
        }
    }
}

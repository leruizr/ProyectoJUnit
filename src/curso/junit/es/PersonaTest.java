package curso.junit.es;

import static org.junit.Assert.*;

import org.junit.*;

public class PersonaTest {

    @Test
    public void testSaludo() {
        // Crear una instancia de Persona
        Persona persona = new Persona();
        
        // Llamar al método saludo y verificar el resultado esperado
        String resultado = persona.saludo("Alejandro", "Díaz");
        
        // Verificar que el saludo generado sea el esperado
        assertEquals("Buenos días Alejandro Díaz", resultado);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package controlador;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.*;
import vista.VentanaAccionesUsuario;
import vista.VentanaTablaUsuarios;

/**
 * @author profesor
 */
public class VentanaAccionesUsuarioControladorTest {

    @Mock
    private VentanaAccionesUsuario mockVentanaAccionesUsuario;
    @Mock
    private VentanaTablaUsuarios mockVentanaTablaUsuarios;

    @InjectMocks
    private VentanaAccionesUsuarioControlador ventanaAccionesUsuarioControlador;

    @BeforeAll
    // public static void setUpClass() {
    public static void beforeAll() {

	System.out.println("beforeAll");
	System.out.println("\n\n");
	
    }

    @AfterAll
    public static void afterAll() {
	
	System.out.println("afterAll");
	System.out.println("\n\n");
    }

    @BeforeEach
    // public void setUp() {
    public void beforeEach() {
	System.out.println("beforeEach");
	System.out.println("\n\n");
	
	ventanaAccionesUsuarioControlador = new VentanaAccionesUsuarioControlador(mockVentanaAccionesUsuario);
    }

    @AfterEach
    public void afterEach() {
	
	System.out.println("afterEach");
	System.out.println("\n\n");
    }

    /**
     * Test of abrirVentanaTablaUsuarios method, of class
     * VentanaAccionesUsuarioControlador.
     */
    @Test
    // Este test no funciona debido a que se abre una ventana y al no ser cerrada, no continua el código
    public void testAbrirVentanaTablaUsuarios() {
	System.out.println("abrirVentanaTablaUsuarios");

	
//	String mensaje = "El objeto no debe ser nulo";
//	
//	
//	ventanaAccionesUsuarioControlador.abrirVentanaTablaUsuarios();
//	
//	assertNotNull(ventanaAccionesUsuarioControlador.getVentanaTablaUsuarios(), mensaje);
	
	System.out.println("\n\n");
    }

    /**
     * Test of insertarUsuario method, of class VentanaAccionesUsuarioControlador.
     */
    @Test
    public void testInsertarUsuario() {
	System.out.println("insertarUsuario");
	
	boolean esperado = true;
	boolean resultado = false;
	
	mockVentanaAccionesUsuario.getjTextFieldID().setText(null);
	mockVentanaAccionesUsuario.getjTextFieldApellido1().setText("Martinez");
	mockVentanaAccionesUsuario.getjTextFieldApellido2().setText("Rivera");
	mockVentanaAccionesUsuario.getjTextFieldNombre().setText("José Luis");
	mockVentanaAccionesUsuario.getjTextFieldFechaNacimiento().setText("1980-06-22");
	
	ventanaAccionesUsuarioControlador.insertarUsuario();
	
	assertEquals(esperado, resultado);
	

	System.out.println("\n\n");
    }
}
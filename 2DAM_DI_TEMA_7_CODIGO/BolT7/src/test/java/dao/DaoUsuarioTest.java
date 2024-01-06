/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import java.util.ArrayList;
import modelo.Usuario;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

/**
 * @author profesor
 */
@ExtendWith(MockitoExtension.class)
public class DaoUsuarioTest {

  @Mock private Usuario mockUsuario;

  @InjectMocks private DaoUsuario daoUsuario;

  @BeforeAll
  public static void setUpClass() {}

  @AfterAll
  public static void tearDownClass() {}

  @BeforeEach
  public void setUp() {}

  @AfterEach
  public void tearDown() {}

  /** Test of insertarUsuario method, of class DaoUsuario. */
  @Test
  public void testInsertarUsuario() {
    System.out.println("testInsertarUsuario");

    boolean esperado = true;
    boolean resultado = true;

    Mockito.when(daoUsuario.insertarUsuario(mockUsuario)).thenReturn(resultado);

    //        Usuario usuario = null;
    //        DaoUsuario instance = new DaoUsuario();
    //        boolean expResult = false;
    //        boolean result = instance.insertarUsuario(usuario);
    //        assertEquals(expResult, result);
    //        // TODO review the generated test code and remove the default call to fail.
    //        fail("The test case is a prototype.");
  }

  /** Test of leerUsuarios method, of class DaoUsuario. */
  @Test
  public void testLeerUsuarios() {
    System.out.println("testLeerUsuarios");
  }
}

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
public class PlantaTest {

	private List<Modelo> listaDeModelos;
	private Modelo modeloKa = mock(Modelo.class);
	private Planta miPlanta;
	private Modelo modeloFocus = mock(Modelo.class);

	@Before
	public void setUp() throws Exception {
		//modeloKa = new Modelo("Ka", 2016, 5, true);
		//modeloFocus = new Modelo("Focus", 2016, 5, true);
		listaDeModelos = new ArrayList<Modelo>();
		miPlanta = new Planta(listaDeModelos, 150);
	}
	
	@Test
	public void testPlantaConsistente() {
		assertTrue(miPlanta.puntoEnElMapa().equals(150));
		assertEquals(miPlanta.listaDeModelos(),listaDeModelos);
	}
	
	@Test
	public void testStockTotalEnPlantaInicialEs0(){
		assertTrue(miPlanta.stockTotalEnPlanta().equals(0));
	}
	
	@Test
	public void testDadaUnaPlantaAgregarUnModeloSiLePreguntoSuCantidadDeModelosAProducirResponde1(){
		miPlanta.agregarModeloAProducir(modeloKa);
		assertTrue(miPlanta.cantidadDeModelosAProducir().equals(1));	
	}
	
	@Test
	public void testDadaUnaPlantaConDosModeloKaAProducirSiLePreguntoSuCantidadDeModelosAProducirResponde2(){
		miPlanta.agregarModeloAProducir(modeloKa);
		miPlanta.agregarModeloAProducir(modeloKa);
		assertTrue(miPlanta.cantidadDeModelosAProducir().equals(2));	
	}
	
	@Test
	public void testDadaUnaPlantaConUnAutoFordKaSiLePreguntoElTotalDeFordKaResponde1(){
		miPlanta.agregarModeloAProducir(modeloKa);
		miPlanta.agregarStock(modeloKa);
		assertTrue(miPlanta.stockTotalEnPlantaPara(modeloKa).equals(1));
	}
	
	@Test
	public void  testDadaUnaPlantaConUnAutoFordFocusSiLePreguntoElTotalDeFordKaResponde0(){
		miPlanta.agregarModeloAProducir(modeloFocus);
		//miPlanta.agregarStock(modeloFocus);
		assertTrue(miPlanta.stockTotalEnPlantaPara(modeloKa).equals(0));
	}
	
	@Test
	public void testDadoUnaPlantaConStockDeKaSiLePreguntoSiTieneStockDeKaRespondeTrue(){
		miPlanta.agregarModeloAProducir(modeloKa);
		miPlanta.agregarStock(modeloKa);
		assertTrue(miPlanta.tieneStockDe(modeloKa));
	}
	
	@Test
	public void testDadoUnaPlantaConStockDeFocusSiLePreguntoSiTieneStockDeKaRespondeFalse(){
		miPlanta.agregarModeloAProducir(modeloFocus);
		miPlanta.agregarStock(modeloFocus);
		assertFalse(miPlanta.tieneStockDe(modeloKa));
	}
	
	@Test
	public void testDadoUnaPlantaQueProduceModeloKaSiLePreguntoSiProduceUnModeloKaRespondeTrue(){
		miPlanta.agregarModeloAProducir(modeloKa);
		assertTrue(miPlanta.produceModelo(modeloKa));
	}
	
	@Test
	public void testDadoUnaPlantaQueProduceModeloFocusSiLePreguntoSiProduceUnModeloKaRespondeFalse(){
		miPlanta.agregarModeloAProducir(modeloFocus);
		assertFalse(miPlanta.produceModelo(modeloKa));
	}
	

}
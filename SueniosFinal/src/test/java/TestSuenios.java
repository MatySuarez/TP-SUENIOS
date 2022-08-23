import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import excepciones.*;
import org.junit.Before;
import org.junit.Test;

import suenios.Persona;
import suenios.AdoptarHijo;
import suenios.Recibirse;
import suenios.SuenioMultiple;
import suenios.TenerHijos;
import suenios.Trabajar;
import suenios.Viajar;
import suenios.Alocado;
import suenios.Obsesivo;
import suenios.Realista;

public class TestSuenios
{
	AdoptarHijo adoptar2Hijos;
	Recibirse recibirseDeLicenciadoEnSistemas;
	TenerHijos tener2Hijos;
	TenerHijos tener1Hijo;
	Viajar viajarABrasil;
	Viajar viajarACataratas;
	Viajar viajarAChapadmalal;
	Trabajar trabajarProgramador;
	Trabajar trabajarOficinista;
	SuenioMultiple suenioMultiple;
	Persona pedro;
	Persona juan;
	Persona pablo;


	@Before
	public void setUp() throws Exception
	{
		adoptar2Hijos=new AdoptarHijo(100,2);
		recibirseDeLicenciadoEnSistemas=new Recibirse(50,"Licenciado en sistemas");
		tener2Hijos=new TenerHijos(150,2);
		viajarABrasil=new Viajar(90,"Brasil");
		viajarAChapadmalal=new Viajar(110,"Chapadmalal");
		trabajarProgramador=new Trabajar(70,80000);

		viajarACataratas=new Viajar(80,"Cataratas");
		tener1Hijo=new TenerHijos(140,1);
		trabajarOficinista=new Trabajar(70,11000);
		suenioMultiple=new SuenioMultiple(1000 , Arrays.asList(viajarACataratas,tener1Hijo,trabajarOficinista));

		pedro=new Persona("Pedro",Arrays.asList(adoptar2Hijos,viajarAChapadmalal,recibirseDeLicenciadoEnSistemas),10,new Alocado());
		juan=new Persona("Juan",Arrays.asList(tener2Hijos,viajarABrasil,suenioMultiple),100,new Realista());
		pablo=new Persona("Pablo",Arrays.asList(trabajarProgramador,viajarABrasil,tener2Hijos,adoptar2Hijos),200,new Obsesivo());
	}

	/*SUENIOS*/
	@Test
	public void testTener1HijoEsAmbicioso() {
		assertTrue(tener1Hijo.esAmbicioso());
	}
	
	@Test
	public void testViajarACataratasNoEsAmbicioso() {
		assertFalse(viajarACataratas.esAmbicioso());
	}

	//PEDRO

	
	public void pedroCumpliSuenios() {
		pedro.setCarrerasQueQuiereEstudiar(List.of("Licenciado en sistemas"));
		pedro.cumplir(recibirseDeLicenciadoEnSistemas);
		pedro.cumplir(viajarAChapadmalal);
		pedro.cumplir(adoptar2Hijos);
	}

	@Test
	public void testPedroSeRecibeDeLicenciadoEnSistemas() {
		pedro.setCarrerasQueQuiereEstudiar(List.of("Licenciado en sistemas"));
		pedro.cumplir(recibirseDeLicenciadoEnSistemas);
		assertEquals(60,pedro.getFelicidonios(), 0.001);
		assertTrue(pedro.getCarrerasCompletadas().contains("Licenciado en sistemas"));
		assertTrue(recibirseDeLicenciadoEnSistemas.getCumplido());
	}

	@Test(expected=RuntimeException.class)
	public void testPedroYaEstaRecibidoDeLicenciadoEnSistemas() {
		pedro.setCarrerasQueQuiereEstudiar(List.of("Licenciado en sistemas"));
		pedro.cumplir(recibirseDeLicenciadoEnSistemas);
		pedro.cumplir(recibirseDeLicenciadoEnSistemas);
	}

	@Test(expected=SuenioNoPendienteException.class)
	public void testPedroNoPuedeCumplirViajarABrasil() {
		pedro.cumplir(viajarABrasil);
	}

	@Test
	public void testPedroCumpleCualquierSuenio() {
		pedro.cumplirSuenioElegido();
		assertEquals(110,pedro.getFelicidonios(), 0.001);
		assertTrue(pedro.getSuenios().stream().anyMatch(s -> !s.estaPendiente()));
	}
	
	@Test
	public void testPedroEsAmbiciosa() {
		pedroCumpliSuenios();
		assertTrue(pedro.esAmbiciosa());
	}
	
	@Test
	public void testPedroEsFeliz() {
		pedroCumpliSuenios();
		assertTrue(pedro.esFeliz());
	}

	//JUAN

	@Test
	public void testJuanViajaABrasil() {
		juan.cumplir(viajarABrasil);
		assertEquals(190,juan.getFelicidonios(), 0.001);
		assertTrue(juan.getLugaresVisitados().contains("Brasil"));
	}

	@Test(expected=RuntimeException.class)
	public void testJuanNoPuedeCumplirSuenioMultiple() {
		juan.setSueldoPretendido(11000);
		juan.cumplir(suenioMultiple);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testJuanNoEstudiaAlgoQueNoQuiere() {
		juan.setCarrerasQueQuiereEstudiar(List.of("Medicina"));
		juan.getSuenios().add(recibirseDeLicenciadoEnSistemas);
		juan.cumplir(recibirseDeLicenciadoEnSistemas);
	}

	@Test(expected=RuntimeException.class)
	public void testJuanCumpleElMayorSuenio() {
		juan.setSueldoPretendido(10000);
		juan.cumplirSuenioElegido();
		assertEquals(1,juan.getCantidadHijos(), 0.001);
		assertEquals(390,juan.getFelicidonios(), 0.001);
		assertFalse(tener1Hijo.getCumplido());
		assertTrue(suenioMultiple.getCumplido());
		assertEquals(290, suenioMultiple.felicidonios(), 0.001);
	}

	//PABLO


	@Test
	public void testPabloViajaABrasil() {
		pablo.cumplir(viajarABrasil);
		assertEquals(290,pablo.getFelicidonios(), 0.001);
		assertTrue(pablo.getLugaresVisitados().contains("Brasil"));
	}

	@Test(expected=AdoptarHijoException.class)
	public void testPabloNoAdoptarHijosLuegoDeTenerlos() {
		pablo.cumplir(tener2Hijos);
		pablo.cumplir(adoptar2Hijos);
	}
	
	@Test
	public void testPabloNoAceptaTrabajarDeProgramador() {
		pablo.setSueldoPretendido(100000);
		pablo.cumplir(trabajarProgramador);
	}

	@Test(expected=SueldoNoDeseadoException.class)
	public void testPabloCumpleElPrimeroSuenio() {
		pablo.setSueldoPretendido(70000);
		pablo.cumplirSuenioElegido();
		assertEquals(270,pablo.getFelicidonios(), 0.001);
		assertTrue(pablo.getSueldoPretendido().compareTo(80000) == 0);
		assertTrue(trabajarProgramador.getCumplido());
	}

}

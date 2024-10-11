package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

public class IPokedexFactoryTest {
	
	@Before
	public void initTestEnvironment() {
		IPokedexFactory mockedPokedexFactory = Mockito.mock(IPokedexFactory.class);
		// Mockito.when(mockedPokedexFactory.createPokedex()).thenReturn("monlogin");
	}
	@After
	public void destroyTestEnvironment() {
	// cette méthode est exécutée après chaque test
	}
	
	@Test
	public void primeFactor2Test()
	{
		assertEquals("test", "test");
	}
}

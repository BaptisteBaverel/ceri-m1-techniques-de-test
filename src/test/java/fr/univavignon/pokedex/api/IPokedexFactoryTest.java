package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;
import java.lang.IllegalArgumentException;

public class IPokedexFactoryTest {
	
	private IPokemonMetadataProvider mockedPokemonMetadataProvider;
	private IPokemonFactory mockedPokemonFactory;
	private IPokedex mockedPokedex;
	private IPokedexFactory mockedPokedexFactory;
		
	@Before
	public void initTestEnvironment() {
		mockedPokedexFactory = Mockito.mock(IPokedexFactory.class);
		mockedPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
		mockedPokemonFactory = Mockito.mock(IPokemonFactory.class);
		mockedPokedex = Mockito.mock(IPokedex.class);
		
		Mockito.when(mockedPokedexFactory.createPokedex(mockedPokemonMetadataProvider, mockedPokemonFactory)).thenReturn(mockedPokedex);
		Mockito.when(mockedPokedexFactory.createPokedex(mockedPokemonMetadataProvider, null)).thenReturn(null);
		Mockito.when(mockedPokedexFactory.createPokedex(null, mockedPokemonFactory)).thenReturn(null);
	}

	@After
	public void destroyTestEnvironment() {
	// cette méthode est exécutée après chaque test
	}
	
	@Test
	public void createPokedexTest() {
		IPokedex createdPokedex = 
				mockedPokedexFactory.createPokedex(mockedPokemonMetadataProvider, mockedPokemonFactory);
		assertNotNull(createdPokedex);
		assertEquals(mockedPokedex, createdPokedex);
	}
	
	@Test
	public void createPokedexNullMetadataExceptionTest() {
		IPokedex createdPokedex = mockedPokedexFactory.createPokedex(null, mockedPokemonFactory);

		assertNull(createdPokedex);
	}
	
	@Test
	public void createPokedexNullPokemonFactoryExceptionTest() {
		IPokedex createdPokedex = mockedPokedexFactory.createPokedex(mockedPokemonMetadataProvider, null);

		assertNull(createdPokedex);
	}
}

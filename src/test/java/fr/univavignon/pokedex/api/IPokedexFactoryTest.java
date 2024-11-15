package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;
import java.lang.IllegalArgumentException;

public class IPokedexFactoryTest {
	
	private PokemonMetadataProvider pokemonMetadataProvider;
	private PokemonFactory pokemonFactory;
	private Pokedex pokedex;
	private PokedexFactory pokedexFactory;
		
	@Before
	public void initTestEnvironment() {
		pokedexFactory = new PokedexFactory();
		pokemonMetadataProvider = new PokemonMetadataProvider();
		pokemonFactory = new PokemonFactory();
		pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
	}

	@After
	public void destroyTestEnvironment() {
	// cette méthode est exécutée après chaque test
	}
	
	@Test
	public void createPokedexTest() {
		IPokedex createdPokedex = 
				pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
		assertNotNull(createdPokedex);
		assertEquals(pokedex, createdPokedex);
	}
	
	@Test
	public void createPokedexNullMetadataExceptionTest() {
		IPokedex createdPokedex = pokedexFactory.createPokedex(null, pokemonFactory);

		assertNull(createdPokedex);
	}
	
	@Test
	public void createPokedexNullPokemonFactoryExceptionTest() {
		IPokedex createdPokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, null);

		assertNull(createdPokedex);
	}
}

package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class IPokemonMetadataProviderTest {

	private PokemonMetadata defaultPokemon;

	@Before
	public void initTestEnvironment() {
		//IPokedexFactory mockedPokedexFactory = Mockito.mock(IPokedexFactory.class);
		//PokemonMetadata pokemonMetadata = new PokemonMetadata(0, null, 0, 0, 0);
		//Mockito.when(mockedPokedexFactory.getPokemonMetadata(1)).thenReturn(pokemonMetadata);
		
		//defaultPokemon = pokemonMetadata;
	}
	@After
	public void destroyTestEnvironment() {
		
	}
	
	@Test
	public void primeFactorTest()
	{
		assertEquals("test", "test");
	}
	
}

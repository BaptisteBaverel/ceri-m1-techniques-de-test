package fr.univavignon.pokedex.api;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PokemonMetadataProviderTest {

	private PokemonMetadata defaultPokemonMetadata;
	private PokemonMetadataProvider pokemonMetadataProvider;

	@Before
	public void initTestEnvironment() {
		pokemonMetadataProvider = new PokemonMetadataProvider();
		defaultPokemonMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
	}

	@After
	public void destroyTestEnvironment() {
		
	}
	
	@Test
	public void getMetadataTest() throws PokedexException {
		PokemonMetadata metadata = pokemonMetadataProvider.getPokemonMetadata(0);
		assertNotNull(metadata);

		assertEquals(defaultPokemonMetadata.getIndex(), metadata.getIndex());
		assertEquals(defaultPokemonMetadata.getName(), metadata.getName());
		assertEquals(defaultPokemonMetadata.getAttack(), metadata.getAttack());
		assertEquals(defaultPokemonMetadata.getDefense(), metadata.getDefense());
		assertEquals(defaultPokemonMetadata.getStamina(), metadata.getStamina());
	}
	
	@Test
	public void invalidIdExceptionTest() {
		PokedexException exception = assertThrows(PokedexException.class, () -> {
			pokemonMetadataProvider.getPokemonMetadata(-1);
		});

		assertEquals(exception.getMessage(), "Invalid Id");
		
		PokedexException exception2 = assertThrows(PokedexException.class, () -> {
			pokemonMetadataProvider.getPokemonMetadata(155);
		});

		assertEquals(exception2.getMessage(), "Invalid Id");
	}
	
}

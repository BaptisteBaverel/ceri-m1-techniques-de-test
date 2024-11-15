package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {

	private PokemonMetadata defaultPokemonMetadata;
	private IPokemonMetadataProvider mockedPokemonMetadataProvider;

	@Before
	public void initTestEnvironment() throws PokedexException {
		
		mockedPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);

		defaultPokemonMetadata = new PokemonMetadata(0, null, 0, 0, 0);
		PokedexException exception = new PokedexException("Invalid Id");
		Mockito.when(mockedPokemonMetadataProvider.getPokemonMetadata(1)).thenReturn(defaultPokemonMetadata);
		Mockito.when(mockedPokemonMetadataProvider.getPokemonMetadata(-1)).thenThrow(exception);
		Mockito.when(mockedPokemonMetadataProvider.getPokemonMetadata(155)).thenThrow(exception);
	}

	@After
	public void destroyTestEnvironment() {
		
	}
	
	@Test
	public void getMetadataTest() throws PokedexException {
		PokemonMetadata metadata = mockedPokemonMetadataProvider.getPokemonMetadata(1);
		assertNotNull(metadata);
		assertEquals(defaultPokemonMetadata, metadata);
	}
	
	@Test
	public void invalidIdExceptionTest() {
		PokedexException exception = assertThrows(PokedexException.class, () -> {
			mockedPokemonMetadataProvider.getPokemonMetadata(-1);
		});

		assertEquals(exception.getMessage(), "Invalid Id");
		
		PokedexException exception2 = assertThrows(PokedexException.class, () -> {
			mockedPokemonMetadataProvider.getPokemonMetadata(155);
		});

		assertEquals(exception2.getMessage(), "Invalid Id");
	}
	
}

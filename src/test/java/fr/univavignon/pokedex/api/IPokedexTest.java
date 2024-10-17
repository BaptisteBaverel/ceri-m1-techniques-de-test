package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;

public class IPokedexTest {
	private Pokemon bulbizarre,	aquali;
	private IPokedex mockedPokedex;

	@Before
	public void initTestEnvironment() {
		bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		aquali = 	 new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
		
		mockedPokedex = Mockito.mock(IPokedex.class);
		Mockito.when(mockedPokedex.size()).thenReturn(2);
		Mockito.when(mockedPokedex.addPokemon(bulbizarre)).thenReturn(1);
		Mockito.when(mockedPokedex.addPokemon(bulbizarre)).thenReturn(2);
	}

	@Test
	public void getSizeTest() throws PokedexException {
		int size = mockedPokedex.size();
		assertTrue(size >=0 && size < 151 );
	}
}

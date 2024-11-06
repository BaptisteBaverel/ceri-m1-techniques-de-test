package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IPokedexTest {
	private Pokemon bulbizarre,	aquali;
	private IPokedex mockedPokedex;

	private Comparator<Pokemon> pokemonComparator;
	private List<Pokemon> defaultListPokemon;
	private List<Pokemon> sortedListPokemon;

	@Before
	public void initTestEnvironment() throws PokedexException {
		bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		aquali = 	 new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
		PokedexException exception = new PokedexException("Invalid Id");

		defaultListPokemon = new ArrayList<Pokemon>();
		defaultListPokemon.add(aquali);
		defaultListPokemon.add(bulbizarre);

		sortedListPokemon = new ArrayList<Pokemon>();
		sortedListPokemon.add(bulbizarre);
		sortedListPokemon.add(aquali);

		mockedPokedex = Mockito.mock(IPokedex.class);
		Mockito.when(mockedPokedex.size()).thenReturn(2);
		Mockito.when(mockedPokedex.addPokemon(bulbizarre)).thenReturn(1);
		Mockito.when(mockedPokedex.addPokemon(aquali)).thenReturn(2);

		Mockito.when(mockedPokedex.getPokemon(2)).thenReturn(aquali);
		Mockito.when(mockedPokedex.getPokemon(-1)).thenThrow(exception);
		Mockito.when(mockedPokedex.getPokemon(155)).thenThrow(exception);

		Mockito.when(mockedPokedex.getPokemons()).thenReturn(defaultListPokemon);

		pokemonComparator = new Comparator<Pokemon>() {
			public int compare(Pokemon o1, Pokemon o2) {
				return o1.getIndex() - o2.getIndex();
			}
		};
		Mockito.when(mockedPokedex.getPokemons(pokemonComparator)).thenReturn(sortedListPokemon);
	}

	@Test
	public void getSizeTest() {
		int size = mockedPokedex.size();
		assertTrue(size >=0 && size < 151 );
	}

	@Test
	public void addPokemonTest() {
		assertEquals(2, mockedPokedex.addPokemon(aquali));
		assertEquals(1, mockedPokedex.addPokemon(bulbizarre));
	}

	@Test
	public void getPokemonTest() throws PokedexException {
		assertEquals(aquali, mockedPokedex.getPokemon(2));

		PokedexException exception1 = assertThrows(PokedexException.class, () -> {
			mockedPokedex.getPokemon(-1);
		});
		PokedexException exception2 = assertThrows(PokedexException.class, () -> {
			mockedPokedex.getPokemon(155);
		});

		assertEquals(exception1.getMessage(), "Invalid Id");
		assertEquals(exception2.getMessage(), "Invalid Id");
	}

	@Test
	public void getPokemonsTest() {
		assertEquals(defaultListPokemon, mockedPokedex.getPokemons());
	}

	@Test
	public void getPokemonsOrderedTest() {
		assertEquals(sortedListPokemon, mockedPokedex.getPokemons(pokemonComparator));
	}
}

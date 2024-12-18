package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PokedexTest {
	private Pokemon bulbizarre,	aquali;
	private Pokedex pokedex, pokedexFormated;
	private Comparator<Pokemon> pokemonComparator;
	private List<Pokemon> defaultListPokemon;
	private List<Pokemon> sortedListPokemon;
	private PokemonMetadata defaultPokemonMetadata;

	@Before
	public void initTestEnvironment() {
		defaultPokemonMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);


		pokedex = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory());
		bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		aquali = 	 new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

		pokedexFormated = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory());
		pokedexFormated.addPokemon(aquali);
		pokedexFormated.addPokemon(bulbizarre);

		defaultListPokemon = new ArrayList<Pokemon>();
		defaultListPokemon.add(aquali);
		defaultListPokemon.add(bulbizarre);

		sortedListPokemon = new ArrayList<Pokemon>();
		sortedListPokemon.add(bulbizarre);
		sortedListPokemon.add(aquali);

		pokemonComparator = new Comparator<Pokemon>() {
			public int compare(Pokemon o1, Pokemon o2) {
				return o1.getIndex() - o2.getIndex();
			}
		};
	}

	@Test
	public void getSizeTest() {
		int size = pokedex.size();
		assertTrue(size >= 0 && size < 151 );
	}

	@Test
	public void addPokemonTest() {
		assertEquals(0, pokedex.addPokemon(aquali));
		assertEquals(1, pokedex.addPokemon(bulbizarre));
	}

	@Test
	public void getPokemonTest() throws PokedexException {
		assertEquals(aquali, pokedexFormated.getPokemon(133));
		assertNull(pokedexFormated.getPokemon(120));

		PokedexException exception1 = assertThrows(PokedexException.class, () -> {
			pokedex.getPokemon(-1);
		});
		PokedexException exception2 = assertThrows(PokedexException.class, () -> {
			pokedex.getPokemon(155);
		});

		assertEquals(exception1.getMessage(), "Invalid Id");
		assertEquals(exception2.getMessage(), "Invalid Id");
	}

	@Test
	public void getPokemonsTest() {
		assertEquals(defaultListPokemon, pokedexFormated.getPokemons());
	}

	@Test
	public void getPokemonsOrderedTest() {
		assertEquals(sortedListPokemon, pokedexFormated.getPokemons(pokemonComparator));
	}

	@Test
	public void getPokemonMetadataTest() throws PokedexException {
		PokemonMetadata metadata = pokedex.getPokemonMetadata(0);
		assertNotNull(metadata);

		assertEquals(defaultPokemonMetadata.getIndex(), metadata.getIndex());

		PokedexException exception = assertThrows(PokedexException.class, () -> {
			pokedex.getPokemonMetadata(-1);
		});

		assertEquals(exception.getMessage(), "Invalid Id");
	}

	@Test
	public void createPokemonTest() {
		Pokemon createdBulbizarre = pokedex.createPokemon(0, 613, 64, 4000, 4);
		assertNotNull(createdBulbizarre);
	}

}

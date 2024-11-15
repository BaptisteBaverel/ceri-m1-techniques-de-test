package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;
import java.lang.IllegalArgumentException;

public class IPokemonTrainerFactoryTest {

	private String defaultName;
	private Team defaultTeam;

	private PokedexFactory pokedexFactory;
	private PokemonTrainerFactory pokemonTrainerFactory;

	@Before
	public void initTestEnvironment() {
		defaultName = "trainer";
		defaultTeam = Team.INSTINCT;
		pokedexFactory = new PokedexFactory();
		Pokedex pokedex = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory());

		pokemonTrainerFactory = new PokemonTrainerFactory();
	}
	
	@Test
	public void createTrainerTest() {
		PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer(defaultName, defaultTeam, pokedexFactory);
		
		assertNotNull(pokemonTrainer);
		assertEquals(defaultName, pokemonTrainer.getName());
		assertEquals(defaultTeam, pokemonTrainer.getTeam());
		assertNotNull(pokemonTrainer.getPokedex());
	}
	
	@Test
	public void createTrainerInvalidNameTest() {
		PokemonTrainer pokemonTrainer1 = pokemonTrainerFactory.createTrainer("", defaultTeam, pokedexFactory);
		PokemonTrainer pokemonTrainer2 = pokemonTrainerFactory.createTrainer(null, defaultTeam, pokedexFactory);
		
		assertNull(pokemonTrainer1);
		assertNull(pokemonTrainer2);
	}
	
	@Test
	public void createTrainerInvalidTeamTest() {
		PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer(defaultName, null, pokedexFactory);
		
		assertNull(pokemonTrainer);
	}
	
	@Test
	public void createTrainerInvalidPokedexFactoryTest() {
		PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer(defaultName, defaultTeam, null);
		
		assertNull(pokemonTrainer);
	}
}

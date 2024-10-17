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

	private IPokedexFactory mockedPokedexFactory;
	private IPokedex mockedPokedex;
	private IPokemonTrainerFactory mockedPokemonTrainerFactory;

	private PokemonTrainer defaultPokemonTrainer;
	
	@Before
	public void initTestEnvironment() {
		defaultName = "trainer";
		defaultTeam = Team.INSTINCT;
		mockedPokedexFactory = Mockito.mock(IPokedexFactory.class);
		mockedPokedex = Mockito.mock(IPokedex.class);
		
		defaultPokemonTrainer = new PokemonTrainer(defaultName, defaultTeam, mockedPokedex);
		
		mockedPokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
		Mockito.when(mockedPokemonTrainerFactory.createTrainer(defaultName, defaultTeam, mockedPokedexFactory)).thenReturn(defaultPokemonTrainer);
		Mockito.when(mockedPokemonTrainerFactory.createTrainer(null, defaultTeam, mockedPokedexFactory)).thenReturn(null);
		Mockito.when(mockedPokemonTrainerFactory.createTrainer("", defaultTeam, mockedPokedexFactory)).thenReturn(null);
		Mockito.when(mockedPokemonTrainerFactory.createTrainer(defaultName, null, mockedPokedexFactory)).thenReturn(null);
		Mockito.when(mockedPokemonTrainerFactory.createTrainer(defaultName, defaultTeam, null)).thenReturn(null);
	}
	
	@Test
	public void createTrainerTest() {
		PokemonTrainer pokemonTrainer = mockedPokemonTrainerFactory.createTrainer(defaultName, defaultTeam, mockedPokedexFactory);
		
		assertNotNull(pokemonTrainer);
		assertEquals(defaultPokemonTrainer, pokemonTrainer);
		assertEquals(defaultName, pokemonTrainer.getName());
		assertEquals(mockedPokedex, pokemonTrainer.getPokedex());
		assertEquals(defaultTeam, pokemonTrainer.getTeam());
	}
	
	@Test
	public void createTrainerInvalidNameTest() {
		PokemonTrainer pokemonTrainer1 = mockedPokemonTrainerFactory.createTrainer("", defaultTeam, mockedPokedexFactory);
		PokemonTrainer pokemonTrainer2 = mockedPokemonTrainerFactory.createTrainer(null, defaultTeam, mockedPokedexFactory);
		
		assertNull(pokemonTrainer1);
		assertNull(pokemonTrainer2);
	}
	
	@Test
	public void createTrainerInvalidTeamTest() {
		PokemonTrainer pokemonTrainer = mockedPokemonTrainerFactory.createTrainer(defaultName, null, mockedPokedexFactory);
		
		assertNull(pokemonTrainer);
	}
	
	@Test
	public void createTrainerInvalidPokedexFactoryTest() {
		PokemonTrainer pokemonTrainer = mockedPokemonTrainerFactory.createTrainer(defaultName, defaultTeam, null);
		
		assertNull(pokemonTrainer);
	}
}

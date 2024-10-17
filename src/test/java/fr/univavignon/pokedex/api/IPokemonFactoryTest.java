package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;

public class IPokemonFactoryTest {
	
	private Pokemon bulbizarre,	aquali;
	private IPokemonFactory mockedPokemonFactory;

	@Before
	public void initTestEnvironment() {
		bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		aquali = 	 new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
		mockedPokemonFactory = Mockito.mock(IPokemonFactory.class);
		
		Mockito.when(mockedPokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);
		Mockito.when(mockedPokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(aquali);
		
		Mockito.when(mockedPokemonFactory.createPokemon(-1, 613, 64, 4000, 4)).thenReturn(null);
		Mockito.when(mockedPokemonFactory.createPokemon(155, 613, 64, 4000, 4)).thenReturn(null);

		Mockito.when(mockedPokemonFactory.createPokemon(0, -1, 64, 4000, 4)).thenReturn(null);

		Mockito.when(mockedPokemonFactory.createPokemon(0, 613, -1, 4000, 4)).thenReturn(null);
		
		Mockito.when(mockedPokemonFactory.createPokemon(0, 613, 64, -1, 4)).thenReturn(null);
		
		Mockito.when(mockedPokemonFactory.createPokemon(0, 613, 64, 4000, -1)).thenReturn(null);
	}
	
	@Test
	public void createPokemonTest() {
		Pokemon createdBulbizarre = mockedPokemonFactory.createPokemon(0, 613, 64, 4000, 4);
		Pokemon createdAquali = mockedPokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
		
		assertEquals(createdBulbizarre, bulbizarre);
		assertEquals(createdAquali, aquali);
		
		assertTrue(createdBulbizarre.getAttack() >= 126 && createdBulbizarre.getAttack() <= 126+15);
		assertTrue(createdBulbizarre.getDefense() >= 126 && createdBulbizarre.getDefense() <= 126+15);
		assertTrue(createdBulbizarre.getStamina() >= 90 && createdBulbizarre.getStamina() <= 90+15);
		
		assertTrue(aquali.getAttack() >= 186 && aquali.getAttack() <= 186+15);
		assertTrue(aquali.getDefense() >= 168 && aquali.getDefense() <= 168+15);
		assertTrue(aquali.getStamina() >= 260 && aquali.getStamina() <= 260+15);
	}
	
	@Test
	public void createPokemonInvalidIdTest() {
		Pokemon createdBulbizarre1 = mockedPokemonFactory.createPokemon(-1,  613, 64, 4000, 4);
		Pokemon createdBulbizarre2 = mockedPokemonFactory.createPokemon(155,  613, 64, 4000, 4);
		
		assertNull(createdBulbizarre1);
		assertNull(createdBulbizarre2);
	}
	
	@Test
	public void createPokemonInvalidCPTest() {
		Pokemon createdBulbizarre = mockedPokemonFactory.createPokemon(0, -1, 64, 4000, 4);
		
		assertNull(createdBulbizarre);
	}
	
	@Test	
	public void createPokemonInvalidHPTest() {
		Pokemon createdBulbizarre = mockedPokemonFactory.createPokemon(0,  613, -1, 4000, 4);

		assertNull(createdBulbizarre);
	}
	
	@Test
	public void createPokemonInvalidDustTest() {
		Pokemon createdBulbizarre = mockedPokemonFactory.createPokemon(0,  613, 64, -1, 4);

		assertNull(createdBulbizarre);
	}
	
	@Test
	public void createPokemonInvalidCandyTest() {
		Pokemon createdBulbizarre = mockedPokemonFactory.createPokemon(0,  613, 64, 4000, -1);

		assertNull(createdBulbizarre);
	}
}

package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokemonFactoryTest {
	
	private Pokemon bulbizarre,	aquali;
	private PokemonFactory pokemonFactory;

	@Before
	public void initTestEnvironment() {
		pokemonFactory = new PokemonFactory();

		bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		aquali = 	 new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
	}
	
	@Test
	public void createPokemonTest() {
		Pokemon createdBulbizarre = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
		Pokemon createdAquali = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);

		assertEquals(createdBulbizarre.getIndex(), bulbizarre.getIndex());
		assertEquals(createdBulbizarre.getName(), bulbizarre.getName());
		assertEquals(createdAquali.getIndex(), aquali.getIndex());
		assertEquals(createdAquali.getName(), aquali.getName());

		assertEquals(createdBulbizarre.getCp(), bulbizarre.getCp());
		assertEquals(createdBulbizarre.getHp(), bulbizarre.getHp());
		assertEquals(createdBulbizarre.getDust(), bulbizarre.getDust());
		assertEquals(createdBulbizarre.getCandy(), bulbizarre.getCandy());
		assertTrue(createdBulbizarre.getIv() > 0 && createdBulbizarre.getIv() <= 100);

		assertEquals(createdAquali.getCp(), aquali.getCp());
		assertEquals(createdAquali.getHp(), aquali.getHp());
		assertEquals(createdAquali.getDust(), aquali.getDust());
		assertEquals(createdAquali.getCandy(), aquali.getCandy());
		assertTrue(createdAquali.getIv() > 0 && createdAquali.getIv() <= 100);

		assertTrue(createdBulbizarre.getAttack() >= bulbizarre.getAttack() && createdBulbizarre.getAttack() <= bulbizarre.getAttack()+15);
		assertTrue(createdBulbizarre.getDefense() >= bulbizarre.getDefense() && createdBulbizarre.getDefense() <= bulbizarre.getDefense()+15);
		assertTrue(createdBulbizarre.getStamina() >= bulbizarre.getStamina() && createdBulbizarre.getStamina() <= bulbizarre.getStamina()+15);

		assertTrue(createdAquali.getAttack() >= aquali.getAttack() && createdAquali.getAttack() <= aquali.getAttack()+15);
		assertTrue(createdAquali.getDefense() >= aquali.getDefense() && createdAquali.getDefense() <= aquali.getDefense()+15);
		assertTrue(createdAquali.getStamina() >= aquali.getStamina() && createdAquali.getStamina() <= aquali.getStamina()+15);
	}
	
	@Test
	public void createPokemonInvalidIdTest() {
		Pokemon createdBulbizarre1 = pokemonFactory.createPokemon(-1,  613, 64, 4000, 4);
		Pokemon createdBulbizarre2 = pokemonFactory.createPokemon(155,  613, 64, 4000, 4);
		
		assertNull(createdBulbizarre1);
		assertNull(createdBulbizarre2);
	}
	
	@Test
	public void createPokemonInvalidCPTest() {
		Pokemon createdBulbizarre = pokemonFactory.createPokemon(0, -1, 64, 4000, 4);
		
		assertNull(createdBulbizarre);
	}
	
	@Test	
	public void createPokemonInvalidHPTest() {
		Pokemon createdBulbizarre = pokemonFactory.createPokemon(0,  613, -1, 4000, 4);

		assertNull(createdBulbizarre);
	}
	
	@Test
	public void createPokemonInvalidDustTest() {
		Pokemon createdBulbizarre = pokemonFactory.createPokemon(0,  613, 64, -1, 4);

		assertNull(createdBulbizarre);
	}
	
	@Test
	public void createPokemonInvalidCandyTest() {
		Pokemon createdBulbizarre = pokemonFactory.createPokemon(0,  613, 64, 4000, -1);

		assertNull(createdBulbizarre);
	}
}

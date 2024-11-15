package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * IPokedex interface. An IPokedex aims to store all information about
 * captured pokemon, as their default metadata as well.
 * 
 * @author fv
 */
public class Pokedex implements IPokedex {
	private final PokemonMetadataProvider pokemonMetadataProvider;
	private final PokemonFactory pokemonFactory;

	Pokedex() {
		pokemonMetadataProvider = new PokemonMetadataProvider();
		pokemonFactory = new PokemonFactory();
	}

	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		return pokemonMetadataProvider.getPokemonMetadata(index);
	}

	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
	}

	List<Pokemon> pokemonList;
	/**
	 * Returns the number of pokemon this pokedex contains.
	 * 
	 * @return Number of pokemon in this pokedex.
	 */
	public int size() {
		return pokemonList.size();
	}
	
	/**
	 * Adds the given <tt>pokemon</tt> to this pokedex and returns
	 * it unique index.
	 * 
	 * @param pokemon Pokemon to add to this pokedex.
	 * @return Index of this pokemon relative to this pokedex.
	 */
	public int addPokemon(Pokemon pokemon) {
		pokemonList.add(pokemon);
		return pokemonList.indexOf(pokemon);
	}
	
	/**
	 * Locates the pokemon identified by the given <tt>id</tt>.
	 * 
	 * @param id Unique pokedex relative identifier.
	 * @return Pokemon denoted by the given identifier.
	 * @throws PokedexException If the given <tt>index</tt> is not valid.
	 */
	public Pokemon getPokemon(int id) throws PokedexException {
		if (id < 0 || id > 150) {
			throw new PokedexException("Invalid Id");
		}
		for (Pokemon poke: pokemonList) {
			if (poke.getIndex() == id) {
				return poke;
			}
		}
		return null;
	}
	
	/**
	 * Returns an unmodifiable list of all pokemons this pokedex contains.
	 * 
	 * @return Unmodifiable list of all pokemons.
	 */
	public List<Pokemon> getPokemons() {
		return Collections.unmodifiableList(pokemonList);
	}

	/**
	 * Returns an unmodifiable list of all pokemons this pokedex contains.
	 * The list view will be sorted using the given <tt>order</tt>.
	 * 
	 * @param order Comparator instance used for sorting the created view.
	 * @return Sorted unmodifiable list of all pokemons.
	 */
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		List<Pokemon> cloned = new ArrayList<Pokemon>(pokemonList);
		cloned.sort(order);
		return Collections.unmodifiableList(cloned);
	}
	
}

package fr.univavignon.pokedex.api;

/**
 * Factory interface for class that aims to create PokemonTrainer instance.
 * 
 * @author fv
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

	/**
	 * Creates and returns a PokemonTrainer instance.
	 * 
	 * @param name Name of the created trainer.
	 * @param team Team of the created trainer.
	 * @param pokedexFactory Factory to use for creating associated pokedex instance.
	 * @return Created trainer instance.
	 */
	public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
		if (name == null || team == null || pokedexFactory == null) {
			return null;
		}
		IPokedex pokedex = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());

		return new PokemonTrainer(name, team, pokedex);
	}
	
}

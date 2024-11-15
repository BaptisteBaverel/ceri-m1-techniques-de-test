package fr.univavignon.pokedex.api;

/**
 * Factory interface for class that aims to create IPokedex instance.
 *
 * @author fv
 */
public class PokedexFactory implements IPokedexFactory {

    /**
     * Creates a new pokedex instance using the given
     * <tt>metadataProvider</tt> and <tt>pokemonFactory</tt>.
     *
     * @param metadataProvider Metadata provider the created pokedex will use.
     * @param pokemonFactory Pokemon factory the created pokedex will use.
     * @return Created pokedex instance.
     */
    public Pokedex createPokedex(PokemonMetadataProvider metadataProvider, PokemonFactory pokemonFactory) {
        if (metadataProvider == null || pokemonFactory == null) {
            return null;
        }
        return new Pokedex(metadataProvider, pokemonFactory);
    }

}

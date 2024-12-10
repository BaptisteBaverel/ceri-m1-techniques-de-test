package fr.univavignon.pokedex.api;

/**
 * Factory interface for class that aims to create IPokedex instance.
 *
 * @author fv
 */
public class PokedexFactory implements IPokedexFactory {

    /**
     * Creates a new pokedex instance using the given
     * <code>metadataProvider</code> and <code>pokemonFactory</code>.
     *
     * @param metadataProvider Metadata provider the created pokedex will use.
     * @param pokemonFactory Pokemon factory the created pokedex will use.
     * @return Created pokedex instance.
     */
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        if (metadataProvider == null || pokemonFactory == null) {
            return null;
        }
        return new Pokedex(metadataProvider, pokemonFactory);
    }

}

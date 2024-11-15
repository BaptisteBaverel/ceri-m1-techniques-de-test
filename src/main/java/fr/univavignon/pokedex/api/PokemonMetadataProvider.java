package fr.univavignon.pokedex.api;

/**
 * An IPokemonMetadataProvider aims to provide PokemonMetadata
 * for a given pokemon index.
 *
 * @author fv
 */
public class PokemonMetadataProvider {
    /**
     * Retrieves and returns the metadata for the pokemon
     * denoted by the given <tt>index</tt>.
     *
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If the given <tt>index</tt> is not valid.
     */
    PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if(index > 150 || index < 0) {
            throw new PokedexException("Invalid Id");
        }

        PokemonMetadata metadata = null;
        switch (index) {
            case 0:
                metadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
                break;
            case 133:
                metadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);
                break;
        }

        return metadata;
    }
}

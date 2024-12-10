package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    /**
     * Creates a pokemon instance computing it IVs.
     *
     * @param index Pokemon index.
     * @param cp Pokemon CP.
     * @param hp Pokemon HP.
     * @param dust Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Created pokemon instance.
     */
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonMetadata metadata;
        if(cp < 0 || hp < 0 || dust < 0 || candy < 0) {
            return null;
        }

        int iv = (int)(Math.random() * (101));
        try {
            metadata = (new PokemonMetadataProvider()).getPokemonMetadata(index);
        } catch (PokedexException e) {
            return null;
        }

        return new Pokemon(metadata.getIndex(), metadata.getName(), metadata.getAttack() + ((iv*15)/100), metadata.getDefense() + ((iv*15)/100), metadata.getStamina() + ((iv*15)/100), cp, hp, dust, candy, iv);
    }
}

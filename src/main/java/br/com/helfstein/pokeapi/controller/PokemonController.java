package br.com.helfstein.pokeapi.controller;

import br.com.helfstein.pokeapi.domain.Pokemon;
import br.com.helfstein.pokeapi.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @GetMapping
    public List<Pokemon> listarPokemon () {
        return pokemonRepository.findAll();
    }
    @PostMapping
    public void criarPokemon (@RequestBody Pokemon pokemon) {
        pokemonRepository.save(pokemon);
    }
    @PutMapping
    public void atualizarPokemon (@RequestBody Pokemon pokemon) {
        Pokemon pokemon1 = pokemonRepository.findById(pokemon.getId()).get();
        pokemon1.setNome(pokemon.getNome());
        pokemon1.setTipoPrincipal(pokemon.getTipoPrincipal());
        pokemon1.setTipoSecundario(pokemon.getTipoSecundario());
        pokemonRepository.save(pokemon1);
    }
    @DeleteMapping("/{id}")
    public void deletarPokemon(@PathVariable Integer id) {
        Pokemon pokemon = pokemonRepository.findById(id).get();
        pokemonRepository.delete(pokemon);
    }

    @GetMapping("/{id}")
    public Pokemon buscarPokemom (@PathVariable Integer id) {
        return pokemonRepository.findById(id).get();
    }
}

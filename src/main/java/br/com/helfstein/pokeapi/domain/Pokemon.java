package br.com.helfstein.pokeapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Pokemon {
    @Id @GeneratedValue
    private Integer id;
    private Integer numero;
    private String nome;
    private String tipoPrincipal;
    private String tipoSecundario;
}

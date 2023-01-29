package br.com.attornatus.gerenciar.pessoas.model.pessoa;

import br.com.attornatus.gerenciar.pessoas.model.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Table(name = "PESSOAS")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME", nullable = false)
    private String nome;
    @Column(name = "DATA_NASCIMENTO",nullable = false)
    private String dataNascimento;
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.MERGE)
    @Column(name = "ID_ENDERECO")
    private List<Endereco> endereco;

    public Pessoa(Pessoa pessoa){
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.dataNascimento = pessoa.getDataNascimento();
        this.endereco = Collections.singletonList(new Endereco());
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}

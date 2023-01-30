package br.com.attornatus.gerenciar.pessoas.model.endereco;

import br.com.attornatus.gerenciar.pessoas.model.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "ENDERECOS")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "LOGRADOURO", nullable = false)
    private String logradouro;
    @Column(name = "CEP", nullable = false)
    private String cep;
    @Column(name = "NUMERO")
    private String numero;
    @Column(name = "CIDADE", nullable = false)
    private String cidade;
    @Column(name = "END_PRINCIPAL", nullable = false)
    private Boolean isPrincipal;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "PESSOA_ID", nullable = true)
    private Pessoa pessoa;

    public Endereco (Endereco endereco) {
        this.logradouro = endereco.getLogradouro();
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
        this.isPrincipal = endereco.getIsPrincipal();
        this.pessoa = endereco.getPessoa();
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setPrincipal(Boolean principal) {
        isPrincipal = principal;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}

package br.com.attornatus.gerenciar.pessoas.controller;

import br.com.attornatus.gerenciar.pessoas.model.endereco.Endereco;
import br.com.attornatus.gerenciar.pessoas.model.endereco.EnderecoRepository;
import br.com.attornatus.gerenciar.pessoas.model.endereco.EnderecoService;
import br.com.attornatus.gerenciar.pessoas.model.pessoa.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/enderecos", produces = MediaType.APPLICATION_JSON_VALUE)
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco salvarEndereco(@RequestBody Endereco endereco) {
        System.out.println("salvarEndereco" + endereco.getCidade());
       // endereco.setPessoa(endereco.getId());
        return enderecoRepository.save(endereco);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Endereco> listarEnderecos(){
        return enderecoService.listarEnderecos();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Endereco buscarEnderecoPorId(@PathVariable("id") Long id){
        return enderecoService.buscarPorId(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado! "));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerEndereco(@PathVariable("id") Long id){
        enderecoService.buscarPorId(id)
                .map(endereco -> {
                    enderecoService.removerEndereco(endereco.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado! "));
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarEndereco(@PathVariable ("id") Long id, @RequestBody Endereco endereco){
        enderecoService.buscarPorId(id)
                .map(enderecoBase ->{
                    modelMapper.map(endereco, enderecoBase);
                    return Void.TYPE;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado! "));
    }
}

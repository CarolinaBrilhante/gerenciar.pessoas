package br.com.attornatus.gerenciar.pessoas.controller;

import br.com.attornatus.gerenciar.pessoas.model.pessoa.Pessoa;
import br.com.attornatus.gerenciar.pessoas.model.pessoa.PessoaRepository;
import br.com.attornatus.gerenciar.pessoas.model.pessoa.PessoaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa salvarPessoa(@RequestBody Pessoa pessoa ){
        return pessoaService.salvar(pessoa);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pessoa> listarPessoas(){
        return pessoaService.listarPessoas();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pessoa buscarPessoaPorId(@PathVariable("id") Long id){
        return pessoaService.buscarPorId(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada! "));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPessoa(@PathVariable("id") Long id){
       pessoaService.buscarPorId(id)
               .map(pessoa -> {
                   pessoaService.removerPessoa(pessoa.getId());
                   return Void.TYPE;
               }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada! "));
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPessoa(@PathVariable ("id") Long id, @RequestBody Pessoa pessoa){
        pessoaService.buscarPorId(id)
                .map(pessoaBase ->{
                    modelMapper.map(pessoa, pessoaBase);
                    pessoaService.atualizarPessoa(id, pessoaBase);
                    System.out.println("Pessoa Controller " + pessoaBase.getNome());

                    return Void.TYPE;

                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada! "));
    }
}

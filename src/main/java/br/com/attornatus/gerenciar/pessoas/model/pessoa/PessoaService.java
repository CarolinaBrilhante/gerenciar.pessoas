package br.com.attornatus.gerenciar.pessoas.model.pessoa;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa){

        return pessoaRepository.save(pessoa);
    }
    public List<Pessoa> listarPessoas(){

        return pessoaRepository.findAll();
    }
    public Optional<Pessoa> buscarPorId(Long id){
        return pessoaRepository.findById(id);
    }
    public void removerPessoa(Long id){
        pessoaRepository.deleteById(id);
    }

    public Pessoa atualizarPessoa(@PathVariable("id") long id, @RequestBody Pessoa pessoaEditada) {
        return pessoaRepository.findById(id)
                .map(record -> {
                    record.setNome(pessoaEditada.getNome());
                    record.setDataNascimento(pessoaEditada.getDataNascimento());
                    return pessoaRepository.save(record);
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada. "));
    }

}


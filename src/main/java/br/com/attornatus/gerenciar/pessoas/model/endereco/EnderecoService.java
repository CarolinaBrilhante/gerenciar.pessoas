package br.com.attornatus.gerenciar.pessoas.model.endereco;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Endereco salvar(Endereco endereco){

        return enderecoRepository.save(endereco);
    }
    public List<Endereco> listarEnderecos(){

        return enderecoRepository.findAll();
    }
    public Endereco atualizarEndereco(Long id, Endereco novoEndereco) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        if (enderecoOptional.isPresent()) {
            Endereco enderecoBanco = enderecoOptional.get();
            modelMapper.map(novoEndereco, enderecoBanco);
            return enderecoRepository.save(enderecoBanco);
        } else {
            throw new IllegalArgumentException("Endereço com id " + id + " não encontrado");
        }
    }
    public Optional<Endereco> buscarPorId(Long id){
        return enderecoRepository.findById(id);
    }
    public void removerEndereco(Long id){
        enderecoRepository.deleteById(id);
    }
}

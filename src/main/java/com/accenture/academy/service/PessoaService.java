package com.accenture.academy.service;

import com.accenture.academy.entity.Pessoa;
import com.accenture.academy.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public List<Pessoa> buscarPessoas () {
        return pessoaRepository.findAll();
    }


    public void salvarPessoa(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }

    public void alterarPessoa(Pessoa pessoa, Long id) {
        Pessoa pessoaBanco = getPessoa(id);

        BeanUtils.copyProperties(pessoa, pessoaBanco, "id");
        this.salvarPessoa(pessoaBanco);
    }

    private Pessoa getPessoa(Long id) {
        return pessoaRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao pesquisar pessoa"));
    }

    public void deletarPessoa(Long id) {
        Pessoa pessoaBanco = getPessoa(id);

        this.pessoaRepository.delete(pessoaBanco);
    }
}

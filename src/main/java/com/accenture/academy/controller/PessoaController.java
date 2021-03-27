package com.accenture.academy.controller;

import com.accenture.academy.entity.Pessoa;
import com.accenture.academy.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sistema")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @GetMapping("/pessoas")
    @ResponseStatus(HttpStatus.OK)
    public List<Pessoa> buscaPessoas() {
        return pessoaService.buscarPessoas();
    }

    @PostMapping("/pessoas")
    @ResponseStatus(HttpStatus.CREATED)
    public void salvarPessoa(@RequestBody Pessoa pessoa){
        pessoaService.salvarPessoa(pessoa);
    }

    @PutMapping("/pessoas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void alteraPessoa(@PathVariable("id") Long id, @RequestBody Pessoa pessoa) {
        pessoaService.alterarPessoa(pessoa, id);
    }

    @DeleteMapping("/pessoas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletaPessoa(@PathVariable("id") Long id) {
        pessoaService.deletarPessoa(id);
    }
}

package com.upt.lp.service;

import com.upt.lp.Recursos;
import com.upt.lp.Localizacao;
import com.upt.lp.Tipo;
import com.upt.lp.repository.RecursosRepository;
import com.upt.lp.repository.LocalizacaoRepository;
import com.upt.lp.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecursosService {

    @Autowired
    private RecursosRepository recursosRepository;

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    @Autowired
    private TipoRepository tipoRepository;

    // Método para obter todos os recursos
    public List<Recursos> getAllRecursos() {
        return recursosRepository.findAll();
    }

    // Método para obter um recurso por ID
    public Optional<Recursos> getRecursoById(int id) {
        return recursosRepository.findById(id);
    }

    // Método para criar um novo recurso
    public Recursos createRecurso(Recursos recurso) {
        // Verificar se Localizacao e Tipo existem
        Optional<Localizacao> localizacao = localizacaoRepository.findById(recurso.getLocalizacao().getIdLocalizacao());
        Optional<Tipo> tipo = tipoRepository.findById(recurso.getTipo().getIdTipo());

        if (localizacao.isPresent() && tipo.isPresent()) {
            recurso.setLocalizacao(localizacao.get());
            recurso.setTipo(tipo.get());
            return recursosRepository.save(recurso);
        } else {
            throw new RuntimeException("Localização ou Tipo não encontrados");
        }
    }

    // Método para atualizar um recurso existente
    public Optional<Recursos> updateRecurso(int id, Recursos recursoAtualizado) {
        return recursosRepository.findById(id).map(recurso -> {
            recurso.setNome(recursoAtualizado.getNome());
            recurso.setTelefone(recursoAtualizado.getTelefone());

            // Verificar Localizacao e Tipo
            Optional<Localizacao> localizacao = localizacaoRepository.findById(recursoAtualizado.getLocalizacao().getIdLocalizacao());
            Optional<Tipo> tipo = tipoRepository.findById(recursoAtualizado.getTipo().getIdTipo());

            if (localizacao.isPresent() && tipo.isPresent()) {
                recurso.setLocalizacao(localizacao.get());
                recurso.setTipo(tipo.get());
                return recursosRepository.save(recurso);
            } else {
                throw new RuntimeException("Localização ou Tipo não encontrados");
            }
        });
    }

    // Método para deletar um recurso
    public void deleteRecurso(int id) {
        recursosRepository.deleteById(id);
    }
    public List<Recursos> getRecursosByNome(String nome) {
        return recursosRepository.findByNome(nome);
    }
}

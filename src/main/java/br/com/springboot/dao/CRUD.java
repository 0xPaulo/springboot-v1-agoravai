package br.com.springboot.dao;

import java.util.List;

public interface CRUD<Objeto, ID> {
    Objeto pesquisaPeloId(ID id);
    List<Objeto> listaTodos();
    void insere(Objeto objeto);
    void atualiza(Objeto objeto);
    void remove(Objeto objeto);
    }

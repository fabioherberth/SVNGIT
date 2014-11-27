package br.com.dbsti.agenda.model.Interfaces;

import java.util.List;

public interface crudInterface {   
    
    public boolean salvar(Object bean);
    public boolean deletar(Object bean);
    public List listarTodos();
    public Object recuperarPorID(Object bean);
}

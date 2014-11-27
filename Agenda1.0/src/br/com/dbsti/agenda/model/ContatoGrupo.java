package br.com.dbsti.agenda.model;

public class ContatoGrupo {
private int idContatoGrupo;
private int contato;
private int grupo;
private String observacao;

    public int getIdContatoGrupo() {
        return idContatoGrupo;
    }
    
    public int getContato() {
        return contato;
    }

    public void setContato(int contato) {
        this.contato = contato;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}

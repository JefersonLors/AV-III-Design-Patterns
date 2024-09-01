package model.caretaker;

import model.originator.Originador;

import java.util.Stack;

//CARE TAKER NO MEMENTO
public class HistoricoCaretaker<M> {
    private Originador<M> arquivo;

    private Stack<M> historico;

    public HistoricoCaretaker(Originador<M> file){
        this.arquivo = file;
        this.historico = new Stack<>();
    }

    public void geraSnapshot() throws IllegalAccessException{
        this.historico.push(this.arquivo.checkpoint());
    }

    public void desfazer(){
        if(!this.historico.empty()){
            this.arquivo.restore(this.historico.pop());
        }
    }
}

package model.originator;

//ORIGINATOR NO MEMENTO
public interface Originador<M> {
    M checkpoint();
    void restore(M snapshot);
}

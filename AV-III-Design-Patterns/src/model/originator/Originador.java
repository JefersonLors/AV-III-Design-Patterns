package model.originator;

public interface Originador<M> {
    M checkpoint() throws IllegalAccessException;
    void restore(M snapshot);
}

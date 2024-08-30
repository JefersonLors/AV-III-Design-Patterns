package model.originator;

public interface Originador<M> {
    M checkpoint();
    void restore(M snapshot);
}

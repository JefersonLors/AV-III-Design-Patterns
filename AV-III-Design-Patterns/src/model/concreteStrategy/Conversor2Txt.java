package model.concreteStrategy;

import model.strategy.Conversor;

//CONCRETE STRATEGY NO STRATEGY
public class Conversor2Txt implements Conversor {
    @Override
    public String toASCII(String string) {
        return string;
    }

    @Override
    public String converte(String string) {
        return string;
    }
}

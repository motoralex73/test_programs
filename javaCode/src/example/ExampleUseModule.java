package example;

import generics.GenericConstructor;

public class ExampleUseModule {

    public static void main(String[] args) {
        int n = 1000;
        var v = new GenericConstructor.GenConstructor(n);
        v.showVal();
    }
}

package seminar7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@FunctionalInterface
interface MyFilterInterface {
    String removeNegCharacters(String n);
}

interface GenericInterface<T> {
    String join(T obj);
}


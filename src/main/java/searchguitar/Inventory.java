package searchguitar;

import java.util.List;
import java.util.LinkedList;

public class Inventory{

    private List<Guitar> guitars;

    Inventory(){
        guitars = new LinkedList<>();
    }

    void addGuitar(
            String serialNumber,
            double price,
            GuitarSpec spec){
        Guitar guitar = new Guitar(serialNumber, price, spec);
        guitars.add(guitar);
    }

    public Guitar getGuitar(String serialNumber){
        for(Guitar guitar : guitars)
            if(guitar.getSerialNumber().equals(serialNumber))
                return guitar;
        return null;
    }

    List<Guitar> search(GuitarSpec searchSpec){
        List<Guitar> matchingGuitars = new LinkedList<>();
        for(Guitar guitar : guitars)
            if(guitar.getSpec().matches(searchSpec))
                matchingGuitars.add(guitar);
        return matchingGuitars;
    }

}
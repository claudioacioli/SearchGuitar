package searchguitar;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class Inventory{

    private List<Guitar> guitars;

    public Inventory(){
        guitars = new LinkedList<>();
    }

    public void addGuitar(
            String serialNumber,
            double price,
            GuitarSpec spec){
        Guitar guitar = new Guitar(serialNumber, price, spec);
        guitars.add(guitar);
    }

    public Guitar getGuitar(String serialNumber){
        for (Iterator i = guitars.iterator(); i.hasNext();){
            Guitar guitar = (Guitar) i.next();
            if(guitar.getSerialNumber().equals(serialNumber))
                return guitar;
        }
        return null;
    }

    public List search(GuitarSpec searchSpec){
        List<Guitar> matchingGuitars = new LinkedList<>();
        for(Iterator i = guitars.iterator(); i.hasNext();){
            Guitar guitar = (Guitar) i.next();
            GuitarSpec guitarSpec = guitar.getSpec();

            if(guitarSpec.getBuilder() != searchSpec.getBuilder())
                continue;

            String model = searchSpec.getModel().toLowerCase();
            if((model != null) && (!model.equals("")) && (!model.equals(guitarSpec.getModel().toLowerCase())))
                continue;

            if(guitarSpec.getType() != searchSpec.getType())
                continue;

            if(guitarSpec.getTopWood() != searchSpec.getTopWood())
                continue;

            if(guitarSpec.getBackWood() != searchSpec.getBackWood())
                continue;

            matchingGuitars.add(guitar);
        }
        return matchingGuitars;
    }

}
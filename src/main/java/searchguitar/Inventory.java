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
            Builder builder,
            String model,
            Type type,
            Wood backWood,
            Wood topWood){
        Guitar guitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
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

    public List search(GuitarSpec searchGuitar){
        List<Guitar> matchingGuitars = new LinkedList<>();
        for(Iterator i = guitars.iterator(); i.hasNext();){
            Guitar guitar = (Guitar) i.next();
            GuitarSpec guitarSpec = guitar.getGuitarSpec();

            if(guitarSpec.getBuilder() != searchGuitar.getBuilder())
                continue;

            String model = searchGuitar.getModel().toLowerCase();
            if((model != null) && (!model.equals("")) && (!model.equals(guitarSpec.getModel().toLowerCase())))
                continue;

            if(guitarSpec.getType() != searchGuitar.getType())
                continue;

            if(guitarSpec.getTopWood() != searchGuitar.getTopWood())
                continue;

            if(guitarSpec.getBackWood() != searchGuitar.getBackWood())
                continue;

            matchingGuitars.add(guitar);
        }
        return matchingGuitars;
    }

}
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

    public Guitar search(Guitar searchGuitar){
        for(Iterator i = guitars.iterator(); i.hasNext();){
            Guitar guitar = (Guitar) i.next();

            if(guitar.getBuilder() != searchGuitar.getBuilder())
                continue;

            String model = searchGuitar.getModel().toLowerCase();
            if((model != null) && (!model.equals("")) && (!model.equals(guitar.getModel().toLowerCase())))
                continue;

            if(guitar.getType() != searchGuitar.getType())
                continue;

            if(guitar.getTopWood() != searchGuitar.getTopWood())
                continue;

            if(guitar.getBackWood() != searchGuitar.getBackWood())
                continue;

            return guitar;
        }
        return null;
    }

}
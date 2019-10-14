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
            String builder,
            String model,
            String type,
            String backWood,
            String topWood){
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

            String builder = searchGuitar.getBuilder().toLowerCase();
            if((builder != null) && (!builder.equals("")) && (!builder.equals(guitar.getBuilder().toLowerCase())))
                continue;

            String model = searchGuitar.getModel().toLowerCase();
            if((model != null) && (!model.equals("")) && (!model.equals(guitar.getModel().toLowerCase())))
                continue;

            String type = searchGuitar.getType().toLowerCase();
            if((type != null) && (!type.equals("")) && (!type.equals(guitar.getType().toLowerCase())))
                continue;

            String topWood = searchGuitar.getTopWood().toLowerCase();
            if((topWood != null) && (!topWood.equals("")) && (!topWood.equals(guitar.getTopWood().toLowerCase())))
                continue;

            String backWood = searchGuitar.getBackWood().toLowerCase();
            if((backWood != null) && (!backWood.equals("")) && (!backWood.equals(guitar.getBackWood().toLowerCase())))
                continue;

            return guitar;
        }
        return null;
    }

}
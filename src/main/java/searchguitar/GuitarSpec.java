package searchguitar;

public class GuitarSpec{

    private String model;
    private Builder builder;
    private Type type;
    private Wood backWood;
    private Wood topWood;
    private int numStrings;

    public GuitarSpec(Builder builder,
                      String model,
                      Type type,
                      int numStrings,
                      Wood backWood,
                      Wood topWood){
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.numStrings = numStrings;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public Builder getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }

    public int getNumStrings() {
        return numStrings;
    }

    public boolean matches(GuitarSpec guitarSpec){

        if(this.getBuilder() != guitarSpec.getBuilder())
            return false;

        String model = this.getModel().toLowerCase();
        if((model != null) && (!model.equals("")) && (!model.equals(guitarSpec.getModel().toLowerCase())))
            return false;

        if(this.getType() != guitarSpec.getType())
            return false;

        if(this.getTopWood() != guitarSpec.getTopWood())
            return false;

        if(this.getBackWood() != guitarSpec.getBackWood())
            return false;

        if(this.getNumStrings() != guitarSpec.getNumStrings())
            return false;

        return true;
    }

}
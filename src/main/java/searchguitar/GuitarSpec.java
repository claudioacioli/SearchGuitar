package searchguitar;

class GuitarSpec{

    private String model;
    private Builder builder;
    private Type type;
    private Wood backWood;
    private Wood topWood;
    private int numStrings;

    GuitarSpec(Builder builder,
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

    Builder getBuilder() {
        return builder;
    }

    String getModel() {
        return model;
    }

    Type getType() {
        return type;
    }

    Wood getBackWood() {
        return backWood;
    }

    Wood getTopWood() {
        return topWood;
    }

    int getNumStrings() {
        return numStrings;
    }

    boolean matches(GuitarSpec guitarSpec){

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

        return this.getNumStrings() == guitarSpec.getNumStrings();
    }

}
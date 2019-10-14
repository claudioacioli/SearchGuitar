package searchguitar;

public enum Type{

    ACOUSTIC,
    ELECTRIC;

    @Override
    public String toString() {
        switch (this){
            case ACOUSTIC:
                return "acoustic";
            case ELECTRIC:
                return "eletric";
            default:
                return null;
        }
    }
}
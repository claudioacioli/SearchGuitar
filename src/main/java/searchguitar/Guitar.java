package searchguitar;

class Guitar{
    private String serialNumber;
    private double price;
    private GuitarSpec spec;

    Guitar(
            String serialNumber,
            double price,
            GuitarSpec spec){
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }

    String getSerialNumber(){
        return this.serialNumber;
    }

    double getPrice() {
        return price;
    }

    void setPrice(double price) {
        this.price = price;
    }

    GuitarSpec getSpec(){
        return this.spec;
    }

}
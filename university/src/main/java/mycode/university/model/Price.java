package mycode.university.model;

public enum Price {
    FIFTEENMIN(30),THIRTYMIN(55),HOUR(100),NOTPRICE(0);
private  int price;

    public String getPrice() {
        return String.format("=%s$",price);
    }
    public Price setPrice(int price) {
        this.price =price;
        return null;
    }

    private Price(int price) {
        this.price= price;
    }


}


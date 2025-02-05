package Tax;

class Fine {
    String type;
    String city;
    double amount;

    public Fine(String type, String city, double amount) {
        this.type = type;
        this.city = city;
        this.amount = amount;
    }

    @Override
    public String toString() { return "Fine { \n\ttype='" + type + "', \n\tcity='" + city + "', \n\tamount=" + amount + "\n}"; }
}
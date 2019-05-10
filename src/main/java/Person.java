public class Person {
    private String name;
    private String address;
    private String nip;

    public Person(String name, String address, String nip) {
        this.name = name;
        this.address = address;
        this.nip = nip;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNip() {
        return nip;
    }
}

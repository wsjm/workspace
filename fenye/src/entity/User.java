package entity;

public class User {
    private  int id;
    private  String name;
    private String age;
    private String address;
    private  String salary;
    private String power;
    private String country1;

    public User() {
    }

    public User( String name, String age, String address, String salary, String power, String country1) {

        this.name = name;
        this.age = age;
        this.address = address;
        this.salary = salary;
        this.power = power;
        this.country1 = country1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getCountry1() {
        return country1;
    }

    public void setCountry1(String country1) {
        this.country1 = country1;
    }
}

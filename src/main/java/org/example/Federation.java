package org.example;

public class Federation {

    private int id;
    private String name;
    private String name_of_capital;
    private String number_of_states;

    public Federation(int id, String name, String name_of_capital, String number_of_states) {
        this.id = id;
        this.name = name;
        this.name_of_capital = name_of_capital;
        this.number_of_states= number_of_states;
    }

    @Override
    public String toString() {
        return getId()+ ": "+ getCapital() + ' ' + getName() + ' ' + " : " + getNumberOfStates();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return name_of_capital;
    }

    public void setCapital(String name_of_capital) {
        this.name_of_capital = name_of_capital;
    }

    public String getNumberOfStates() {
        return number_of_states;
    }

    public void setNumberOfStates(String number_of_states) {
        this.number_of_states = number_of_states;
    }

}

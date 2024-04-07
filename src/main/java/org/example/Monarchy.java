package org.example;

public class Monarchy {
    private int id;
    private String name;
    private String name_of_ruler;
    private String age_of_government;

    public Monarchy(int id, String name, String name_of_ruler, String age_of_government) {
        this.id = id;
        this.name = name;
        this.name_of_ruler = name_of_ruler;
        this.age_of_government = age_of_government;
    }

    @Override
    public String toString() {
        return getId()+ ": "+ getRuler() + ' ' + getName() + ' ' + " : " + getReignPeriod();
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

    public String getRuler() {
        return name_of_ruler;
    }

    public void setRuler(String name_of_ruler) {
        this.name_of_ruler = name_of_ruler;
    }

    public String getReignPeriod() {
        return age_of_government;
    }

    public void setReignPeriod(String age_of_government) {
        this.age_of_government = age_of_government;
    }
}

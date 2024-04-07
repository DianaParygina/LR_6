package org.example;
public class Republic {
    private int id;
    private String name;
    private String satisfaction_of_citizens;
    private String parliament;

    public Republic(int id, String name, String satisfaction_of_citizens, String parliament) {
        this.id = id;
        this.name = name;
        this.satisfaction_of_citizens = satisfaction_of_citizens;
        this.parliament = parliament;
    }

    @Override
    public String toString() {
        return getId()+ ": "+ getSatisfaction_of_citizens() + ' ' + getName() + ' ' + " : " + getParliament();
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

    public String getSatisfaction_of_citizens() {
        return satisfaction_of_citizens;
    }

    public void setSatisfaction_of_citizens(String satisfaction_of_citizens) {
        this.satisfaction_of_citizens = satisfaction_of_citizens;
    }

    public String getParliament() {
        return parliament;
    }

    public void setParlament(String parlament) {
        this.parliament = parlament;
    }
}
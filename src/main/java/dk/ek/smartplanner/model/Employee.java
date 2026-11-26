package dk.ek.smartplanner.model;

public class Employee {
    private int id;
    private String name;
    private String email;

    public Employee(){
    }

    public Employee(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    ///Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    ///Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    /// To medarbejdere er ens, hvis de har samme id. Bruges, når Employee er nøgle i et Map.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee other)) return false;
        return id == other.id;
    }

    /// Beregnes ud fra id, så to ens medarbejdere giver samme hashCode.
    /// HashMap bruger tallet til at finde, hvor objektet ligger.
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}

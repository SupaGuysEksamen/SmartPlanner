package dk.ek.smartplanner.model;

public class Competence {


    private int id;
    private String name;

    public Competence(){
    }


    public Competence(int id, String name){
        this.id = id;
        this.name = name;
    }

///Getters
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

   ///Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
}

package org.example.Entities;

public class Document {
<<<<<<< HEAD

    private int id;
    private int employeeId;
    private String name;
    private String type;

    public Document(int id, int employeeId,
                    String name, String type) {

        this.id = id;
        this.employeeId = employeeId;
        this.name = name;
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }


    @Override
    public String toString() {
        return "Document ID: " + id +
                ", Employee ID: " + employeeId +
                ", Name: " + name +
                ", Type: " + type;
    }
}



=======
}
>>>>>>> f754052f1d7ff7330952c503a2c4bcfe9a87cf47

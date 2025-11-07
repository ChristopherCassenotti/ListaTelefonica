package entity;

public class Contato {

    private String name;

    private String telefone;

    public Contato(String name, String telefone) {

        this.name = name;
        this.telefone = telefone;

    }

    public String getName() {
        return name;
    }
    public String getTelefone() {
        return telefone;
    }
}
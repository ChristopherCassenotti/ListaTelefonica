package controlers;

import java.util.ArrayList;
import java.util.List;

import entity.Contato;

public class ListaTelefonica {
    private List<Contato> contato;

    public ListaTelefonica() {
        this.contato = new ArrayList<>();
    }

    public void addContato(Contato newContato) {
        contato.add(newContato);

        System.out.printf("Contato criado %s \n", newContato.getName());
    }

    public void addContato(String name, String telefone) {
        Contato newContato = new Contato(name, telefone);
        contato.add(newContato);

        System.out.printf("Contato criado %s \n", newContato.getName());
    }

    public void removeContato(Contato newContato) {
        contato.remove(newContato);

        System.out.printf("Contato removido %s \n", newContato.getName());
    }

    public void removeContato(String name) {
        for (Contato c : contato) {
            if (c.getName().equalsIgnoreCase(name)) {
                contato.remove(c);
                System.out.printf("Contato removido %s \n", name);
                return;
            }
        }
        System.out.printf("Usuário não encontrado %s \n", name);
    }

    public void viewContato() {
        if (contato.size() <= 0) {
            System.out.println("Lista vazia");
        } else {
            for (Contato c : contato) {
                System.out.printf("Nome: %s \nTelefone: %s \n\n", c.getName(), c.getTelefone());
            }
        }
    }

    public void searchContato(String name) {
        System.out.println("Buscando por: " + name);
        for (Contato c : contato) {

            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println(c.getName());
                System.out.println(c.getTelefone());
                return;
            }
        }
        System.out.println("Nada encontrado");
        return;
    }

}

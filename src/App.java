import controlers.ListaTelefonica;
import entity.Contato;
import java.util.Scanner;

public class App {

    public static void carregarDadosIniciais(ListaTelefonica listaTelefonica) {
        listaTelefonica.addContato(new Contato("Chris", "42222222"));
        listaTelefonica.addContato(new Contato("Mario", "422277722"));
        listaTelefonica.addContato(new Contato("Dama", "42254222"));
        listaTelefonica.addContato(new Contato("Joao", "422211122"));
        listaTelefonica.addContato(new Contato("Maria", "42232422"));
    }

    public void menu() {
        System.out.println("    Lista Telefonica  ");
        System.out.println("1 - Cadastrar contato");
        System.out.println("2 - Excluir contato");
        System.out.println("3 - Mostrar contatos");
        System.out.println("4 - Procurar contato");
        System.out.println("0 - Encerrar programa");
        System.out.println("Escolha uma opção:");
    }

    public static void main(String[] args) throws Exception {

        ListaTelefonica listaTelefonica = new ListaTelefonica();
        carregarDadosIniciais(listaTelefonica);
        App app = new App();

        boolean executando = true;

        Scanner scan = new Scanner(System.in);

        while (executando) {
            app.menu();
            try {
                String entrada = scan.nextLine().trim();
                int opcao = Integer.parseInt(entrada);

                switch (opcao) {
                    case 1:
                        System.out.println("Escreva seu nome:");
                        String name = scan.nextLine().trim();

                        System.out.println("Escreva seu telefone:");
                        String telefone = scan.nextLine().replaceAll("\\D", "");

                        listaTelefonica.addContato(name, String.valueOf(telefone));
                        break;

                    case 2:
                        System.out.println("Escreva o nome do contato para remover nome:");
                        String nameRemove = scan.nextLine();

                        listaTelefonica.removeContato(nameRemove);
                        break;

                    case 3:
                        listaTelefonica.viewContato();

                        break;

                    case 4:
                        System.out.println("Escreva o nome do contato para remover nome:");
                        String nameProcura = scan.nextLine();

                        listaTelefonica.searchContato(nameProcura);
                        break;

                    case 0:

                        executando = false;
                        break;
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido para a opção.");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        scan.close();
    }

}

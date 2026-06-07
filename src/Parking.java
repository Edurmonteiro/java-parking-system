package src;

import java.util.Scanner;

/* Projeto simples de estacionamento em Java feito para praticar:
- estruturas condicionais
- repetição
- arrays e matrizes
- lógica de programação
- validação de dados
*/

public class Parking {
    public static void main(String[] args) {
        Scanner local = new Scanner(System.in);

        // Menu Principal
        StringBuilder mainMenu = new StringBuilder("-----------Estacionamento-----------").append(System.lineSeparator());
        mainMenu.append("|[1°] - Estacionar Carro            |").append(System.lineSeparator());
        mainMenu.append("|[2°] - Remover Carro               |").append(System.lineSeparator());
        mainMenu.append("|[3°] - Mostrar Vagas               |").append(System.lineSeparator());
        mainMenu.append("|[4°] - Procurar Carro              |").append(System.lineSeparator());
        mainMenu.append("|[5°] - Sair                        |").append(System.lineSeparator());
        mainMenu.append("------------------------------------").append(System.lineSeparator());

        // Menu de posicão do estacionamento
        StringBuilder menuPosition = new StringBuilder("Escolha linha e coluna 0 a 2/ 0 a 2").append(System.lineSeparator());
        menuPosition.append("[0/0] [0/1] [0/2]").append(System.lineSeparator());
        menuPosition.append("[1/0] [1/1] [1/2]").append(System.lineSeparator());
        menuPosition.append("[2/0] [2/1] [2/2]").append(System.lineSeparator());

        int numberOfVacancies = 9;
        int menuOption = 0;
        int size = 3;
        String[][] parking = new String[size][size];



        while (menuOption != 5) {
            // Painel Menu
            System.out.println(mainMenu);

            System.out.print("Escolha uma opcão: ");
            menuOption = local.nextInt();

            switch (menuOption){
                case 1:
                    int menuCase1;
                    // inserir Carro no estacionamento
                    do {
                        System.out.println();
                        System.out.println(menuPosition);
                        System.out.print("Escolha a Linha: ");
                        int linePosition = local.nextInt();
                        System.out.print("Esolha a Coluna: ");
                        int columnPosition = local.nextInt();
                        System.out.println("Codigo da placa:");
                        System.out.println("Apenas 4 Caracteres");
                        System.out.print(":");
                        String plate= local.next();
                        if (linePosition >= 0 && linePosition <size && columnPosition >=0 && columnPosition < size) {
                            if (parking[linePosition][columnPosition] == null) {
                                parking[linePosition][columnPosition] = plate;
                                numberOfVacancies--;
                            } else {
                                System.out.println("Ja contem carro estacionado!!");
                            }
                        }
                        else {
                            System.out.println("Posicões invalidas");
                        }

                        System.out.println("[1] Sair");
                        System.out.println("[0] continuar");
                        System.out.print(":");
                        menuCase1 = local.nextInt();

                    }while (menuCase1 == 0);

                    break;
                case 2:
                    //Remover Carro no estacionamento
                    int menuCase2;

                    do {
                        System.out.println();
                        System.out.println(menuPosition);

                        System.out.print("Escolha a Linha: ");
                        int linePosition = local.nextInt();
                        System.out.print("Esolha a Coluna: ");
                        int columnPosition = local.nextInt();

                        if (linePosition >= 0 && linePosition <size && columnPosition >=0 && columnPosition < size) {
                            if (parking[linePosition][columnPosition] != null) {
                                parking[linePosition][columnPosition] = null;
                                numberOfVacancies++;
                            } else {
                                System.out.println("Não contem carro estacionado!!");
                            }
                        }else {
                            System.out.println("Posicões invalidas");
                        }
                        System.out.println("[1] Sair");
                        System.out.println("[0] continuar");
                        System.out.print(":");
                        menuCase2 = local.nextInt();
                    }while (menuCase2 == 0);

                    break;
                case 3:
                    // leitura do estacionamento


                    System.out.println("|----------Estacionamento----------|");

                    for (int line = 0; line < size; line++) {
                        for (int column = 0; column < size; column++) {
                            if (parking[line][column] == null) {
                                System.out.print(" [      ] ");
                            } else {
                                System.out.printf(" [ %s ] ",parking[line][column]);
                            }
                            if (column == 2) {
                                System.out.println();
                            }
                        }
                    }
                    break;
                case 4:
                    //Procura carro estacionado por placa
                    int menuCase4;
                    int countLine = 0;
                    int countColumn = 0;
                    String foundPlate = null;
                    boolean found = false;
                    do {
                        System.out.println("Procurar Carro por Placa:");
                        System.out.print("Codigo da placa:");
                        String plate = local.next();
                        buscar:
                        for (int line = 0; line < size; line++) {
                            for (int column = 0; column < size; column++) {
                                if (parking[line][column] != null) {
                                    if (parking[line][column].equalsIgnoreCase(plate)) {
                                        countLine = line;
                                        countColumn = column;
                                        foundPlate = plate;
                                        found = true;
                                        break buscar;
                                    }
                                }
                            }
                        }
                        if (!found){
                            System.out.println("O carro não está estacionado");
                        }else {
                            System.out.printf("Carro com a placa: (%s) foi encontrado na linha %d e coluna %d %n",foundPlate,countLine,countColumn);
                            foundPlate = null;
                            found = false;
                        }

                        System.out.println(" [1] Sair");
                        System.out.println(" [0] continuar");
                        System.out.print(":");
                        menuCase4 = local.nextInt();
                    }while (menuCase4 == 0);
            }
            System.out.println("------------------------------------------");
            if (numberOfVacancies == 0) {
                System.out.printf("Status Estacionamento: %d Vagas (Lotado) %n",numberOfVacancies);
            }else {
                System.out.printf("Status Estacionamento: %d Vagas (Livre) %n",numberOfVacancies);
            }
            System.out.println("------------------------------------------");
        }
    }
}
package com.upt.lp;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Gestor gestor = new Gestor();
		Scanner ler = new Scanner(System.in);
		gestor.setup();
		int opcao = -1;
		System.out.println("-----------------------------------"+ "\n"+ "\n");
        System.out.println("--------------- À mão ----------------");
        System.out.println("| Recursos essenciais ao seu alcance |");
        System.out.println("--------------------------------------"+ "\n"+ "\n");
		 while (opcao != 0) {
			System.out.println("-------------------");
			System.out.println("|	Menu	  |");
			System.out.println(  "-------------------");
			System.out.println("1 - Login");
			 System.out.println("2 - Criar utilizador");
			 System.out.println("3 - Modo anónimo");
			 System.out.print("0 - Sair" +"\n" + "Opção: ");
			 opcao = ler.nextInt();
			 switch (opcao) {
				case 1:
					gestor.login();
					break;
				case 2:
					gestor.criarUtilizador();
					break;
				case 3:
					gestor.menuAnonimo();
					break;

				case 0:
					System.out.println("A sair...");
					break;
				default:
					System.out.println("Opção inválida");	
					break;
			}
		 }
		 gestor.exit();
	}
}

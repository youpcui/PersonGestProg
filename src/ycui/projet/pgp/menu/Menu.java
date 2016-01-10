package ycui.projet.pgp.menu;

import ycui.projet.pgp.operate.*;
import ycui.projet.pgp.util.InputData;

public class Menu {
	private InputData input = null;
	private PersonOperate po = null;
	
	public Menu() {
		this.input = new InputData();
		while(true){
			this.showMain();
		}
	}

	// ���˵�
	public void showMain() {
		System.out.println("\n           Syst��me d'information de gestion           ");
		System.out.println("********************************************************");
		System.out.println("*                  1. Gestion d'employ��s               *");
		System.out.println("*                  2. Gestion d'��tudiants              *");
		System.out.println("*                  3. Afficher tous personnes          *");
		System.out.println("*                  4. Sortie                           *");
		System.out.println("********************************************************");
		//ѡ�����
		switch(input.getInt("\nChoisir le num��ro:")){
			case 1: {
				showWorker();
				break;
			}
			case 2: {
				showStudent();
				break;
				
			}
			case 3: {
				PersonOperate po1 = new WorkerOperate();
				PersonOperate po2 = new StudentOperate();
				System.out.println("\n------------------------R��sultat------------------------\n");
				po1.findAll();
				po2.findAll();
				System.out.println("--------------------------------------------------------\n");
				break;
			}
			case 4: {
				System.exit(1);
				break;
			}
			default: {
				System.out.println("Veuillez saisir un choix correct!");
				break;
			}
		}
	}

	// Ա����Ϣ����˵�
	public void showWorker() {
		while(true){
			this.po = new WorkerOperate();
			System.out.println("\n          Gestion d'information des employ��s          ");
			System.out.println("********************************************************");
			System.out.println("*        1. Ajouter un(e) nouvel(le) employ��(e)        *");
			System.out.println("*        2. Afficher tous les employ��es                *");
			System.out.println("*        3. Rechercher l'information des employ��s      *");
			System.out.println("*        4. Supprimer un(e) employ��(e)                 *");
			System.out.println("*        5. Modifier l'information de l'employ��(e)     *");
			System.out.println("*        6. Retour �� l'acceuil                         *");
			System.out.println("********************************************************");
			//ѡ�����
			switch(input.getInt("\nChoisir le num��ro:")){
				case 1: {
					po.add();
					break;
				}
				case 2: {
					System.out.println("\n------------------------R��sultat------------------------\n");
					po.findAll();
					System.out.println("--------------------------------------------------------\n");
					break;
				}
				case 3: {
					showResearchWorker();
					break;
				}
				case 4: {
					po.delete();
					break;
				}
				case 5: {
					po.update();
					break;
				}
				case 6: {
					showMain();
					break;
				}
				default: {
					System.out.println("Veuillez saisir un choix correct!");
					break;
				}
			}
		}
	}

	// ѧ����Ϣ����˵�
	public void showStudent() {
		while(true){
			this.po = new StudentOperate();
			System.out.println("\n          Gestion d'information des ��tudiants         ");
			System.out.println("********************************************************");
			System.out.println("*        1. Ajouter un(e) nouvel(le) ��tudiant(e)       *");
			System.out.println("*        2. Afficher tous les ��tudiants                *");
			System.out.println("*        3. Rechercher l'information des ��tudiants     *");
			System.out.println("*        4. Supprimer un(e) ��tudiant(e)                *");
			System.out.println("*        5. Modifier l'information de l'��tudiant(e)    *");
			System.out.println("*        6. Retour �� l'acceuil                         *");
			System.out.println("********************************************************");
			//ѡ�����
			switch(input.getInt("\nChoisir le num��ro:")){
				case 1: {
					po.add();
					break;
				}
				case 2: {
					System.out.println("\n------------------------R��sultat------------------------\n");
					po.findAll();
					System.out.println("--------------------------------------------------------\n");
					break;
				}
				case 3: {
					showResearchStudent();
					break;
				}
				case 4: {
					po.delete();
					break;
				}
				case 5: {
					po.update();
					break;
				}
				case 6: {
					showMain();
					break;
				}
				default: {
					System.out.println("Veuillez saisir un choix correct!");
					break;
				}
			}
		}

	}
	
	// ����Ա����Ϣ�˵�
	public void showResearchWorker() {
		while(true){
			this.po = new WorkerOperate();
			System.out.println("\n         Rechercher d'information des employ��s        ");
			System.out.println("********************************************************");
			System.out.println("*               1. Rechercher tous                     *");
			System.out.println("*               2. Rechercher par id                   *");
			System.out.println("*               3. Rechercher par mot cl��              *");
			System.out.println("*               4. Retour au menu employ��              *");
			System.out.println("*               5. Retour �� l'acceuil                  *");
			System.out.println("********************************************************");
			//ѡ�����
			switch(input.getInt("\nChoisir le num��ro:")){
				case 1: {
					System.out.println("\n------------------------R��sultat------------------------\n");
					po.findAll();
					System.out.println("--------------------------------------------------------\n");
					break;
				}
				case 2: {
//					System.out.println("\n------------------------R��sultat------------------------\n");
					po.findById();
//					System.out.println("--------------------------------------------------------\n");
					break;
				}
				case 3: {
					System.out.println("\n------------------------R��sultat------------------------\n");
					po.findByKey();
					System.out.println("--------------------------------------------------------\n");
					break;
				}
				case 4: {
					showWorker();
					break;
				}
				case 5: {
					showMain();
					break;
				}
				default: {
					System.out.println("Veuillez saisir un choix correct!");
					break;
				}
			}
		}
	}
	
	// ����ѧ����Ϣ�˵�
		public void showResearchStudent() {
			while(true){
				this.po = new StudentOperate();
				System.out.println("\n         Rechercher d'information des ��tudiants       ");
				System.out.println("********************************************************");
				System.out.println("*               1. Rechercher tous                     *");
				System.out.println("*               2. Rechercher par id                   *");
				System.out.println("*               3. Rechercher par mot cl��              *");
				System.out.println("*               4. Retour au menu ��tudiant             *");
				System.out.println("*               5. Retour �� l'acceuil                  *");
				System.out.println("********************************************************");
				//ѡ�����
				switch(input.getInt("\nChoisir le num��ro:")){
					case 1: {
						System.out.println("\n------------------------R��sultat------------------------\n");
						po.findAll();
						System.out.println("--------------------------------------------------------\n");
						break;
					}
					case 2: {
						System.out.println("\n------------------------R��sultat------------------------\n");
						po.findById();
						System.out.println("--------------------------------------------------------\n");
						break;
					}
					case 3: {
						System.out.println("\n------------------------R��sultat------------------------\n");
						po.findByKey();
						System.out.println("--------------------------------------------------------\n");
						break;
					}
					case 4: {
						showStudent();
						break;
					}
					case 5: {
						showMain();
						break;
					}
					default: {
						System.out.println("Veuillez saisir un choix correct!");
						break;
					}
				}
			}
		}
}

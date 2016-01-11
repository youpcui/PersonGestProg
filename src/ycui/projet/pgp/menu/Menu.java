package ycui.projet.pgp.menu;

import ycui.projet.pgp.operate.*;
import ycui.projet.pgp.util.InputData;

public class Menu {
	private static final String DEFAULTINFO = "Veuillez saisir un choix correct!";
	private static final String CHOICE = "\nChoisir le num��ro:";
	private InputData input = null;
	private PersonOperate po = null;
	
	public Menu() {
		this.input = new InputData(); // check value
		this.showMain();
	}

	// ���˵�
	public void showMain() {
		while(true){
			this.po = new PersonOperate();
			System.out.println("\n           Syst��me d'information de gestion           ");
			System.out.println("********************************************************");
			System.out.println("*        1. Gestion d'information des employ��s         *");
			System.out.println("*        2. Gestion d'inforamtion des ��tudiants        *");
			System.out.println("*        3. Afficher tous personnes                    *");
			System.out.println("*        4. Sortie                                     *");
			System.out.println("********************************************************");
			//ѡ�����
			switch(input.getInt(CHOICE)){
				case 1: {
					showWorker();
					break;
				}
				case 2: {
					showStudent();
					break;
				}
				case 3: {
					
					po.findAll();
					break;
				}
				case 4: {
					System.exit(1);
					break;
				}
				default: {
					System.out.println(DEFAULTINFO);
					break;
				}
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
			switch(input.getInt(CHOICE)){
				case 1: {
					po.add();
					break;
				}
				case 2: {
					po.findAll();
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
					System.out.println(DEFAULTINFO);
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
			switch(input.getInt(CHOICE)){
				case 1: {
					po.add();
					break;
				}
				case 2: {
					po.findAll();
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
					System.out.println(DEFAULTINFO);
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
			System.out.println("*               4. Retour au menu pr��c��dant            *");
			System.out.println("*               5. Retour �� l'acceuil                  *");
			System.out.println("********************************************************");
			//ѡ�����
			switch(input.getInt(CHOICE)){
				case 1: {
					po.findAll();
					break;
				}
				case 2: {
					po.findById();
					break;
				}
				case 3: {
					po.findByKey();
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
					System.out.println(DEFAULTINFO);
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
				System.out.println("*               4. Retour au menu pr��c��dant            *");
				System.out.println("*               5. Retour �� l'acceuil                  *");
				System.out.println("********************************************************");
				//ѡ�����
				switch(input.getInt(CHOICE)){
					case 1: {
						po.findAll();
						break;
					}
					case 2: {
						po.findById();
						break;
					}
					case 3: {
						po.findByKey();
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
						System.out.println(DEFAULTINFO);
						break;
					}
				}
			}
		}
}

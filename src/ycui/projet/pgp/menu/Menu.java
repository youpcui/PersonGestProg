package ycui.projet.pgp.menu;

import ycui.projet.pgp.operate.*;
import ycui.projet.pgp.util.InputData;

public class Menu {
	private static final String DEFAULTINFO = "Veuillez saisir un choix correct!";
	private static final String CHOICE = "\nChoisir le numéro:";
	private InputData input = null;
	private PersonOperate po = null;
	
	public Menu() {
		this.input = new InputData(); // check value
		this.showMain();
	}

	// 主菜单
	public void showMain() {
		while(true){
			this.po = new PersonOperate();
			System.out.println("\n           Système d'information de gestion           ");
			System.out.println("********************************************************");
			System.out.println("*        1. Gestion d'information des employés         *");
			System.out.println("*        2. Gestion d'inforamtion des étudiants        *");
			System.out.println("*        3. Afficher tous personnes                    *");
			System.out.println("*        4. Sortie                                     *");
			System.out.println("********************************************************");
			//选择操作
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

	// 员工信息管理菜单
	public void showWorker() {
		while(true){
			this.po = new WorkerOperate();
			System.out.println("\n          Gestion d'information des employés          ");
			System.out.println("********************************************************");
			System.out.println("*        1. Ajouter un(e) nouvel(le) employé(e)        *");
			System.out.println("*        2. Afficher tous les employées                *");
			System.out.println("*        3. Rechercher l'information des employés      *");
			System.out.println("*        4. Supprimer un(e) employé(e)                 *");
			System.out.println("*        5. Modifier l'information de l'employé(e)     *");
			System.out.println("*        6. Retour à l'acceuil                         *");
			System.out.println("********************************************************");
			//选择操作
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

	// 学生信息管理菜单
	public void showStudent() {
		while(true){
			this.po = new StudentOperate();
			System.out.println("\n          Gestion d'information des étudiants         ");
			System.out.println("********************************************************");
			System.out.println("*        1. Ajouter un(e) nouvel(le) étudiant(e)       *");
			System.out.println("*        2. Afficher tous les étudiants                *");
			System.out.println("*        3. Rechercher l'information des étudiants     *");
			System.out.println("*        4. Supprimer un(e) étudiant(e)                *");
			System.out.println("*        5. Modifier l'information de l'étudiant(e)    *");
			System.out.println("*        6. Retour à l'acceuil                         *");
			System.out.println("********************************************************");
			//选择操作
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
	
	// 查找员工信息菜单
	public void showResearchWorker() {
		while(true){
			this.po = new WorkerOperate();
			System.out.println("\n         Rechercher d'information des employés        ");
			System.out.println("********************************************************");
			System.out.println("*               1. Rechercher tous                     *");
			System.out.println("*               2. Rechercher par id                   *");
			System.out.println("*               3. Rechercher par mot clé              *");
			System.out.println("*               4. Retour au menu précédant            *");
			System.out.println("*               5. Retour à l'acceuil                  *");
			System.out.println("********************************************************");
			//选择操作
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
	
	// 查找学生信息菜单
		public void showResearchStudent() {
			while(true){
				this.po = new StudentOperate();
				System.out.println("\n         Rechercher d'information des étudiants       ");
				System.out.println("********************************************************");
				System.out.println("*               1. Rechercher tous                     *");
				System.out.println("*               2. Rechercher par id                   *");
				System.out.println("*               3. Rechercher par mot clé              *");
				System.out.println("*               4. Retour au menu précédant            *");
				System.out.println("*               5. Retour à l'acceuil                  *");
				System.out.println("********************************************************");
				//选择操作
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

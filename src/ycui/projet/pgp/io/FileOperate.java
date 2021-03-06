package ycui.projet.pgp.io;

import java.io.*;
import java.util.TreeSet;

import ycui.projet.pgp.exception.FileIOException;
import ycui.projet.pgp.vo.Person;


//文件的具体操作类，保存数据
public class FileOperate {
	private File file = null;
	public FileOperate(String path){
		this.file = new File(path);
		if(!this.file.exists()){
			try {
				this.save(new TreeSet<Person>());
			} catch (FileIOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @author YCUI
	 * Enregistrer les données dans le fichier
	 * @param obj
	 * 			
	 * @throws FileIOException
	 */
	public boolean save(Object obj) throws FileIOException{
		ObjectOutputStream out = null;
		boolean flag = false;
		try { 
			out = new ObjectOutputStream(
					new FileOutputStream(this.file));
			out.writeObject(obj);
			flag = true;
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier n'est pas trouvé!-->"
					+e.getMessage());
		} catch (IOException e) {
			System.err.println("Echec de lire le fichier!-->"
					+e.getMessage());
		}finally{
			try {
				out.close();
			} catch (IOException e) {
				System.err.println("Echec de fermeture du flux de sortie!-->"
						+e.getMessage());
			}
		}
		return flag;
	}
	
	/**
	 * Ouvrir le fichier
	 * @author YCUI
	 * @return
	 * @throws FileIOException
	 */
	public Object load() throws FileIOException{
		Object obj = null;
		ObjectInputStream input = null;
		try {
			input = new ObjectInputStream(
					new FileInputStream(this.file));
			try {
				obj = input.readObject();
			} catch (ClassNotFoundException e) {
				System.err.println("La classe n'est pas trouvée!-->"
						+e.getMessage());
			}
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier n'est pas trouvé!-->"
					+e.getMessage());
		} catch (IOException e) {
			System.err.println("Echec de enregistrer le fichier!-->"
					+e.getMessage());
		}finally{
			try {
				input.close();
			} catch (IOException e) {
				System.err.println("Echec de fermeture du flux d'entrée!-->"
						+e.getMessage());
			}
		}
		return obj;
	}
}

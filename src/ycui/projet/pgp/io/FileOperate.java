package ycui.projet.pgp.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ycui.projet.pgp.exception.FileIOException;


//文件的具体操作类，保存数据
public class FileOperate {
	private File file = null;
	//在构造方法处制定文件名
	public FileOperate(String path){
		this.file = new File(path);
	}
	
	/**
	 * @author YCUI
	 * Enregistrer les données dans un fichier
	 * @param obj
	 * 			
	 * @throws FileIOException
	 */
	public void save(Object obj) throws FileIOException{
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(
					new FileOutputStream(this.file));
			out.writeObject(obj);
		} catch (FileNotFoundException e) {
			System.err.println("Ne pas trouver le fichier!-->"
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
	}
	
	/**
	 * Ouvrir un fichier
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
				System.err.println("Ne pas trouver la classe!-->"
						+e.getMessage());
			}
		} catch (FileNotFoundException e) {
			System.err.println("Ne pas trouver le fichier!-->"
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

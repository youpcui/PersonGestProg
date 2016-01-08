package ycui.projet.pgp.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeSet;

import ycui.projet.pgp.exception.FileIOException;
import ycui.projet.pgp.vo.Person;


//文件的具体操作类，保存数据
public class FileOperate {
	private File file = null;
	//在构造方法处制定文件名
	public FileOperate(String path){
		this.file = new File(path);
		if(!this.file.exists()){
			//如果文件不存在则表明程序第一次运行，需要初始化
			try {
				this.save(new TreeSet<Person>());
			} catch (FileIOException e) {
				System.err.println("Echec d'initialisation!-->"
						+e.getMessage());
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
	public void save(Object obj) throws FileIOException{
		ObjectOutputStream out = null;
		try { 
			out = new ObjectOutputStream(
					new FileOutputStream(this.file));
			out.writeObject(obj);
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

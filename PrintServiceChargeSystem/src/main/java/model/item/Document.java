package model.item;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import utility.WordUtility;

public class Document {
	//TODO
	static String PRE;
	public String location;
	File file;
	
	public static List<Document> allDocuments;
	public Document(int orderNum,String str){
		location=PRE+(str.hashCode()^orderNum)+".docx";
		file=new File(location);
	}
	public Document(String str){
		location=PRE+str+".doc";
		file=new File(location);
	}
	public File getFile() {
		return file;
	}
	public String getAbsolutePath() {
		return file.getAbsolutePath();
	}
	public int getPages() {
		try {
			return WordUtility.pages(file);
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
	}
	static {
		init();
	}
	public static void init() {
		PRE="printfiles/";
		
		allDocuments=new ArrayList<Document>();
		
		allDocuments.add(new Document("ATestDocument"));
		allDocuments.add(new Document("AnotherTestDocument"));
	}
	public static void init(String root) {
		PRE=root+"printfiles/";
		
		allDocuments=new ArrayList<Document>();
		
		allDocuments.add(new Document("ATestDocument"));
		allDocuments.add(new Document("AnotherTestDocument"));
	}
}

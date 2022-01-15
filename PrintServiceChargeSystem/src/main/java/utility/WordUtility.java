package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hwpf.extractor.WordExtractor;

public class WordUtility {
	public static String doc2String(FileInputStream fs) throws IOException {
		StringBuilder result = new StringBuilder();
		WordExtractor re = new WordExtractor(fs);
		result.append(re.getText());
		re.close();
		return result.toString();
	}
 
	public static String doc2String(File file) throws IOException {
		return doc2String(new FileInputStream(file));
	}
	
	public static int pages(FileInputStream fs) throws IOException {
		WordExtractor re = new WordExtractor(fs);
		SummaryInformation information=re.getSummaryInformation();
		re.close();
		return information.getPageCount();
	}
	public static int pages(File file) throws IOException {
		return pages(new FileInputStream(file));
	}
 
	public static void main(String[] args) {
		File dir = new File("");  //参数为空
		String projectPath2 = dir.getPath();
		System.out.println(projectPath2);
		File file = new File(System.getProperty("user.dir")+"./printfiles/"+"ATestDocument.doc");
		
		try {
			System.out.println(doc2String(file));
			System.out.println(pages(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

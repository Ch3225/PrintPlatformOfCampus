package pfpsc.util;

import java.io.File;
import java.io.IOException;

import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import pfpsc.constant.JsonConstant;

public class DocumentManager {

	public static String root = "";

	public static String addDocument(CommonsMultipartFile file) throws IllegalStateException, IOException {
		String string = DigestUtils.md5DigestAsHex(file.getInputStream());
		
		File newPath = new File(root+"/"+string);
		if(!newPath.exists()) {
			newPath.mkdir();
		}
		
		File newFile = new File(newPath+"/"+string);
		if(!newFile.exists()) {
			file.transferTo(newFile);						//写文件
		}
		
		return JsonConstant.CODE_SUCCESS;
	}

	public static File selectDocumentByMD5(String stringMD5) {
		File newPath = new File(root+"/"+stringMD5+"/"+stringMD5);
		return newPath;
	}

	public static boolean deleteFileByMD5(String MD5) {
		// TODO
		return true;
	}
}

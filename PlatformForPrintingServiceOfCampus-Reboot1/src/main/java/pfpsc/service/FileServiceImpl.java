package pfpsc.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.swing.text.AbstractDocument.DefaultDocumentEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import pfpsc.dao.impl.DocumentMapper;
import pfpsc.exception.DefinedException;
import pfpsc.model.pojo.Document;
import pfpsc.service.impl.IFileService;
import pfpsc.util.DocumentManager;

@Service
public class FileServiceImpl implements IFileService {
	
	@Autowired
	DocumentMapper documentMapper;

	@Override
	public String saveDocumentForCustomer(CommonsMultipartFile file) throws DefinedException {
		try {
			if (file.getSize() != 0) {
				Document document = new Document();
				
				String stringMD5 = DigestUtils.md5DigestAsHex(file.getInputStream());
				document.setMd5(stringMD5);
				
				Date currentTime=new Date();
				Date sevenDaysLater=new Date(new Date().getTime() + 1L * 1000 * 60 * 60 * 24 * 7);
				
				//使用数据库
				Document selectdDocument = documentMapper.selectByMD5(stringMD5);
				if(selectdDocument==null) {
					document.setAddtime(currentTime);
					document.setExpiretime(sevenDaysLater);
					document.setName(file.getOriginalFilename());
					
					documentMapper.insert(document);

				} else {
					selectdDocument.setExpiretime(sevenDaysLater);
					selectdDocument.setName(file.getOriginalFilename());
					
					documentMapper.updateByPrimaryKeySelective(selectdDocument);
				}
				
				DocumentManager.addDocument(file);
				
				return stringMD5;
			}else {
				throw new DefinedException("0");
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
			throw new DefinedException("0");
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new DefinedException("0");
		}
	}

	@Override
	public Document getDocumentByMD5(String stringMD5) {
		return documentMapper.selectByMD5(stringMD5);
	}

}

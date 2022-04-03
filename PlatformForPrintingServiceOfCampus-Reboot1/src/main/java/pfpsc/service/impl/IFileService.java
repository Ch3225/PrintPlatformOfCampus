package pfpsc.service.impl;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import pfpsc.exception.DefinedException;
import pfpsc.model.pojo.Document;
import pfpsc.model.pojo.Trade;

public interface IFileService {
	String saveDocumentForCustomer(CommonsMultipartFile file) throws DefinedException;
	Document getDocumentByMD5(String stringMD5);
}

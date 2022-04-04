package pfpsc.dao.impl.notused;

import pfpsc.model.pojo.Document;

public interface DocumentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Document record);

    int insertSelective(Document record);

    Document selectByPrimaryKey(Integer id);
    
    Document selectByMD5(String MD5);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKey(Document record);
}
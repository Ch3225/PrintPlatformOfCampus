package pfpsc.dao.impl;

import java.util.List;

import pfpsc.model.pojo.Trade;

public interface TradeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Trade record);

    int insertSelective(Trade record);

    Trade selectByPrimaryKey(Integer id);
    
    List<Trade> selectAllPendingsByShop(Integer shopId);

    int updateByPrimaryKeySelective(Trade record);

    int updateByPrimaryKey(Trade record);

	List<Trade> selectAllReadyByUser(Integer userId);
}
/**
 * jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.depreciate.dal.ibatis;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.peigen.common.lang.util.StringUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.peigen.web.depreciate.depreciate.dal.daointerface.ExtraDAO;
import com.peigen.web.depreciate.depreciate.dal.dataobject.DepreciateProductDO;
import com.peigen.web.depreciate.depreciate.dal.dataobject.DepreciateSeqDO;

/**
 *                       
 * @Filename IbatisExtraDAO.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author peigen
 *
 * @Email peigen123@gmail.com
 *       
 * @History
 *<li>Author: peigen</li>
 *<li>Date: 2011-9-6</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class IbatisExtraDAO extends SqlMapClientDaoSupport implements ExtraDAO {
	
	/**
	 * @return
	 * @see com.mbb.payengine.lottery.dal.daointerface.ExtraDAO#getSysdate()
	 */
	@Override
	public Date getSysdate() {
		return (Date) getSqlMapClientTemplate().queryForObject("MS-COMMON-GET-SYSDATE");
	}
	
	/**
	 * @param name
	 * @return
	 * @throws DataAccessException
	 * @see com.mbb.payengine.lottery.dal.daointerface.ExtraDAO#getNextSeq(java.lang.String)
	 */
	@Override
	public int getNextSeq(String name) throws DataAccessException {
		
		if (StringUtil.isBlank(name)) {
			throw new IllegalArgumentException("Can't insert a null data object into db.");
		}
		
		DepreciateSeqDO seq = new DepreciateSeqDO();
		seq.setName(name);
		seq.setRawAddTime(new Date());
		
		return (Integer) getSqlMapClientTemplate().insert("MS-DEPRECIATE-SEQ-INSERT", seq);
		
	}
	
	/**
	 * @param productIds
	 * @return
	 * @see com.peigen.web.depreciate.depreciate.dal.daointerface.ExtraDAO#loadByProductIds(java.util.List)
	 */
	@Override
	public List<DepreciateProductDO> loadByProductIds(List<String> productIds) {
		Map param = new HashMap();
		
		param.put("productIds", productIds);
		
		return getSqlMapClientTemplate().queryForList("MS-DEPRECIATE-PRODUCT-LOAD-BY-IDS", param);
	}
	
}

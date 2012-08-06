/**
 * mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.depreciate.dal.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.peigen.web.depreciate.depreciate.dal.daointerface.DepreciateSeqDAO;


// auto generated imports
import com.peigen.web.depreciate.depreciate.dal.dataobject.DepreciateSeqDO;
import org.springframework.dao.DataAccessException;

/**
 * An ibatis based implementation of dao interface <tt>com.peigen.web.depreciate.depreciate.dal.daointerface.DepreciateSeqDAO</tt>.
 *
 * This file is generated by <tt>depreciate-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>paygw</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/depreciate_seq.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>depreciate-dalgen</tt> 
 * to generate this file.
 *
 * @author peigen
 */ 

public class IbatisDepreciateSeqDAO extends SqlMapClientDaoSupport implements DepreciateSeqDAO {
	/**
	 *  Insert one <tt>DepreciateSeqDO</tt> object to DB table <tt>depreciate_seq</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into depreciate_seq(name) values (, ?)</tt>
	 *
	 *	@param depreciateSeq
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insertInit(DepreciateSeqDO depreciateSeq) throws DataAccessException {
    	if (depreciateSeq == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-DEPRECIATE-SEQ-INSERT-INIT", depreciateSeq);

        return depreciateSeq.getId();
    }

}
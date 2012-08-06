/**
 * mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.depreciate.dal.daointerface;

// auto generated imports
import com.peigen.web.depreciate.depreciate.dal.dataobject.DepreciateUserDO;
import org.springframework.dao.DataAccessException;
import java.util.List;

/**
 * A dao interface provides methods to access database table <tt>depreciate_user</tt>.
 *
 * This file is generated by <tt>depreciate-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>paygw</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/depreciate_user.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>depreciate-dalgen</tt> 
 * to generate this file.
 *
 * @author peigen
 */
 @SuppressWarnings("rawtypes") 
public interface DepreciateUserDAO {
	/**
	 *  Insert one <tt>DepreciateUserDO</tt> object to DB table <tt>depreciate_user</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into depreciate_user(id,user_name,user_passwd,status,user_email,raw_add_time) values (?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param depreciateUser
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insert(DepreciateUserDO depreciateUser) throws DataAccessException;

	/**
	 *  Query DB table <tt>depreciate_user</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, user_name, user_passwd, status, user_email, raw_add_time, raw_update_time from depreciate_user</tt>
	 *
	 *	@return List<DepreciateUserDO>
	 *	@throws DataAccessException
	 */	 
    public List<DepreciateUserDO> loadAll() throws DataAccessException;

	/**
	 *  Query DB table <tt>depreciate_user</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, user_name, user_passwd, status, user_email, raw_add_time, raw_update_time from depreciate_user where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return DepreciateUserDO
	 *	@throws DataAccessException
	 */	 
    public DepreciateUserDO findById(String id) throws DataAccessException;

	/**
	 *  Query DB table <tt>depreciate_user</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, user_name, user_passwd, status, user_email, raw_add_time, raw_update_time from depreciate_user where (user_name = ?)</tt>
	 *
	 *	@param userName
	 *	@return DepreciateUserDO
	 *	@throws DataAccessException
	 */	 
    public DepreciateUserDO findByUserName(String userName) throws DataAccessException;

	/**
	 *  Query DB table <tt>depreciate_user</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, user_name, user_passwd, status, user_email, raw_add_time, raw_update_time from depreciate_user where (user_email = ?)</tt>
	 *
	 *	@param userEmail
	 *	@return DepreciateUserDO
	 *	@throws DataAccessException
	 */	 
    public DepreciateUserDO findByUserEmail(String userEmail) throws DataAccessException;

	/**
	 *  Query DB table <tt>depreciate_user</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, user_name, user_passwd, status, user_email, raw_add_time, raw_update_time from depreciate_user</tt>
	 *
	 *	@param limitStart
	 *	@param pageSize
	 *	@return List<DepreciateUserDO>
	 *	@throws DataAccessException
	 */	 
    public List<DepreciateUserDO> loadAllPageList(int limitStart, int pageSize) throws DataAccessException;

	/**
	 *  Update DB table <tt>depreciate_user</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update depreciate_user set user_passwd=?, status=?, user_email=? where (id = ?)</tt>
	 *
	 *	@param userPasswd
	 *	@param status
	 *	@param userEmail
	 *	@param id
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateForId(String userPasswd, String status, String userEmail, String id) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>depreciate_user</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from depreciate_user where (user_name = ?)</tt>
	 *
	 *	@param userName
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteByUserNameForTest(String userName) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>depreciate_user</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from depreciate_user where (user_email = ?)</tt>
	 *
	 *	@param userEmail
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteByUserEmailForTest(String userEmail) throws DataAccessException;

}
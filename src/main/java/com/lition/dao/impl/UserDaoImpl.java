package com.lition.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.lition.dao.IUserDao;
import com.lition.po.TMenu;
import com.lition.po.TUser;
import com.lition.util.BaseDao;
import com.lition.util.PageModel;

@Repository
public class UserDaoImpl extends BaseDao<TUser> implements IUserDao {
	
	@Override
	public void save(TUser user) throws RuntimeException {
		super.getSession().save(user);
	}

	@Override
	public void update(TUser user) throws RuntimeException {
		super.getSession().update(user);
	}

	@Override
	public void delete(TUser user) throws RuntimeException {
		super.getSession().delete(user);
	}

	@Override
	public TUser queryById(int id) {
		return (TUser) super.getSession().get(TUser.class, id);
	}

	@Override
	public PageModel query(TUser user, int currentPage, int pageSize) {
		
		StringBuilder queryHql = new StringBuilder(" from TUser where 1=1 ");
		StringBuilder countHql = new StringBuilder(" select count(*) from TUser where 1=1 ");
		StringBuilder whereHql = new StringBuilder();
		
		Map<String,Object> params = new HashMap<String, Object>() ;
		if(user != null){
			// 表示根据用户姓名查询
			if(!"".equals(user.getUsername()) && user.getUsername() != null){
				whereHql.append(" and username like :username");
				params.put("username", "%"+user.getUsername()+"%");
			}
			// 根据性别查询
			if(!"".equals(user.getSex()) && user.getSex() != null){
				whereHql.append(" and sex like :sex");
				params.put("sex", user.getSex());
			}
		}
		return super.queryPageModel(queryHql, countHql, whereHql,
				currentPage, pageSize, params);
	}

	@Override
	public void saveSyndata() throws RuntimeException{
		String sql = "insert into t_user(id,username,pwd,realname,sex,depid,phone)select id,username,pwd,realname,sex,depid,phone from t_user@dbms_car_test t2 where t2.id not in(select id from t_user)";
		super.getSession().createSQLQuery(sql).executeUpdate();
	}

	@Override
	public TUser login(String userName, String password) {
		String hql = "from TUser where username=:username and pwd=:pwd";
		Query query = super.getSession().createQuery(hql);
		query.setParameter("username", userName);
		query.setParameter("pwd", password);

		List list = query.list();
		
		if (list.size() > 0) {
			//表示登录成功
			return (TUser) list.get(0);
		}
		
		//表示登录失败
		return null;
	}

	@Override
	public List<TMenu> queryUserMenuById(int id) {
		String hql = "select * from t_menu t3 where id in(select t2.menuid from t_role_menu t2 where t2.roleid in (select t1.roleid from t_user_role t1 where t1.userid = :userid)) and t3.menulink is not null";
		
		SQLQuery query = super.getSession().createSQLQuery(hql);
		query.setParameter("userid", id);
		query.addEntity(TMenu.class);
		List<TMenu> list = query.list();
		return list;
	}
}

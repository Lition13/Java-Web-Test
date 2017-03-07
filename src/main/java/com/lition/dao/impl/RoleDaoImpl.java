package com.lition.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lition.dao.IRoleDao;
import com.lition.po.TRole;
import com.lition.util.BaseDao;
import com.lition.util.PageModel;

@Repository
public class RoleDaoImpl extends BaseDao<TRole> implements IRoleDao{

	private String hql;

	@Override
	public void save(TRole role) throws RuntimeException {
		super.getSession().save(role);
	}

	@Override
	public void update(TRole role) throws RuntimeException {
		super.getSession().update(role);
	}

	@Override
	public void delete(TRole role) throws RuntimeException {
		super.getSession().delete(role);
	}

	@Override
	public TRole queryById(int id) {
		return (TRole) super.getSession().get(TRole.class, id);
	}

	@Override
	public List<TRole> query(TRole role) {
		hql = "from TRole";
		
		return super.getSession().createQuery(hql).list();
	}

	@Override
	public PageModel query(TRole role, int currentPage, int pageSize) {
		
		StringBuilder queryHql = new StringBuilder("from TRole where 1=1");
		StringBuilder countHql = new StringBuilder("select count(*) from TRole where 1=1");
		StringBuilder whereHql = new StringBuilder();
		Map<String,Object> params = new HashMap<String, Object>();
		
		if (role != null) {
			if (!"".equals(role.getRolename()) && role.getRolename()!=null) {
				whereHql.append("and rolename like :rolename");
				params.put("rolename", "%" + role.getRolename() + "%");
			}
		}
		return super.queryPageModel(queryHql, countHql, whereHql, currentPage, pageSize, params );
	}

}

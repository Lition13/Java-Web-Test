package com.lition.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.lition.dao.IMenuDao;
import com.lition.po.TMenu;
import com.lition.util.BaseDao;
import com.lition.util.PageModel;

@Repository
public class MenuDaoImpl extends BaseDao<TMenu> implements IMenuDao{

	private String hql;

	@Override
	public void save(TMenu menu) throws RuntimeException {
		super.getSession().save(menu);
	}

	@Override
	public void update(TMenu menu) throws RuntimeException {
		super.getSession().update(menu);
	}

	@Override
	public void delete(TMenu menu) throws RuntimeException {
		
		String hql = " update TMenu set isdelete = 1 where id = :id";
		super.getSession().createQuery(hql).setParameter("id", menu.getId()).executeUpdate();
	}

	@Override
	public TMenu queryById(int id) {
		return (TMenu) super.getSession().get(TMenu.class, id);
	}

	@Override
	public List<TMenu> query(TMenu menu) {
		StringBuilder hql = new StringBuilder("from TMenu where 1=1 and (isdelete<>1 or isdelete is null)");
		
		
		if (menu != null) {
			if (!"".equals(menu.getMenuname()) && menu.getMenuname() != null) {
				hql.append(" and menuname like :menuname");
			}
		}
		
		Query query = super.getSession().createQuery(hql.toString());
		
		if (menu != null) {
			if (!"".equals(menu.getMenuname()) && menu.getMenuname() != null) {
				query.setParameter("menuname", "%"+ menu.getMenuname() +"%");
			}
		}
		
		return query.list();
	}

}

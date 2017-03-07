package com.lition.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.lition.dao.IOwnedDao;
import com.lition.po.OwnedVehicle;
import com.lition.util.BaseDao;
import com.lition.util.PageModel;

@Repository
public class OwnedDaoImpl extends BaseDao<OwnedVehicle> implements IOwnedDao{

	@Override
	public void save(OwnedVehicle owend) throws RuntimeException {
		super.getSession().save(owend);
	}

	@Override
	public void update(OwnedVehicle owend) throws RuntimeException {
		super.getSession().update(owend);
	}

	@Override
	public void delete(OwnedVehicle owend) throws RuntimeException {
		super.getSession().delete(owend);
	}

	@Override
	public OwnedVehicle queryById(int id) {
		return (OwnedVehicle) super.getSession().get(OwnedVehicle.class, id);
	}

	@Override
	public PageModel query(OwnedVehicle owend, int currentPage, int pageSize) {
		StringBuilder queryHql = new StringBuilder("from OwnedVehicle where 1=1");
		StringBuilder countHql = new StringBuilder("select count(*) from OwnedVehicle where 1=1");
		StringBuilder whereHql = new StringBuilder("");
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		if (owend != null) {
			if (!"".equals(owend.getVehicleUsageId()) && owend.getVehicleUsageId() != null) {
				whereHql.append("and vehicleUsageId like :vehicleUsageId");
				params.put("vehicleUsageId", "%"+ owend.getVehicleUsageId() +"%");
			}
		}
		
		return super.queryPageModel(queryHql, countHql, whereHql, currentPage, pageSize, params);
	}

	@Override
	public void saveImportData(List<OwnedVehicle> list) {
		// TODO Auto-generated method stub
		Session session = super.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			for (int i = 0; i < list.size(); i++) {
				session.save(list.get(i));
				if (i%100 == 0) {
//					tx.commit();
//					System.out.println("1");
//					tx = session.beginTransaction();
					session.flush();
					session.clear();
				}
			}
			tx.commit();
			System.out.println("2");
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally{
			session.close();
		}
	}

	@Override
	public List<OwnedVehicle> queryAll() {
		String hql = "from OwnedVehicle";
		Query query = super.getSession().createQuery(hql);
		return query.list();
	}
}

package com.cdac.irp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdac.irp.pojos.TimeTable;

@Repository
public class TimeTableDaoImpl implements ITimeTableDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<TimeTable> getTimeTable()
	{
		String jpql = "select t from TimeTable t";
		return entityManager.unwrap(Session.class).createQuery(jpql, TimeTable.class).getResultList();
	
	}
}

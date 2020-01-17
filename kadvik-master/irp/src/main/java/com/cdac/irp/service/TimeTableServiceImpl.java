package com.cdac.irp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.irp.dao.IStudentDao;
import com.cdac.irp.dao.ITimeTableDao;
import com.cdac.irp.pojos.TimeTable;

@Service
@Transactional
public class TimeTableServiceImpl implements ITimeTableService{

	@Autowired
	private ITimeTableDao dao;
	
	@Override
	public  List<TimeTable> getTimeTable()
	{
		return dao.getTimeTable();
	}
	
}

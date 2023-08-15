package com.hospitallaboratory.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.hospitallaboratory.util.DBConnection;
import com.hospitallaboratory.util.Queries;
import com.hospitallaboratory.dao.ILaboratoryDao;
import com.hospitallaboratory.dao.LaboratoryDaoImpl;
import com.hospitallaboratory.exceptions.LaboratoryNotFoundException;
import com.hospitallaboratory.model.Laboratory;

public class LaboratoryServiceImpl implements ILaboratoryService{
	ILaboratoryDao laboratoryDao=new LaboratoryDaoImpl();
	@Override
	public void addLaboratory(Laboratory laboratory) {
			laboratoryDao.addLaboratory(laboratory);
			}

	@Override
	public void updateLaboratory(Integer testId, double testAmount) {
			laboratoryDao.updateLaboratory(testId, testAmount);
		
	}

	@Override
	public void deleteLaboratory(int testId) {

		laboratoryDao.deleteLaboratory(testId);
	}

	@Override
	public List<Laboratory> getAllLaboratory() {
		// TODO Auto-generated method stub
		
		return laboratoryDao.getAllLaboratory();
	}

	@Override
	public List<Laboratory> getByCategory(String category) throws LaboratoryNotFoundException {

		List<Laboratory> laboratory=laboratoryDao.getByCategory(category);
		return laboratory;
	}

	@Override
	public List<Laboratory> getByCategoryAndTestName(String category, String testName)
			throws LaboratoryNotFoundException {

		List<Laboratory> laboratory=laboratoryDao.getByCategoryAndTestName(category,testName);
		return laboratory;
	}

	@Override
	public List<Laboratory> getByTestNameAndTestId(String testName, Integer testId) throws LaboratoryNotFoundException {

		List<Laboratory> laboratory=laboratoryDao.getByTestNameAndTestId(testName,testId);
		
		return laboratory;
	}

	@Override
	public List<Laboratory> getByTestNameAndTestAmount(String testName, double testAmount)
			throws LaboratoryNotFoundException {

		List<Laboratory> laboratory=laboratoryDao.getByTestNameAndTestAmount(testName,testAmount);
		
		return laboratory;
	}

}

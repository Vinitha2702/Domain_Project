package com.hospitallaboratory.service;

import java.util.List;

import com.hospitallaboratory.exceptions.LaboratoryNotFoundException;
import com.hospitallaboratory.model.Laboratory;

public interface ILaboratoryService {
	void addLaboratory(Laboratory laboratory);
	void updateLaboratory(Integer testId,double testAmount);
	void deleteLaboratory(int testId);
	List<Laboratory> getAllLaboratory();
	List<Laboratory> getByCategory(String category) throws LaboratoryNotFoundException;
	List<Laboratory> getByCategoryAndTestName(String category,String testName) throws LaboratoryNotFoundException;
	List<Laboratory> getByTestNameAndTestId(String testName,Integer testId) throws LaboratoryNotFoundException;
	List<Laboratory> getByTestNameAndTestAmount(String testName,double testAmount) throws LaboratoryNotFoundException;
	
	
}

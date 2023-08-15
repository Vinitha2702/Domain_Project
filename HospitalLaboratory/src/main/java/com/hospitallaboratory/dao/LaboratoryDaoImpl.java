package com.hospitallaboratory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hospitallaboratory.exceptions.LaboratoryNotFoundException;
import com.hospitallaboratory.model.Laboratory;
import com.hospitallaboratory.util.DBConnection;
import com.hospitallaboratory.util.Queries;

public class LaboratoryDaoImpl implements ILaboratoryDao {

	@Override
	public void addLaboratory(Laboratory laboratory) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DBConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.INSERTQUERY);
			statement.setString(1, laboratory.getCategory());
			statement.setString(2, laboratory.getTestName());
			statement.setInt(3, laboratory.getTestId());
			statement.setDouble(4, laboratory.getTestAmount());
			statement.setInt(5, laboratory.getCategoryId());
			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateLaboratory(Integer testId, double testAmount) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DBConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.UPDATEQUERY);
			statement.setDouble(1, testAmount);
			statement.setInt(2, testId);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteLaboratory(int testId) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DBConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.DELETEQUERY);
			statement.setInt(1, testId);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Laboratory> getAllLaboratory() {
		// TODO Auto-generated method stub
		List<Laboratory> listOfLabs = new ArrayList<>();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERY);
				ResultSet rs = statement.executeQuery()) {
			while (rs.next()) {
				String name = rs.getString("category");
				String testname = rs.getString("testName");
				Integer testId = rs.getInt("testId");
				double testamount = rs.getDouble("testAmount");
				int categoryid = rs.getInt("categoryId");
				Laboratory laboratory = new Laboratory(name, testname, testId, testamount, categoryid);
				listOfLabs.add(laboratory);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfLabs;

	}

	@Override
	public List<Laboratory> getByCategory(String category) throws LaboratoryNotFoundException {
		// TODO Auto-generated method stub
		List<Laboratory> listOfLabs = new ArrayList<>();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYCATEGORY);) {
			statement.setString(1, category);
			try (ResultSet rs = statement.executeQuery();) {
				while (rs.next()) {
					String name = rs.getString("category");
					String testname = rs.getString("testName");
					Integer testId = rs.getInt("testId");
					double testamount = rs.getDouble("testAmount");
					int categoryid = rs.getInt("categoryId");
					Laboratory laboratory = new Laboratory(name, testname, testId, testamount, categoryid);
					System.out.println(laboratory.toString());
					listOfLabs.add(laboratory);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfLabs;
	}

	@Override
	public List<Laboratory> getByCategoryAndTestName(String category, String testName)
			throws LaboratoryNotFoundException {
		// TODO Auto-generated method stub
		List<Laboratory> listOfLabs = new ArrayList<>();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYCATEGORYANDTESTNAME);){
				
			statement.setString(1, category);
			statement.setString(2, testName);
			try (ResultSet rs = statement.executeQuery();){
			while (rs.next()) {
				String name = rs.getString("category");
				String testname = rs.getString("testName");
				Integer testId = rs.getInt("testId");
				double testamount = rs.getDouble("testAmount");
				int categoryid = rs.getInt("categoryId");
				Laboratory laboratory = new Laboratory(name, testname, testId, testamount, categoryid);
				listOfLabs.add(laboratory);
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfLabs;
	}

	@Override
	public List<Laboratory> getByTestNameAndTestId(String testName, Integer testId) throws LaboratoryNotFoundException {
		// TODO Auto-generated method stub
		List<Laboratory> listOfLabs = new ArrayList<>();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYTESTNAMEANDTESTID);){
				
			statement.setString(1, testName);
			statement.setInt(2, testId);
			try (ResultSet rs = statement.executeQuery();){
			while (rs.next()) {
				String name = rs.getString("category");
				String testname = rs.getString("testName");
				Integer testId1 = rs.getInt("testId");
				double testamount = rs.getDouble("testAmount");
				int categoryid = rs.getInt("categoryId");
				Laboratory laboratory = new Laboratory(name, testname, testId1, testamount, categoryid);
				listOfLabs.add(laboratory);
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfLabs;
	}

	@Override
	public List<Laboratory> getByTestNameAndTestAmount(String testName,  double testAmount)
			throws LaboratoryNotFoundException {
		// TODO Auto-generated method stub
		List<Laboratory> listOfLabs = new ArrayList<>();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection
						.prepareStatement(Queries.QUERYBYTESTNAMEANDTESTAMOUNT);){
			
			statement.setString(1, testName);
			
			statement.setDouble(2, testAmount);
			try(ResultSet rs = statement.executeQuery();){
			while (rs.next()) {
				String name = rs.getString("category");
				String testname = rs.getString("testName");
				Integer testId1 = rs.getInt("testId");
				double testamount = rs.getDouble("testAmount");
				int categoryid = rs.getInt("categoryId");
				Laboratory laboratory = new Laboratory(name, testname, testId1, testamount, categoryid);
				listOfLabs.add(laboratory);
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfLabs;
	}

}

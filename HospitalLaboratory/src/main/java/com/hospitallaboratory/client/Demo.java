package com.hospitallaboratory.client;

import java.util.Scanner;

import com.hospitallaboratory.dao.ILaboratoryDao;
import com.hospitallaboratory.dao.LaboratoryDaoImpl;
import com.hospitallaboratory.model.Laboratory;
import com.hospitallaboratory.service.ILaboratoryService;
import com.hospitallaboratory.service.LaboratoryServiceImpl;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		Laboratory laboratory=new Laboratory("Thyroid","(TSH),SERUM",503,320.0,5);
		ILaboratoryService laboratoryService=new LaboratoryServiceImpl();
//		laboratoryService.addLaboratory(laboratory);
		
//		laboratoryService.deleteLaboratory(102);
//		System.out.println("enter the category");
//		String category=scanner.nextLine();
//		laboratoryService.getByCategory(category);
		
		System.out.println("choose user or admin");
		String method=scanner.next();
		if(method.equals("user")) {
		System.out.println("1:getAllLaboratory,2:getByCategory,3:getByCategoryAndTestName,4:getByTestNameAndTestId,5:getByTestNameAndTestAmount");
		System.out.println("enter the type");
		int type=scanner.nextInt();
		if(type==1) {
			laboratoryService.getAllLaboratory().forEach((lab)->System.out.println(lab));
		}
		else if(type==2) {
			System.out.println("enter the category");
			String category=scanner.next();
			laboratoryService.getByCategory(category).forEach((lab)->System.out.println(lab));
		}
		else if(type==3) {
			System.out.println("enter the category");
			String category=scanner.next();
			System.out.println("enter the testname");
			
			scanner.nextLine();
			String testname=scanner.nextLine();
			laboratoryService.getByCategoryAndTestName(category, testname).forEach((lab)->System.out.println(lab));
		}
		else if(type==4) {
			
			System.out.println("enter the testId");
			int testId=scanner.nextInt();
			System.out.println("enter the testname");
			scanner.nextLine();
			String testname=scanner.nextLine();
			laboratoryService.getByTestNameAndTestId(testname, testId).forEach((lab)->System.out.println(lab));
		}
		else if(type==5) {
			System.out.println("enter the testname");
			scanner.nextLine();
			String testname=scanner.nextLine();
	
			
			System.out.println("enter the testAmount");
			double testAmount=scanner.nextDouble();
			System.out.println(testAmount);
			laboratoryService.getByTestNameAndTestAmount(testname, testAmount).forEach((lab)->System.out.println(lab));
			
		}
		}
		else {
			System.out.println("1:addLaboratory,2:delete Laaboratory,3:update laboratory");
			System.out.println("enter the type");
			int type=scanner.nextInt();
		 if(type==1) {
			System.out.println("enter the category");
			String category=scanner.next();
			scanner.nextLine();
			System.out.println("enter the testname");
			String testname=scanner.next();
			scanner.nextLine();
			System.out.println("enter the testId");
			
			int testid=scanner.nextInt();
			scanner.nextLine();
			System.out.println("enter the testAmount");
			
			double testamount=scanner.nextDouble();
			System.out.println("enter the categoryId");
			int categoryid=scanner.nextInt();
			Laboratory laboratory1=new Laboratory();
			laboratory.setCategory(category);
			laboratory.setCategoryId(categoryid);
			laboratory.setTestAmount(testamount);
			laboratory.setTestId(testid);
			laboratory.setTestName(testname);
			laboratoryService.addLaboratory(laboratory);
		}
		else if(type==2) {
			System.out.println("enter test id");
			int testId=scanner.nextInt();
			laboratoryService.deleteLaboratory(testId);
		}
		else if(type==3) {
			System.out.println("enter testAmount");
			double testAmount=scanner.nextDouble();
			System.out.println("enter testId");
			int testId=scanner.nextInt();
			laboratoryService.updateLaboratory(testId, testAmount);
		}
		}
		
	}

}

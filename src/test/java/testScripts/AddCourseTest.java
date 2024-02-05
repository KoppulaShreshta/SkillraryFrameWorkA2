package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;
import genericUtilities.IConstantPath;

public class AddCourseTest extends BaseClass{
	@Test
	public void addCourseTest() throws InterruptedException {
		SoftAssert soft=new SoftAssert();
		
		home.clickCoursesTab();
		home.clickCoursesListLink();
		soft.assertTrue(courseList.getPageHeader().contains("Course List"));
		courseList.clickNewButton();
		Thread.sleep(3000);
		soft.assertEquals(addCourse.getPageHeader(),"Add New Course");
		
		 Map<String,String> map=excel.readFromExcel("Add Course");
		 addCourse.setName(map.get("Name"));
		 addCourse.selectCategory(web, map.get("Category"));
		 addCourse.setPrice(map.get("Price"));
		 addCourse.uploadPhoto(map.get("Photo"));
		 addCourse.setDescription(map.get("Description"), web);
		 addCourse.clicksave();
		 
		 soft.assertEquals(courseList.getSuccessMessage(),"Success!");
		 courseList.deleteCourse(web,map.get("Name"));
		 soft.assertEquals(courseList.getSuccessMessage(),"Success!");
		 
		 if(courseList.getSuccessMessage().equals("Success!"))
			 excel.updateTestStatus("Add Course","Pass",IConstantPath.EXCEL_PATH);
			else
				excel.updateTestStatus("Add Course","Fail",IConstantPath.EXCEL_PATH);
			soft.assertAll();
			 
		 
		 
	}

}

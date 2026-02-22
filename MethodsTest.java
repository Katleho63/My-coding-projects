/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.loginpagecustomer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 
 */
public class MethodsTest {

 @Test
    public void testDisplayTaskDone() {
    String[]Developer={"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"};   
    String[]TaskName ={"Create Login","Create Add Features","Create Reports","Add Arrays"};
    String[]Status ={"To Do","Doing","Done","To Do"};
    int[]duration ={5,8,2,11};
    menuSelectionPage.developer=Developer;
    menuSelectionPage.tasksDuration=duration;
    menuSelectionPage.taskNames=TaskName;
    menuSelectionPage.taskStatus=Status; 
    Methods.displayTaskDone();
    }

    @Test
    public void testLongestTaskDuration() {
    String[]Developer={"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"};
    int[]duration ={5,8,2,11};
    menuSelectionPage.developer =Developer;
    menuSelectionPage.tasksDuration=duration;
    Methods.longestTaskDuration();
    }

    @Test
    public void testSearchForTask() {
    String[]Developer={"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"};   
    String[]TaskName ={"Create Login","Create Add Features","Create Reports","Add Arrays"};
    String[]Status ={"To Do","Doing","Done","To Do"};
    int[]duration ={5,8,2,11};
   menuSelectionPage.developer=Developer;
    menuSelectionPage.tasksDuration=duration;
    menuSelectionPage.taskNames=TaskName;
    menuSelectionPage.taskStatus=Status; 
    Methods.searchForTask();
    }

    @Test
    public void testDeveloperTasks() {
    String[]Developer={"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"};   
    String[]TaskName ={"Create Login","Create Add Features","Create Reports","Add Arrays"};
    String[]Status ={"To Do","Doing","Done","To Do"};
    int[]duration ={5,8,2,11};
    menuSelectionPage.developer=Developer;
    menuSelectionPage.tasksDuration=duration;
    menuSelectionPage.taskNames=TaskName;
    menuSelectionPage.taskStatus=Status;
    Methods.developerTasks();
    }
    
    @Test
    public void testDeleteTask() {
    String[]Developer={"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"};   
    String[]TaskName ={"Create Login","Create Add Features","Create Reports","Add Arrays"};
    String[]Status ={"To Do","Doing","Done","To Do"};
    int[]duration ={5,8,2,11};
    int[] taskNumber={1,2,3,4};
    String[] Descriptions={"Create a login.","Create a add feature.","Create reports.","Add elements to the array"};
    String[]taskID={"CR:"+1+":IKE","CR:"+2+":ARD","CR:"+3+":SON","AD:"+4+":NDA"};
    menuSelectionPage.taskNumbers=taskNumber;
    menuSelectionPage.IDs=taskID;
    menuSelectionPage.developer=Developer;
    menuSelectionPage.tasksDuration=duration;
    menuSelectionPage.taskNames=TaskName;
    menuSelectionPage.taskStatus=Status;
    menuSelectionPage.descriptions=Descriptions;
    Methods.deleteTask();
    Methods.displayTaskReport();
    }

    @Test
    public void testDisplayTaskReport() {
    String[]Developer={"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"};   
    String[]TaskName ={"Create Login","Create Add Features","Create Reports","Add Arrays"};
    String[]Status ={"To Do","Doing","Done","To Do"};
    int[]duration ={5,8,2,11};
    int[] taskNumber={1,2,3,4};
    String[] Descriptions={"Create a login.","Create a add feature.","Create reports.","Add elements to the array"};
    String[]taskID={"CR:"+1+":IKE","CR:"+2+":ARD","CR:"+3+":SON","AD:"+4+":NDA"};
    menuSelectionPage.taskNumbers=taskNumber;
    menuSelectionPage.IDs=taskID;
    menuSelectionPage.developer=Developer;
    menuSelectionPage.tasksDuration=duration;
    menuSelectionPage.taskNames=TaskName;
    menuSelectionPage.taskStatus=Status;
    menuSelectionPage.descriptions=Descriptions;
    Methods.displayTaskReport();        
    }
 
}

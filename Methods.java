/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.loginpagecustomer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class Methods {

 
    public static boolean correctIntValue(String input){ 
    String requirements  = "[0-9]";
    Pattern pt = Pattern.compile(requirements);
    Matcher mt = pt.matcher(input);
    if (input == null){
        JOptionPane.showMessageDialog(null,"Please enter a numeric value", "Incorrect",0);        
      return false;
    }
return mt.matches();
}
public static boolean checkDescription(String input){
    int testLength;
    testLength = input.length();
    boolean lengthTrueOrFalse ;
 
    if (testLength > 50){
        JOptionPane.showMessageDialog(null,"Please enter a task description with less than 50 characters", "Incorrect",0);        
        lengthTrueOrFalse = false;
    }else {
        lengthTrueOrFalse = true;
    }
return lengthTrueOrFalse;
}   
public static String taskId(String taskName, int tasknumber, String devName){
    String taskID;
    String theFirstTwo = taskName.substring(0,2);
    String theLastThree = devName.substring(devName.length()- 3);
    taskID = theFirstTwo.toUpperCase()+":"+tasknumber+":"+theLastThree.toUpperCase();
    JOptionPane.showMessageDialog(null,"This is the taskID: "+taskID,"TaskID",1);    
return taskID;
}
public static String printTaskDetails(String status,int taskNumber,String TaskName, String taskDescription, String ID, double estimateDuration,int addnumofTasks){
    String printTaskDetails ="";
    String numTaskNumber = String.valueOf(taskNumber);
    String estimate = String.valueOf(estimateDuration);
    JOptionPane.showMessageDialog(null,"Task Status: "+status+"\n"+"Task number: "+numTaskNumber+"\n"+"Task name: "+TaskName+"\n"+"Task Description: "+taskDescription+"\n"+"Task ID: "+ID+"\n"+"Duration: "+estimate+"hrs"+"\n","Task Details ",1);
return printTaskDetails;
}
public static String taskStatus(){
String option;
String TaskOption = "";
option = JOptionPane.showInputDialog(null,"Please select the following options: "+"\n"+"1. To Do"+"\n"+"2. Doing"+"\n"+"3. Done"+"\n"+"Please enter the choice you selected: ","Task Status", 1);

    switch(option){
            case "1": 
                TaskOption = "To Do";
                    break;
            case "2":
                TaskOption = "Doing";
                    break;
            case "3": 
                TaskOption = "Done";
                    break;
            default:
                    JOptionPane.showMessageDialog(null,"Please enter either: To Do, Done or Doing", "Incorrect User Input",0);
                    TaskOption = "To Do";
                    break;          
        }
    return TaskOption;
}
public static int returnTotalHours(int hour){
    JOptionPane.showMessageDialog(null,"This is the total hours for all your tasks "+hour,"Total Hours",1);    
return hour;
}
public static void displayTaskDone(){
    
       for(int i = 0; i < menuSelectionPage.taskStatus.length; i++){
            if(menuSelectionPage.taskStatus[i].equals("Done")){
            JOptionPane.showMessageDialog(null,"Developer Details: "+menuSelectionPage.developer[i]+"\nTask Name : "+menuSelectionPage.taskNames[i]+"\nTask Duration : "+menuSelectionPage.tasksDuration[i]+"hrs"+"\nTask Status: "+menuSelectionPage.taskStatus[i],"Task Status",1);
            }
        }
} 

public static void longestTaskDuration(){
 
   int longestTask = menuSelectionPage.tasksDuration[0];
   int subScript = 0;        
    for(int i = 0; i < menuSelectionPage.tasksDuration.length; i++){
         if(longestTask < menuSelectionPage.tasksDuration[i]){
            longestTask= menuSelectionPage.tasksDuration[i];
            subScript=i;    
            }
    }
    JOptionPane.showMessageDialog(null, "Developer Details: "+menuSelectionPage.developer[subScript]+ "\nTask Duration: "+longestTask+"hrs","Task Longest Duration",1);    
}

public static void searchForTask(){
    String nameOfTask;  
    nameOfTask = JOptionPane.showInputDialog(null, "Please enter the name of Task you are searching for: ", "Task assigned to developer", 1);
        for(int i = 0; i < menuSelectionPage.taskNames.length; i++){
            if(menuSelectionPage.taskNames[i].equalsIgnoreCase(nameOfTask)){
            JOptionPane.showMessageDialog(null,"Task Name : "+menuSelectionPage.taskNames[i]+"\nDeveloper Details : "+menuSelectionPage.developer[i]+"\nTask Status: "+menuSelectionPage.taskStatus[i],"Developer Task",1);
            }
        }
    } 
public static void developerTasks(){
    String devTask;
    devTask = JOptionPane.showInputDialog(null, "Please enter the full name of the developer: ", "Task assigned to developer", 1);
        for(int i = 0; i < menuSelectionPage.developer.length; i++){
           if(menuSelectionPage.developer[i].equalsIgnoreCase(devTask)){
            JOptionPane.showMessageDialog(null,"Developer Details : "+menuSelectionPage.developer[i]+"\nTask Name: "+menuSelectionPage.taskNames[i]+"\nTask Status: "+menuSelectionPage.taskStatus[i],"Developer Task",1);
           }
        }
}

   public static void deleteTask(){
    String nameOfTask;
    int indexLess = 0;
    String[]newTaskName;
    int[]newTaskNumber;
    String[]newdescription;
    String[]newDeveloper;
    int[]newDuration;
    String[]newID;
    String[]newStatus;
    newID = new String[menuSelectionPage.IDs.length-1];
    newStatus = new String[menuSelectionPage.taskStatus.length-1];
    newDuration= new int[menuSelectionPage.tasksDuration.length-1];
    newTaskName = new String[menuSelectionPage.taskNames.length-1];
    newTaskNumber = new int[menuSelectionPage.taskNumbers.length-1];
    newDeveloper= new String[menuSelectionPage.developer.length-1];       
    newdescription = new String[menuSelectionPage.descriptions.length-1];
    
    nameOfTask = JOptionPane.showInputDialog(null, "Please write the name of the Task you want to delete.", "Delete a Task", 2);
    for(int i = 0; i < menuSelectionPage.taskNames.length; i++){

        if(!menuSelectionPage.taskNames[i].equalsIgnoreCase(nameOfTask)){
            newTaskName[indexLess] =menuSelectionPage.taskNames[i];
            newTaskNumber[indexLess] =menuSelectionPage.taskNumbers[i];
            newdescription[indexLess] =menuSelectionPage.descriptions[i];
            newDeveloper[indexLess] =menuSelectionPage.developer[i];
            newDuration[indexLess] =menuSelectionPage.tasksDuration[i];
            newID[indexLess] =menuSelectionPage.IDs[i];
            newStatus[indexLess] =menuSelectionPage.taskStatus[i];
            indexLess++;
        }
    }
    JOptionPane.showMessageDialog(null, "The Task has been deleted", "Successfully Deleted", 1);
    menuSelectionPage.taskNames=newTaskName; 
    menuSelectionPage.taskNumbers=newTaskNumber;
    menuSelectionPage.descriptions=newdescription;
    menuSelectionPage.developer=newDeveloper;
    menuSelectionPage.tasksDuration=newDuration;
    menuSelectionPage.IDs=newID;
    menuSelectionPage.taskStatus=newStatus;
}

   public static void displayTaskReport(){
        
       for(int i = 0; i < menuSelectionPage.taskNames.length; i++){      
        JOptionPane.showMessageDialog(null,"Task Name: "+menuSelectionPage.taskNames[i]+"\nTask number: "+menuSelectionPage.taskNumbers[i]+
            "\nTask Description: "+menuSelectionPage.descriptions[i]+"\nDeveloper Details: "+menuSelectionPage.developer[i]+"\nTask Duration: "+menuSelectionPage.tasksDuration[i]+"hrs"+
            "\nTask ID: "+menuSelectionPage.IDs[i]+"\nTask Status: "+menuSelectionPage.taskStatus[i],"Task Report",1);
        }
    }
}

package A3;

import java.util.HashMap;
import java.util.Map;

public class Course {
    // course codes are mapped to index values, these index values are used for the row and columns of the adjacency matrix
    // the column index is stored in [i][j] whenever it is a prerequisite to course j (row)
    // the weight is equal to the column index indicating that it is a preqrequisite

    Map<String, Integer> course = new HashMap<String, Integer>();

    public void mapInit(){
        course.put("MATH204",0);
        course.put("COEN212",1);
        course.put("COEN231",2);
        course.put("COEN243",3);
        course.put("COEN244",4);
        course.put("COEN311",5);
        course.put("COEN313",6);
        course.put("COEN316",7);
        course.put("COEN317",8);
        course.put("COEN320",9);
        course.put("COEN346",10);
        course.put("COEN352",11);
        course.put("COEN366",12);
        course.put("COEN390",13);
        course.put("COEN413",14);
        course.put("COEN415",15);
        course.put("COEN421",16);
        course.put("COEN422",17);
        course.put("COEN424",18);
        course.put("COEN432",19);
        course.put("COEN433",20);
        course.put("COEN434",21);
        course.put("COEN446",22);
        course.put("COEN447",23);
        course.put("COEN448",24);
        course.put("COEN451",25);
        course.put("COEN490",26);
        course.put("COEN498",27);
        course.put("SOEN341",28);
        course.put("No prerequisite",29);
    }
}

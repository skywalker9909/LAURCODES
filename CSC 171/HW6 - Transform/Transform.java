
/* 
Name: LAUREL TAY RAEANNE
School Email: LTAY3@U.ROCHESTER.EDU
Assignment Name: HOMEWORK 6, COLLECTIONS
Date last modified: APRIL 13TH 2023
 */

import java.util.*;

public class Transform {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        List<Entry> entries = new ArrayList<>();
        
        // Read data from the user until the first blank
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }
            entries.add(new Entry(line));
        }
        
        // Read the filter course
        String filterCourse = scanner.nextLine().trim();
        
        // Sort entries by semester, course, last name, then first name
        Collections.sort(entries);
        
        // Iterate through the sorted elements of the collection and display
        // those which pass the filter to standard out
        for (Entry entry : entries) {
            if (entry.getCourseNumber().equals(filterCourse)) {
                System.out.println(entry);
            }
        }
    }
    
    // Non-public top-level class Entry
    static class Entry implements Comparable<Entry> {
        private String lastName;
        private String firstName;
        private String courseNumber;
        private String semester;
        
        // Constructor that takes in a line of input and parses it
     // Constructor that takes in a line of input and parses it
        public Entry(String line) {
            String[] fields = line.split(",");
            if (fields.length == 4) {
                this.lastName = fields[0].trim();
                this.firstName = fields[1].trim();
                this.courseNumber = fields[3].trim();
                this.semester = fields[2].trim();
            } else {
                throw new IllegalArgumentException("Invalid input format: " + line);
            }
        }

        
        // Overloaded compareTo method to sort entries by semester, course, last name, then first name
        public int compareTo(Entry other) {
            int semesterCompare = this.semester.compareTo(other.semester);
            if (semesterCompare != 0) {
                return semesterCompare;
            }
            int courseCompare = this.courseNumber.compareTo(other.courseNumber);
            if (courseCompare != 0) {
                return courseCompare;
            }
            int lastNameCompare = this.lastName.compareTo(other.lastName);
            if (lastNameCompare != 0) {
                return lastNameCompare;
            }
            return this.firstName.compareTo(other.firstName);
        }
        
        // Overloaded toString method to print entries in the required format
        public String toString() {
            return semester + ", " + courseNumber + ", " + lastName + ", " + firstName;
        }
        
        // Getters for instance variables
        public String getLastName() {
            return lastName;
        }
        
        public String getFirstName() {
            return firstName;
        }
        
        public String getCourseNumber() {
            return courseNumber;
        }
        
        public String getSemester() {
            return semester;
        }
    }
}

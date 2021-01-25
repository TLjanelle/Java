public class Course {
    private String[] classList;
    private String courseName;
    private int enrollment;
    private String instructorName;

    public Course(String courseName, String instructorName, int maximumNumberOfStudents) {
        this.courseName = courseName;
        this.instructorName = instructorName;
        this.enrollment = 0;
        this.classList = new String[maximumNumberOfStudents];
    }

    /**
     * @return the number of students in the class
     **/
    int getEnrollment() {
        return this.enrollment;
    }

    /**
     * get the student name at the index position in the class list
     * 
     * @param index
     * @return the student name at the index position
     * @throws IndexOutOfBoundsException Throws the exception when the index is out
     *                                   of bound
     **/
    String getStudent(int index) throws IndexOutOfBoundsException {
        if (index >= 0 || index < this.enrollment) {
            return this.classList[index];
        } else {
            throw new IndexOutOfBoundsException("The index for this student is out of bounds.");
        }
    }

    /**
     *
     * @param studentName
     * @return
     */
    private int findStudent(String studentName) {
        for (int i = 0; i < this.enrollment; i++) {
            String currentStudent = this.classList[i];
            if (studentName.equals(currentStudent)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Add a student name into the class list if the student isn't already in the
     * class. Will not add the student if the student is already in the class to
     * avoid duplicate names.
     * 
     * @param studentName the student name to be added to the class list
     * @return the index of the student in the class list
     **/
    int addStudent(String studentName) throws Exception {
        if (this.enrollment < this.classList.length) {
            // the class list is not full
            int found = findStudent(studentName);
            if (found != -1) {
                return found;
            }

            int index = this.enrollment;
            this.classList[index] = studentName;
            this.enrollment++;
            return index;
        } else {
            // the class if full
            throw new Exception("The class is full!");
        }
    }

    /**
     * Remove a student name from the class list if the student is in the class.
     * 
     * @param studentName the student name to be removed
     * @return the index of the student in the class list if exists; -1 if the
     *         student name is not found
     **/
    int removeStudent(String studentName) {
        int found = this.findStudent(studentName);
        if (found == -1) {
            // the student is not in the list
            return found;
        } else {
            for (int i = found + 1; i < this.enrollment; i++) {
                this.classList[i - 1] = this.classList[i];
            }
            this.enrollment--;
            return found;
        }
    }

}
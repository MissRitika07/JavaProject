class Student extends User {
    int attendance;

    Student(String name, int id) {
        super(name, id);
        attendance = 1;
    }
}
class Admin extends User {

    Admin(String name, int id) {
        super(name, id);
    }

    void addEvent(Event e) {
        System.out.println("Event Added: " + e.eventName);
    }
}
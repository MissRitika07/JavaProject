class Event implements Notifiable {
    String eventName;

    Event(String eventName) {
        this.eventName = eventName;
    }

    public void notifyUser(String msg) {
        System.out.println("Notification: " + msg);
    }
}
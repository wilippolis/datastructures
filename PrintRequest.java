
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author wilip
 */
public class PrintRequest {

    private String[] reqs;
    private int ID;
    private String method;
    private String login;
    private String time;
    private int priority;
    private int size;
    private int handle;

    public PrintRequest() {

    }

    public PrintRequest(String[] data) {
        for (int i = 0; i < data.length; i++) {
            reqs = data[i].split("\\s+");
        

        
            switch (reqs[0]) {
                case "add":
                 
                    System.out.println(PrintScheduler.add(ID, reqs[0], reqs[1], reqs[2], Integer.parseInt(reqs[3]), Integer.parseInt(reqs[4]), Integer.parseInt(reqs[5])));
                    System.out.println(reqs[0]+ " " +reqs[1]+ " " + reqs[2]+ " " + reqs[3]+ " " + reqs[4]+ " " + reqs[5]);
                   
                    ID++;
                    break;
                case "print_next":
                    System.out.println("print_next");
                    ID--;
                    System.out.println(PrintScheduler.print_next());

                    break;
                case "find_next":
                    System.out.println("find_next");
                    System.out.println(PrintScheduler.find_next());

                    break;

                case "status":
                    System.out.println("status");
                    System.out.println(PrintScheduler.status());

                    break;
                case "cancel":
                    if (reqs[1] instanceof String) {
                        //System.out.println(PrintScheduler.cancel(reqs[1]));
                       System.out.println("cancel " + reqs[1]);
                    } else {
                        //System.out.println(PrintScheduler.cancel(ID));
                        System.out.println("cancel " + ID);
                    }

                    break;
            
            }
        }
    }

            //parse the integer into multiple data types
            //then pass the data into the constructor below
        
    

    public PrintRequest(int ID, String method, String login, String time, int priority, int size, int handle) {
        this.ID = ID;
        this.method = method;
        this.login = login;
        this.time = time;
        this.priority = priority;
        this.size = size;
        this.handle = handle;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the handle
     */
    public int getHandle() {
        return handle;
    }

    /**
     * @param handle the handle to set
     */
    public void setHandle(int handle) {
        this.handle = handle;
    }

}

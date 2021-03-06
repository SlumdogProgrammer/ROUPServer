package dataRecieve;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

//Class which contains gets and contains info about program
//Only getters here because there is no point in changing pack info https://vk.com/sticker/1-163-64
public class DataPack {
    private String userName;
    private LocalDateTime creationDate;
    private String activeWindowProcessName;
    private int collectInterval;
    //list of programs
    private ArrayList<ProgramClass> programs;


    public String getActiveWindowProcessName(){ return activeWindowProcessName; }

    public int getCollectInterval(){ return collectInterval; }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getDate() { return creationDate; }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCollectInterval(int collectInterval) { this.collectInterval = collectInterval; }

    public void setActiveWindowProcessName(String activeWindowProcessName) { this.activeWindowProcessName = activeWindowProcessName; }

    public ArrayList<ProgramClass> getPrograms() {
        return programs;
    }

    //this is Constructor👍🏻
    public DataPack()
    {
        programs = new ArrayList<>();
    }

    public DataPack(String userName)
    {
        this.userName = userName;
    }

    public DataPack(String userName, LocalDateTime creationDate, ArrayList<ProgramClass> programs)
    {
        this.userName = userName;
        this.creationDate = creationDate;
        this.programs = programs;
    }

    public void print() {
        System.out.println("User name: " + userName);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        System.out.println("Date: " + formatter.format(creationDate));
        System.out.println("Active window: " + activeWindowProcessName);
        System.out.println("\nPrograms list:\n");
        for (ProgramClass pc : programs) {
            pc.print();
        }
    }
}
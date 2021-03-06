package databaseInteract;

import dataRecieve.ProgramClass;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

//In construction. Not working yet
public class ProgramTracker {
    private long ID;
    private String name;
    private ArrayList<HourInf> HourWork;

    //TODO - change array list to set here for a quicker access to a specified hour. Maybe do the same with programTracker in users
    public ArrayList<HourInf> getHourWork() {  return HourWork;   }

    public void print(){
        System.out.println("Program ID: " + ID);
        System.out.println("Program name: " + name);
        for (HourInf hourProgramInfo : HourWork){
            hourProgramInfo.print();
        }
        System.out.println("---------");
    }

    public void addNewProgram(LocalDateTime date, String activeWindowProcessName, int collectInterval, ProgramClass programClass)
    {
        Calendar calendar = Calendar.getInstance();
        date = date.minusMinutes(date.getMinute());
        date = date.minusSeconds(date.getSecond());
        /*calendar.setTime(date);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        date = calendar.getTime();*/
        HourInf someHour = isHourInArray(date);
        if(someHour == null) {
            HourWork.add(new HourInf(date));
            someHour = HourWork.get(HourWork.size()-1);
        }
        this.name = programClass.getName();
        this.ID = programClass.getID();
        someHour.AddNewProgram(collectInterval, programClass);
        if (activeWindowProcessName.equals(name)){
            someHour.incrementTimeActSum(collectInterval);
        }
    }


    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public ProgramTracker(long ID, String name)
    {
        this.ID = ID;
        this.name = name;
        this.HourWork = new ArrayList<>();
    }

    public ProgramTracker(long ID, String name, ArrayList<HourInf> hourInf) {
        this.ID = ID;
        this.name = name;
        this.HourWork = new ArrayList<>();
        this.HourWork = hourInf;
    }

    private HourInf isHourInArray(LocalDateTime date)
    {
        for (HourInf hour: HourWork) {
            if(hour.getCreationDate().equals(date)) {
                return hour;
            }
        }
        return null;
    }

    public void finalizeObservations() {
        for (HourInf programHourInfo : HourWork){
            programHourInfo.finalizeObservations();
        }
    }
}

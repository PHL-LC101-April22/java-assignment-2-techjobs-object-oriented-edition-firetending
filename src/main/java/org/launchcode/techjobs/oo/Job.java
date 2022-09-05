package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        if (this.getName()==null && this.getEmployer()==null && this.getLocation()==null && this.getPositionType()==null && this.getCoreCompetency()==null) {
            return "\nOOPS! This job does not seem to exist.\n";
        }
        String output;
        String nme = this.getName();
        String emp = this.getEmployer().getValue();
        String loc = this.getLocation().getValue();
        String pos = this.getPositionType().getValue();
        String cc = this.getCoreCompetency().getValue();

        String name = (nme==null || nme.equals("")) ? "Data not available" : nme ;
        String employer = (emp==null || emp.equals("")) ? "Data not available" : emp ;
        String location = (loc==null || loc.equals("")) ? "Data not available" : loc ;
        String postype = (pos==null || pos.equals("")) ? "Data not available" : pos ;
        String corecomp = (cc==null || cc.equals("")) ? "Data not available" : cc ;
//        String employer = (this.getEmployer().getValue()==null || this.getEmployer().getValue().equals("")) ?
//                "Data not available" : this.getEmployer().getValue() ;
//        String location = (this.getLocation().getValue()==null || this.getLocation().getValue().equals("")) ?
//                "Data not available" : this.getLocation().getValue();
//        String postype = (this.getPositionType().getValue()==null || this.getPositionType().getValue().equals("")) ?
//                "Data not available" : this.getPositionType().getValue();
//        String corecomp = (this.getCoreCompetency().getValue()==null || this.getCoreCompetency().getValue().equals("")) ?
//                "Data not available" : this.getCoreCompetency().getValue();
//        String corecomp = (this.getCoreCompetency()!=null) ? ((this.getCoreCompetency().getValue()!=null) ?
//                this.getCoreCompetency().getValue() : "Data not available" ) : "";



        output = "\nID: "+this.getId()+
                "\nName: "+name+
                "\nEmployer: "+employer+
                "\nLocation: "+location+
                "\nPosition Type: "+postype+
                "\nCore Competency: "+corecomp+
                "\n";
        return output;
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}

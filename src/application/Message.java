package application;

import java.time.LocalDateTime;

public class Message {
    private int id;
    private int patientID;
    private int doctorID;
    private LocalDateTime date;
    private String content;

    public Message(int ID, int patientID, int doctorID, LocalDateTime date, String content) {
        this.id = ID;
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.date = date;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message {" +
                "id=" + id +
                ", patientID=" + patientID +
                ", doctorID=" + doctorID +
                ", date=" + date +
                ", content='" + content + '\'' +
                '}';
    }
}

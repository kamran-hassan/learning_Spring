package com.kamran.hassan.learningspring.data;

import javax.persistence.*;    // Docs -> https://docs.oracle.com/javaee/7/api/javax/persistence/package-summary.html

@Entity             // specifies this class is an entity
@Table(name="ROOM")         // Specifies the primary table for the annotated entity.
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Provides for the specification of generation strategies for the values of primary keys.
    @Column(name="ROOM_ID")
    private long id;
    @Column(name="NAME")    // Specifies the mapped column for a persistent property or field.
    private String name;
    @Column(name="ROOM_NUMBER")
    private String roomNumber;
    @Column(name="BED_INFO")
    private String bedInfo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBedInfo() {
        return bedInfo;
    }

    public void setBedInfo(String bedInfo) {
        this.bedInfo = bedInfo;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", bedInfo='" + bedInfo + '\'' +
                '}';
    }
}

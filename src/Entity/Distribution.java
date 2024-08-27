/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import ADT.*;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author szewen
 */
public class Distribution implements Comparable<Distribution> {  //Comparable interface should be parameterized with the same type as the class itself

    private String distributionId;
    private Date distributionDate;
    private String status;
    private SortedListSetInterface<SelectedItem> distributedItemList;       //multiple Items

    private SortedListSetInterface<Donee> distributedDoneeList;
    private Donee donee;

    public Distribution() {
    }

    public Distribution(String distributionId, Date distributionDate, Donee donee) {
        this.distributionId = distributionId;
        this.distributionDate = distributionDate;
        this.donee = donee;
        this.distributedItemList = new SortedDoublyLinkedListSet<>();
        this.distributedDoneeList = new SortedDoublyLinkedListSet<>();
        this.status = "Pending";

    }

    public Distribution(String distributionId, Date distributionDate) {
        this.distributionId = distributionId;
        this.distributionDate = distributionDate;
        this.distributedItemList = new SortedDoublyLinkedListSet<>();
        this.distributedDoneeList = new SortedDoublyLinkedListSet<>();
        this.status = "Pending";
    }

    public void addSelectedItem(SelectedItem selectedItem) {
        distributedItemList.add(selectedItem);
    }

    public void addDonee(Donee donee) {
        distributedDoneeList.add(donee);
    }

    public String getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(String distributionId) {
        this.distributionId = distributionId;
    }

    public Date getDistributionDate() {
        return distributionDate;
    }

    public void setDistributionDate(Date date) {
        this.distributionDate = date;
    }

    public void setDistributedDoneeList(SortedListSetInterface<Donee> distributedDoneeList) {
        this.distributedDoneeList = distributedDoneeList;
    }

    public SortedListSetInterface<SelectedItem> getDistributedItemList() {
        return distributedItemList;
    }

    public void setDistributedItemList(SortedListSetInterface<SelectedItem> distributedItemList) {
        this.distributedItemList = distributedItemList;
    }

    public Donee getDonee() {
        return donee;
    }

    public void setDonee(Donee donee) {
        this.donee = donee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int compareTo(Distribution other) {
        return this.distributionId.compareTo(other.distributionId);
    }

    @Override
    public String toString() {
        String outputStr = String.format("\n%-20s  %-15s  ", distributionId, distributionDate);
        if (!distributedDoneeList.isEmpty()) {
            Iterator<Donee> doneeiterator = distributedDoneeList.getIterator();
            Donee doneeList = doneeiterator.next();
            outputStr += String.format("%-15s  %-15s  ",doneeList.getDoneeId(),doneeList.getLocation());
            while (doneeiterator.hasNext()) {
                doneeList = doneeiterator.next();
                outputStr += String.format("\n%-20s  %-15s  ", "", "");
                outputStr += String.format("%-15s  %-15s  ",doneeList.getDoneeId(),doneeList.getLocation());
            }
        }else{
            outputStr += String.format("%-15s  %-15s  ",donee.getDoneeId(),donee.getLocation());
        }

        Iterator<SelectedItem> iterator = distributedItemList.getIterator();
        SelectedItem item = iterator.next();
        outputStr += String.format(item + "");
        while (iterator.hasNext()) {
            item = iterator.next();
            outputStr += String.format("\n%-20s  %-15s  %-15s  %-15s  ", "", "", "", "");
            outputStr += String.format(item + "");
        }
        outputStr += String.format("%-15s  ", status);

        return outputStr;
    }

    public SortedListSetInterface<Donee> getDistributedDoneeList() {
        return distributedDoneeList;
    }

}

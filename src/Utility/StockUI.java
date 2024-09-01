/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import ADT.SortedListSetInterface;
import Entity.Date;
import Entity.Item;
import Entity.Donation;
import java.time.LocalDate;
import java.util.Iterator;

/**
 *
 * @author USER
 */
public class StockUI {

    public static String getItemType(int opt) {
        switch (opt) {
            case 1:
                return "Monetary";
            case 2:
                return "Clothing and Apparel";
            case 3:
                return "Food and Beverage";
            case 4:
                return "Household Items";
            case 5:
                return "Educational Materials";
            case 6:
                return "Electronic";
            case 7:
                return "Medical";
            case 9:
                return null;
            default:
                MessageUI.displayInvalidOptionMessage();
                return null;
        }
    }

    public static int minimunInventory(String type) {
        switch (type) {
            case "Monetary":
                return 1000; //10000
            case "Clothing and Apparel":
                return 30;  //300
            case "Food and Beverage":
                return 50;  //500
            case "Household Items":
                return 5;  //50
            case "Educational Materials":
                return 15;  //300
            case "Electronic":
                return 3;  //50
            case "Medical":
                return 5; //100
            default:
                return 0;
        }
    }

    public static Date getCurrentDate() {
        LocalDate localDate = LocalDate.now();
        int localDay = localDate.getDayOfMonth();
        int localMonth = localDate.getMonthValue();
        int localYear = localDate.getYear();
        return new Date(localDay, localMonth, localYear);
    }

    public static int getTotalInventory(String type, SortedListSetInterface<Donation> donations) {
        int ttlQty = 0;

        Iterator<Donation> iterator = donations.getIterator();
        do {
            Donation donation = iterator.next();
            if (!donation.getStatus().equalsIgnoreCase("Pending")) {
                ttlQty += quantityCount(type, donation.getDonatedItemList());
            }
        } while (iterator.hasNext());
        return ttlQty;
    }

    public static int quantityCount(String type, SortedListSetInterface<Item> itemsInDonation) {
        int qty = 0;
        Iterator<Item> iterator = itemsInDonation.getIterator();
        do {
            Item item = iterator.next();
            if (item.getType().equalsIgnoreCase("Food and Beverage")) {
                if (getCurrentDate().beforeDate(item.getExpiryDate())) {
                    qty += item.getQuantity();
                }
            } else {
                if (item.getType().equalsIgnoreCase(type)) {
                    qty += item.getQuantity();
                }
            }
        } while (iterator.hasNext());
        return qty;
    }

    public static double getTotalAmount(String type, SortedListSetInterface<Donation> donations) {
        double ttlAmount = 0;

        Iterator<Donation> iterator = donations.getIterator();
        do {
            Donation donation = iterator.next();
            if (!donation.getStatus().equalsIgnoreCase("Pending")) {
                ttlAmount += amountCount(type, donation.getDonatedItemList());
            }
        } while (iterator.hasNext());
        return ttlAmount;
    }

    public static double amountCount(String type, SortedListSetInterface<Item> itemsInDonation) {
        double amount = 0;
        Iterator<Item> iterator = itemsInDonation.getIterator();
        do {
            Item item = iterator.next();
            if (item.getType().equalsIgnoreCase(type)) {
                amount += item.getTotalAmount();
            }
        } while (iterator.hasNext());
        return amount;
    }

    public static boolean checkInventory(String type, SortedListSetInterface<Donation> donations) {
        return getTotalInventory(type, donations) >= minimunInventory(type);
    }

    public static boolean checkMonetary(String type, SortedListSetInterface<Donation> donations) {
        return getTotalAmount(type, donations) >= minimunInventory(type);
    }
}

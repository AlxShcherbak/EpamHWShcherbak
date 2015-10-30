package com.classes;

import java.util.GregorianCalendar;

/**
 * Created by Alx Shcherbak on 27.05.2015.
 */
public class Tariff implements Comparable {
    /**
     * ID in corporation of this tariff plan TP)
     */
    Integer id;
    /**
     * Title of TP (corporation name)
     */
    String title;
    /**
     * Type of TP (contract, pay to call, corporation)
     */
    TariffType type;
    /**
     * Cost off TP (1 min of call, connection, 1Mb of the Internet, etc..)
     */
    Cost cost;
    /**
     * Date then TP started worked
     */
    GregorianCalendar dateStart;
    /**
     * Text description of this TP
     */
    String textDescription;

    public Tariff(Integer id, String title, TariffType type, Cost cost, GregorianCalendar dateStart, String textDescription) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.cost = cost;
        this.dateStart = dateStart;
        this.textDescription = textDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TariffType getType() {
        return type;
    }

    public void setType(TariffType type) {
        this.type = type;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public GregorianCalendar getDateStart() {
        return dateStart;
    }

    public void setDateStart(GregorianCalendar dateStart) {
        this.dateStart = dateStart;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tariff tariff = (Tariff) o;

        if (title != null ? !title.equals(tariff.title) : tariff.title != null) return false;
        if (type != tariff.type) return false;
        return !(cost != null ? !cost.equals(tariff.cost) : tariff.cost != null);

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }

    /**
     * compare by licence fee
     * Year have priority by month and day
     * Month have priority by day
     */
    @Override
    public int compareTo(Object o) {
        Tariff tariff = (Tariff) o;
        return this.getCost().compareTo(tariff.cost);
    }

    /**
     * compare by Internet  fee
     * Year have priority by month and day
     * Month have priority by day
     *
     * @param o - comparable element;
     * @return
     */
    public int compareToByInternetFee(Object o) {
        Tariff tariff = (Tariff) o;
        return this.getCost().compareToByInternetFee(tariff.cost);
    }

    /**
     * compare by minute cost
     *
     * @param o - comparable element;
     * @return
     */
    public int compareToByMinuteCost(Object o) {
        Tariff tariff = (Tariff) o;
        return this.getCost().compareToByMinuteCost(tariff.cost);
    }

    @Override
    public String toString() {
        return id + "//" + title + '/' + type;
    }
}

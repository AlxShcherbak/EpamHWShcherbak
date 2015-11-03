package com.classes;

import java.util.GregorianCalendar;

/**
 * Created by Alx Shcherbak on 27.10.2015.
 */
public class Client {
    /**
     * ID of client
     */
    Integer id;
    /**
     * Name of client
     */
    String name;
    /**
     * Phone number of client
     */
    Long phoneNumber;
    /**
     * Tariff of client
     */
    Tariff tariff;
    /**
     * Balance
     */
    Double balance;
    /**
     *
     */
    GregorianCalendar licenceFeeBy;

    public Client(Integer id, String name, Long phoneNumber, Tariff tariff) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.tariff = tariff;
        this.balance = new Double(0);
        this.licenceFeeBy = null;
    }

    public Client(Integer id, Long phoneNumber, Tariff tariff) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.tariff = tariff;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public GregorianCalendar getLicenceFeeBy() {
        return licenceFeeBy;
    }

    public void setLicenceFeeBy(GregorianCalendar licenceFeeBy) {
        this.licenceFeeBy = licenceFeeBy;
    }

    /**
     * @param m
     */
    public void addBalance(Double m) {
        this.balance += m;
    }

    /**
     * @param m
     */
    public void decrBalance(Double m) {
        this.balance -= m;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != null ? !id.equals(client.id) : client.id != null) return false;
        return !(phoneNumber != null ? !phoneNumber.equals(client.phoneNumber) : client.phoneNumber != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }
}

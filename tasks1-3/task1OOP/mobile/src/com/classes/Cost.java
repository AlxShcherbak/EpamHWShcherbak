package com.classes;

/**
 * Created by Alx Shcherbak on 27.10.2015.
 */
public class Cost implements Comparable {
    /**
     * Licence fee year
     */
    private Double licenceFeeYear;
    /**
     * Licence fee month
     */
    private Double licenceFeeMonth;
    /**
     * Licence fee day
     */
    private Double licenceFeeDay;
    /**
     * Cost of call
     */
    private Double costOfCall;
    /**
     * Connection cost
     */
    private Double connectionCost;
    /**
     * Cost of minute
     */
    private Double costOfMinute;
    /**
     * Internet fee year
     */
    private Double internetFeeYear;
    /**
     * Internet fee month
     */
    private Double internetFeeMonth;
    /**
     * Internet fee day
     */
    private Double internetFeeDay;
    /**
     * Cost of 1Gb of Internet
     */
    private Double internetCost1Gb;
    /**
     * Cost of 1Mb of Internet
     */
    private Double internetCost1Mb;

    public Cost(Double licenceFeeYear, Double licenceFeeMonth, Double licenceFeeDay,
                Double costOfCall, Double connectionCost, Double costOfMinute,
                Double internetFeeYear, Double internetFeeMonth, Double internetFeeDay,
                Double internetCost1Gb, Double internetCost1Mb) {
        this.licenceFeeYear = licenceFeeYear;
        this.licenceFeeMonth = licenceFeeMonth;
        this.licenceFeeDay = licenceFeeDay;
        this.costOfCall = costOfCall;
        this.connectionCost = connectionCost;
        this.costOfMinute = costOfMinute;
        this.internetFeeYear = internetFeeYear;
        this.internetFeeMonth = internetFeeMonth;
        this.internetFeeDay = internetFeeDay;
        this.internetCost1Gb = internetCost1Gb;
        this.internetCost1Mb = internetCost1Mb;
    }

    public Cost(Double connectionCost, Double costOfMinute, Double internetCost1Mb) {
        this.connectionCost = connectionCost;
        this.costOfMinute = costOfMinute;
        this.internetCost1Mb = internetCost1Mb;
    }

    public Double getLicenceFeeYear() {
        return licenceFeeYear;
    }

    public void setLicenceFeeYear(Double licenceFeeYear) {
        this.licenceFeeYear = licenceFeeYear;
    }

    public Double getLicenceFeeMonth() {
        return licenceFeeMonth;
    }

    public void setLicenceFeeMonth(Double licenceFeeMonth) {
        this.licenceFeeMonth = licenceFeeMonth;
    }

    public Double getLicenceFeeDay() {
        return licenceFeeDay;
    }

    public void setLicenceFeeDay(Double licenceFeeDay) {
        this.licenceFeeDay = licenceFeeDay;
    }

    public Double getCostOfCall() {
        return costOfCall;
    }

    public void setCostOfCall(Double costOfCall) {
        this.costOfCall = costOfCall;
    }

    public Double getConnectionCost() {
        return connectionCost;
    }

    public void setConnectionCost(Double connectionCost) {
        this.connectionCost = connectionCost;
    }

    public Double getCostOfMinute() {
        return costOfMinute;
    }

    public void setCostOfMinute(Double costOfMinute) {
        this.costOfMinute = costOfMinute;
    }

    public Double getInternetFeeYear() {
        return internetFeeYear;
    }

    public void setInternetFeeYear(Double internetFeeYear) {
        this.internetFeeYear = internetFeeYear;
    }

    public Double getInternetFeeMonth() {
        return internetFeeMonth;
    }

    public void setInternetFeeMonth(Double internetFeeMonth) {
        this.internetFeeMonth = internetFeeMonth;
    }

    public Double getInternetFeeDay() {
        return internetFeeDay;
    }

    public void setInternetFeeDay(Double internetFeeDay) {
        this.internetFeeDay = internetFeeDay;
    }

    public Double getInternetCost1Gb() {
        return internetCost1Gb;
    }

    public void setInternetCost1Gb(Double internetCost1Gb) {
        this.internetCost1Gb = internetCost1Gb;
    }

    public Double getInternetCost1Mb() {
        return internetCost1Mb;
    }

    public void setInternetCost1Mb(Double internetCost1Mb) {
        this.internetCost1Mb = internetCost1Mb;
    }

    /**
     * Total equality
     *
     * @param o
     * @return true - equal; false - not equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cost cost = (Cost) o;

        if (licenceFeeYear != null ? !licenceFeeYear.equals(cost.licenceFeeYear) : cost.licenceFeeYear != null)
            return false;
        if (licenceFeeMonth != null ? !licenceFeeMonth.equals(cost.licenceFeeMonth) : cost.licenceFeeMonth != null)
            return false;
        if (licenceFeeDay != null ? !licenceFeeDay.equals(cost.licenceFeeDay) : cost.licenceFeeDay != null)
            return false;
        if (costOfCall != null ? !costOfCall.equals(cost.costOfCall) : cost.costOfCall != null) return false;
        if (connectionCost != null ? !connectionCost.equals(cost.connectionCost) : cost.connectionCost != null)
            return false;
        if (costOfMinute != null ? !costOfMinute.equals(cost.costOfMinute) : cost.costOfMinute != null) return false;
        if (internetFeeYear != null ? !internetFeeYear.equals(cost.internetFeeYear) : cost.internetFeeYear != null)
            return false;
        if (internetFeeMonth != null ? !internetFeeMonth.equals(cost.internetFeeMonth) : cost.internetFeeMonth != null)
            return false;
        if (internetFeeDay != null ? !internetFeeDay.equals(cost.internetFeeDay) : cost.internetFeeDay != null)
            return false;
        if (internetCost1Gb != null ? !internetCost1Gb.equals(cost.internetCost1Gb) : cost.internetCost1Gb != null)
            return false;
        return !(internetCost1Mb != null ? !internetCost1Mb.equals(cost.internetCost1Mb) : cost.internetCost1Mb != null);
    }

    public boolean equalByLicenceFee(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cost cost = (Cost) o;
        if (licenceFeeYear != null ? !licenceFeeYear.equals(cost.licenceFeeYear) : cost.licenceFeeYear != null)
            return false;
        if (licenceFeeMonth != null ? !licenceFeeMonth.equals(cost.licenceFeeMonth) : cost.licenceFeeMonth != null)
            return false;
        return !(licenceFeeDay != null ? !licenceFeeDay.equals(cost.licenceFeeDay) : cost.licenceFeeDay != null);
    }

    public boolean equalByMinuteCost(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cost cost = (Cost) o;
        return !(costOfMinute != null ? !costOfMinute.equals(cost.costOfMinute) : cost.costOfMinute != null);
    }

    public boolean equalByInternetFee(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cost cost = (Cost) o;
        if (internetFeeYear != null ? !internetFeeYear.equals(cost.internetFeeYear) : cost.internetFeeYear != null)
            return false;
        if (internetFeeMonth != null ? !internetFeeMonth.equals(cost.internetFeeMonth) : cost.internetFeeMonth != null)
            return false;
        return !(internetFeeDay != null ? !internetFeeDay.equals(cost.internetFeeDay) : cost.internetFeeDay != null);
    }

    @Override
    public int hashCode() {
        int result = licenceFeeYear != null ? licenceFeeYear.hashCode() : 0;
        result = 31 * result + (licenceFeeMonth != null ? licenceFeeMonth.hashCode() : 0);
        result = 31 * result + (licenceFeeDay != null ? licenceFeeDay.hashCode() : 0);
        result = 31 * result + (costOfCall != null ? costOfCall.hashCode() : 0);
        result = 31 * result + (connectionCost != null ? connectionCost.hashCode() : 0);
        result = 31 * result + (costOfMinute != null ? costOfMinute.hashCode() : 0);
        result = 31 * result + (internetFeeYear != null ? internetFeeYear.hashCode() : 0);
        result = 31 * result + (internetFeeMonth != null ? internetFeeMonth.hashCode() : 0);
        result = 31 * result + (internetFeeDay != null ? internetFeeDay.hashCode() : 0);
        result = 31 * result + (internetCost1Gb != null ? internetCost1Gb.hashCode() : 0);
        result = 31 * result + (internetCost1Mb != null ? internetCost1Mb.hashCode() : 0);
        return result;
    }

    /**
     * compare by licence fee
     * Year have priority by month and day
     * Month have priority by day
     *
     * @param o - comparable element;
     * @return
     */
    @Override
    public int compareTo(Object o) {
        if (this.equalByLicenceFee(o)) return 0;
        Cost cost = (Cost) o;
        if (this.getLicenceFeeYear() > cost.getLicenceFeeYear()) return 1;
        if (this.getLicenceFeeYear() < cost.getLicenceFeeYear()) return -1;
        else {
            if (this.getLicenceFeeMonth() > cost.getLicenceFeeMonth()) return 1;
            if (this.getLicenceFeeMonth() < cost.getLicenceFeeMonth()) return -1;
            else {
                if (this.getLicenceFeeDay() > cost.getLicenceFeeDay()) return 1;
                if (this.getLicenceFeeDay() < cost.getLicenceFeeDay()) return -1;
            }
        }
        return -1;
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
        if (this.equalByLicenceFee(o)) return 0;
        Cost cost = (Cost) o;
        int compare = this.getInternetFeeYear().compareTo(cost.getInternetFeeYear());
        if (compare != 0) return compare;
        else {
            compare = this.getInternetFeeMonth().compareTo(cost.getInternetFeeMonth());
            if (compare != 0) return compare;
            else {
                return compare = this.getInternetFeeDay().compareTo(cost.getInternetFeeDay());
            }
        }
    }

    /**
     * compare by minute cost
     *
     * @param o - comparable element;
     * @return
     */
    public int compareToByMinuteCost(Object o) {
        if (this.equalByLicenceFee(o)) return 0;
        Cost cost = (Cost) o;
        return this.getCostOfMinute().compareTo(cost.getCostOfMinute());
    }

}

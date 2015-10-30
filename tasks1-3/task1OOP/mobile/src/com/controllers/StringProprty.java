package com.controllers;

import com.classes.Client;
import com.classes.Tariff;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Alx Shcherbak on 01.06.2015.
 */
public class StringProprty {

    public static class TariffStringProperty {
        private SimpleStringProperty id;
        private SimpleStringProperty title;
        private SimpleStringProperty type;
        private SimpleStringProperty licFeeYear;
        private SimpleStringProperty licFeeMonth;
        private SimpleStringProperty licFeeDay;
        private SimpleStringProperty costOfConnection;
        private SimpleStringProperty costOfMinute;
        private SimpleStringProperty costOfCall;
        private SimpleStringProperty internetFeeYear;
        private SimpleStringProperty internetFeeMonth;
        private SimpleStringProperty internetFeeDay;
        private SimpleStringProperty internetCost1Mb;
        private SimpleStringProperty internetCost1Gb;
        private SimpleStringProperty textDescription;

        /**
         *
         * @param tariff
         */
        public TariffStringProperty(Tariff tariff) {
            String number = tariff.getId().toString();
            if (number.length() == 1) number = "00" + number;
            if (number.length() == 2) number = "0" + number;

            this.id = new SimpleStringProperty(number);
            this.title = new SimpleStringProperty(tariff.getTitle());
            this.type = new SimpleStringProperty(tariff.getType().toString());
            this.licFeeYear = new SimpleStringProperty(tariff.getCost().getLicenceFeeYear().toString());
            this.licFeeMonth = new SimpleStringProperty(tariff.getCost().getLicenceFeeMonth().toString());
            this.licFeeDay = new SimpleStringProperty(tariff.getCost().getLicenceFeeDay().toString());
            this.costOfConnection = new SimpleStringProperty(tariff.getCost().getConnectionCost().toString());
            this.costOfMinute = new SimpleStringProperty(tariff.getCost().getCostOfMinute().toString());
            this.costOfCall = new SimpleStringProperty(tariff.getCost().getCostOfCall().toString());
            this.internetFeeYear = new SimpleStringProperty(tariff.getCost().getInternetFeeYear().toString());
            this.internetFeeMonth = new SimpleStringProperty(tariff.getCost().getInternetFeeMonth().toString());
            this.internetFeeDay = new SimpleStringProperty(tariff.getCost().getInternetFeeDay().toString());
            this.internetCost1Mb = new SimpleStringProperty(tariff.getCost().getInternetCost1Mb().toString());
            this.internetCost1Gb = new SimpleStringProperty(tariff.getCost().getInternetCost1Gb().toString());
            this.textDescription = new SimpleStringProperty(tariff.getTextDescription());
        }

        public String getId() {
            return id.get();
        }

        public SimpleStringProperty idProperty() {
            return id;
        }

        public void setId(String id) {
            this.id.set(id);
        }

        public String getTitle() {
            return title.get();
        }

        public SimpleStringProperty titleProperty() {
            return title;
        }

        public void setTitle(String title) {
            this.title.set(title);
        }

        public String getType() {
            return type.get();
        }

        public SimpleStringProperty typeProperty() {
            return type;
        }

        public void setType(String type) {
            this.type.set(type);
        }

        public String getLicFeeYear() {
            return licFeeYear.get();
        }

        public SimpleStringProperty licFeeYearProperty() {
            return licFeeYear;
        }

        public void setLicFeeYear(String licFeeYear) {
            this.licFeeYear.set(licFeeYear);
        }

        public String getLicFeeMonth() {
            return licFeeMonth.get();
        }

        public SimpleStringProperty licFeeMonthProperty() {
            return licFeeMonth;
        }

        public void setLicFeeMonth(String licFeeMonth) {
            this.licFeeMonth.set(licFeeMonth);
        }

        public String getLicFeeDay() {
            return licFeeDay.get();
        }

        public SimpleStringProperty licFeeDayProperty() {
            return licFeeDay;
        }

        public void setLicFeeDay(String licFeeDay) {
            this.licFeeDay.set(licFeeDay);
        }

        public String getCostOfConnection() {
            return costOfConnection.get();
        }

        public SimpleStringProperty costOfConnectionProperty() {
            return costOfConnection;
        }

        public void setCostOfConnection(String costOfConnection) {
            this.costOfConnection.set(costOfConnection);
        }

        public String getCostOfMinute() {
            return costOfMinute.get();
        }

        public SimpleStringProperty costOfMinuteProperty() {
            return costOfMinute;
        }

        public void setCostOfMinute(String costOfMinute) {
            this.costOfMinute.set(costOfMinute);
        }

        public String getCostOfCall() {
            return costOfCall.get();
        }

        public SimpleStringProperty costOfCallProperty() {
            return costOfCall;
        }

        public void setCostOfCall(String costOfCall) {
            this.costOfCall.set(costOfCall);
        }

        public String getInternetFeeYear() {
            return internetFeeYear.get();
        }

        public SimpleStringProperty internetFeeYearProperty() {
            return internetFeeYear;
        }

        public void setInternetFeeYear(String internetFeeYear) {
            this.internetFeeYear.set(internetFeeYear);
        }

        public String getInternetFeeMonth() {
            return internetFeeMonth.get();
        }

        public SimpleStringProperty internetFeeMonthProperty() {
            return internetFeeMonth;
        }

        public void setInternetFeeMonth(String internetFeeMonth) {
            this.internetFeeMonth.set(internetFeeMonth);
        }

        public String getInternetFeeDay() {
            return internetFeeDay.get();
        }

        public SimpleStringProperty internetFeeDayProperty() {
            return internetFeeDay;
        }

        public void setInternetFeeDay(String internetFeeDay) {
            this.internetFeeDay.set(internetFeeDay);
        }

        public String getInternetCost1Mb() {
            return internetCost1Mb.get();
        }

        public SimpleStringProperty internetCost1MbProperty() {
            return internetCost1Mb;
        }

        public void setInternetCost1Mb(String internetCost1Mb) {
            this.internetCost1Mb.set(internetCost1Mb);
        }

        public String getInternetCost1Gb() {
            return internetCost1Gb.get();
        }

        public SimpleStringProperty internetCost1GbProperty() {
            return internetCost1Gb;
        }

        public void setInternetCost1Gb(String internetCost1Gb) {
            this.internetCost1Gb.set(internetCost1Gb);
        }

        public String getTextDescription() {
            return textDescription.get();
        }

        public SimpleStringProperty textDescriptionProperty() {
            return textDescription;
        }

        public void setTextDescription(String textDescription) {
            this.textDescription.set(textDescription);
        }
    }

    public static class ClientStringProperty {
        private SimpleStringProperty id;
        private SimpleStringProperty name;
        private SimpleStringProperty phoneNumber;
        private SimpleStringProperty tariff;
        private SimpleStringProperty balance;

        /**
         *
         * @param client
         */
        public ClientStringProperty(Client client) {
            String number = client.getId().toString();
            if (number.length() == 1) number = "00" + number;
            if (number.length() == 2) number = "0" + number;

            this.id = new SimpleStringProperty(number);
            this.name = new SimpleStringProperty(client.getName().toString());
            this.phoneNumber = new SimpleStringProperty(client.getPhoneNumber().toString());
            this.tariff = new SimpleStringProperty(client.getTariff().toString());
            this.balance = new SimpleStringProperty(client.getBalance().toString());
        }

        public String getId() {
            return id.get();
        }

        public SimpleStringProperty idProperty() {
            return id;
        }

        public void setId(String id) {
            this.id.set(id);
        }

        public String getName() {
            return name.get();
        }

        public SimpleStringProperty nameProperty() {
            return name;
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public String getPhoneNumber() {
            return phoneNumber.get();
        }

        public SimpleStringProperty phoneNumberProperty() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber.set(phoneNumber);
        }

        public String getTariff() {
            return tariff.get();
        }

        public SimpleStringProperty tariffProperty() {
            return tariff;
        }

        public void setTariff(String tariff) {
            this.tariff.set(tariff);
        }

        public String getBalance() {
            return balance.get();
        }

        public SimpleStringProperty balanceProperty() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance.set(balance);
        }
    }
}

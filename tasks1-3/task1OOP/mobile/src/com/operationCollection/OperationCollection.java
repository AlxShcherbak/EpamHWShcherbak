package com.operationCollection;

import com.classes.*;
import com.factorys.ClientFactorySingleTone;
import com.factorys.TariffFactorySingleTone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

/**
 * Created by Alx Shcherbak on 27.05.2015.
 */
public class OperationCollection {
    /**
     * factory of client
     */
    static ClientFactorySingleTone clientFactory = ClientFactorySingleTone.getFactoryCard();
    /**
     * factory of tariff
     */
    static TariffFactorySingleTone tariffFactory = TariffFactorySingleTone.getFactoryCard();
    /**
     * array of tariffs
     */
    static ArrayList<Tariff> tariffs = new ArrayList<Tariff>();
    /**
     * array of clients
     */
    static ArrayList<Client> clients = new ArrayList<Client>();

    /**
     * add tariff to tariffs from factory : tariffFactory
     *
     * @param title           - title of tariff
     * @param type            - type of tariff
     * @param cost            - cost of tariff
     * @param dateStart       - date than tariff adds
     * @param textDescription - text description of tariff
     */
    public void addTariff(String title, TariffType type, Cost cost, GregorianCalendar dateStart, String textDescription) {
        tariffs.add(tariffFactory.addTariff(title, type, cost, dateStart, textDescription));
    }

    /**
     * add client to clients from factory : clientFactory
     *
     * @param name        - name of client
     * @param phoneNumber - phone number of client
     * @param tariff      - tariff
     */
    public void addClient(String name, Long phoneNumber, Tariff tariff) {
        clients.add(clientFactory.addClient(name, phoneNumber, tariff));
    }

    /**
     * get tariff from tariffs by id
     *
     * @param id - id of tariff that we geted
     * @return tariff with tariff.id = id
     */
    public Tariff getTariffById(Integer id) {
        if (id == null) return null;
        for (Tariff tariff : tariffs) {
            if (tariff.getId().equals(id)) return tariff;
        }
        return null;
    }

    /**
     * get client from clients by id
     *
     * @param id - id of client that we geted
     * @return client with client.id = id
     */
    public Client getClientByID(Integer id) {
        for (Client client : clients) {
            if (client.getId().equals(id)) return client;
        }
        return null;
    }

    /**
     * @return array of tariffs
     */
    public ArrayList<Tariff> tariffsArray() {
        return tariffs;
    }

    /**
     * @return array of clients
     */
    public ArrayList<Client> clientArray() {
        return clients;
    }

    /**
     * adds test values to tariffs & clients
     */
    public void addTestValues() {
        /*id, title, type, cost, dateStart, textDescription*/
        tariffs.add(tariffFactory.addTariff("Title first", TariffType.CONTRACT,
                /*licenceFeeYear, licenceFeeMonth, licenceFeeDay, costOfCall, connectionCost, costOfMinute,
                internetFeeYear, internetFeeMonth, internetFeeDay, internetCost1Gb, internetCost1Mb*/
                new Cost(1000d, 100d, 5d, 0.6d, 0d, 0d, 1000d, 100d, 5d, 20d, 0.2d),
                new GregorianCalendar(), "description first"));
        tariffs.add(tariffFactory.addTariff("Title second", TariffType.CORPORATION,
                new Cost(1200d, 150d, 7.5d, 0d, 0d, 0d, 1500d, 150d, 9d, 20d, 0.2d),
                new GregorianCalendar(), "description second"));
        tariffs.add(tariffFactory.addTariff("Title third", TariffType.PAY_TO_CALL,
                new Cost(0d, 0d, 0d, 0.4d, 0d, 0.15d, 800d, 75d, 3d, 20d, 0.2d),
                new GregorianCalendar(), "description third"));
        clients.add(clientFactory.addClient("Name first", 380960000000l, tariffs.get(0)));
        clients.add(clientFactory.addClient("Name second", 380960000001l, tariffs.get(0)));
        clients.add(clientFactory.addClient("Name third", 380960000002l, tariffs.get(1)));
        clients.add(clientFactory.addClient("Name fourth", 380960000003l, tariffs.get(0)));
        clients.add(clientFactory.addClient("Name fifth", 380960000004l, tariffs.get(1)));
        clients.add(clientFactory.addClient("Name sixth", 380960000005l, tariffs.get(2)));
        clients.add(clientFactory.addClient("Name seventh", 380960000006l, tariffs.get(2)));
        clients.add(clientFactory.addClient("Name eighth", 380960000007l, tariffs.get(0)));
    }

    /**
     * sorting tariffs by cost
     */
    public void sortTariffByCost() {
        Collections.sort(tariffs);
        System.out.println();
    }

    /**
     * Searching tariffs array that pass conditions
     *
     * @param licenceFeeYear   - licence fee by year
     * @param licenceFeeMonth  - licence fee by month
     * @param licenceFeeDay    - licence fee by day
     * @param costOfCall       - cost of one call
     * @param connectionCost   - cost of connection
     * @param costOfMinute     - cost of minute calling
     * @param internetFeeYear  - cost of internet fee by year
     * @param internetFeeMonth - cost of internet fee by month
     * @param internetFeeDay   - cost of internet fee by day
     * @param internetCost1Gb  - cost of 1 Gb of internet
     * @param internetCost1Mb  - cost of 1 Mb of internet
     * @param tariffType       -  tariff type
     * @return array of tariffs that pass condition
     */
    public ArrayList<Tariff> searchTariffByParam(ValueInBound licenceFeeYear, ValueInBound licenceFeeMonth,
                                                 ValueInBound licenceFeeDay, ValueInBound costOfCall,
                                                 ValueInBound connectionCost, ValueInBound costOfMinute,
                                                 ValueInBound internetFeeYear, ValueInBound internetFeeMonth,
                                                 ValueInBound internetFeeDay, ValueInBound internetCost1Gb,
                                                 ValueInBound internetCost1Mb, TariffType tariffType) {
        ArrayList<Tariff> returnArrayList = new ArrayList<Tariff>();
        Boolean flag, tariffTypeflag;
        for (Tariff tariffBuff : tariffs) {
            flag = true;
            flag = flag && licenceFeeYear.valueInBound(tariffBuff.getCost().getLicenceFeeYear());
            flag = flag && licenceFeeMonth.valueInBound(tariffBuff.getCost().getLicenceFeeMonth());
            flag = flag && licenceFeeDay.valueInBound(tariffBuff.getCost().getLicenceFeeDay());
            flag = flag && costOfCall.valueInBound(tariffBuff.getCost().getCostOfCall());
            flag = flag && connectionCost.valueInBound(tariffBuff.getCost().getConnectionCost());
            flag = flag && costOfMinute.valueInBound(tariffBuff.getCost().getCostOfMinute());
            flag = flag && internetFeeYear.valueInBound(tariffBuff.getCost().getInternetFeeYear());
            flag = flag && internetFeeMonth.valueInBound(tariffBuff.getCost().getInternetFeeMonth());
            flag = flag && internetFeeDay.valueInBound(tariffBuff.getCost().getInternetFeeDay());
            flag = flag && internetCost1Gb.valueInBound(tariffBuff.getCost().getInternetCost1Gb());
            flag = flag && internetCost1Mb.valueInBound(tariffBuff.getCost().getInternetCost1Mb());
            if (tariffType == null) tariffTypeflag = true;
            else tariffTypeflag = tariffType == tariffBuff.getType();
            flag = flag && tariffTypeflag;
            if (flag) returnArrayList.add(tariffBuff);
        }
        return returnArrayList;
    }


    /**
     * Calculated statistic by tariff, number of clients on tariff
     *
     * @param tariff - tariff, about that counted statistic
     * @return - number of client on tariff
     */
    public Integer statisticByTariff(Tariff tariff) {
        Integer clientCounter = 0;
        if (tariff != null) {
            for (Client clientBuff : clients) {
                if (clientBuff.getTariff() == (tariff)) clientCounter++;
            }
        } else clientCounter = clients.size();
        return clientCounter;
    }
}

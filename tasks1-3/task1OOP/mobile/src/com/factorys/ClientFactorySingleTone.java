package com.factorys;

import com.classes.Client;
import com.classes.Tariff;

/**
 * Created by Alx Shcherbak on 28.10.2015.
 */
public class ClientFactorySingleTone {
    private int id = 0;
    private static ClientFactorySingleTone clientFactorySingleTone = new ClientFactorySingleTone();

    private ClientFactorySingleTone() {
    }

    public static ClientFactorySingleTone getFactoryCard() {
        return clientFactorySingleTone;
    }

    /**
     *
     * @param name
     * @param phoneNumber
     * @param tariff
     * @return
     */
    public Client addClient(String name, Long phoneNumber, Tariff tariff) {
        return new Client(id++, name, phoneNumber, tariff);
    }

    /**
     *
     * @param phoneNumber
     * @param tariff
     * @return
     */
    public Client addClient(Long phoneNumber, Tariff tariff) {
        return new Client(id++, phoneNumber, tariff);
    }

}

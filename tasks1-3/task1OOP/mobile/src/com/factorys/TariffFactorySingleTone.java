package com.factorys;

import com.classes.Cost;
import com.classes.Tariff;
import com.classes.TariffType;

import java.util.GregorianCalendar;

/**
 * Created by Alx Shcherbak on 27.05.2015.
 */
public class TariffFactorySingleTone {
    private int id = 0;
    private static TariffFactorySingleTone tariffFactorySingleTone =
            new TariffFactorySingleTone();

    private TariffFactorySingleTone() {
    }

    public static TariffFactorySingleTone getFactoryCard() {
        return tariffFactorySingleTone;
    }

    /**
     *
     * @param title
     * @param type
     * @param cost
     * @param dateStart
     * @param textDescription
     * @return
     */
    public Tariff addTariff(String title, TariffType type, Cost cost, GregorianCalendar dateStart, String textDescription) {
        return new Tariff(id++, title, type, cost, dateStart, textDescription);
    }
}

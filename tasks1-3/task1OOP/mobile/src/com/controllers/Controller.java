package com.controllers;

import com.classes.*;
import com.operationCollection.OperationCollection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

/**
 * @author Alx Shcherbak
 * @see Initializable
 * @since 27.10.2015
 */
public class Controller implements Initializable {
    /**
     * created example of OperationCollection
     */
    static public OperationCollection operationCollection = new OperationCollection();
    /**
     * created example of SubController
     */
    static public SubController subController = new SubController();

    /**
     * main anchor in program
     */
    public AnchorPane anchorMain;

    public AnchorPane anchorAddTariffFirst;
    public TextField textFieldAddNewTariffTitle;
    public ChoiceBox<TariffType> choiceBoxAddNewTariffType;

    public TextArea textAreaAddNewTariffDescription;
    public Button buttonAddNewTariffNext;

    public MenuItem menuItem_close;
    public MenuItem menuItem_addNewTariff;
    public MenuItem menuItem_addTestValues;
    public MenuItem menuItem_addNewClient;
    public MenuItem menuItem_actionDBSortTariffByCost;
    public MenuItem menuItem_clientStatisticByTariff;
    public MenuItem menuItem_actionSearchTariff;

    public TabPane tabPane;

    public AnchorPane anchorAddTariffSecond;
    public TextField textFieldAddNewTariffLicFeeYear;
    public TextField textFieldAddNewTariffLicFeeMonth;
    public TextField textFieldAddNewTariffLicFeeDay;
    public TextField textFieldAddNewTariffCostCall;
    public TextField textFieldAddNewTariffCostConnect;
    public TextField textFieldAddNewTariffCostMinute;
    public TextField textFieldAddNewTariffInternetFeeYear;
    public TextField textFieldAddNewTariffInternetFeeMonth;
    public TextField textFieldAddNewTariffInternetFeeDay;
    public TextField textFieldAddNewTariffCost1Gb;
    public TextField textFieldAddNewTariffCost1Mb;
    public Button buttonAddTariffApply;

    public AnchorPane anchorAddClient;
    public TextField textFieldAddNewClientName;
    public TextField textFieldAddNewClientPhone;
    public TextField textFieldAddNewClientBalance;
    public ComboBox<String> comboBoxAddNewClientTariff;
    public Button buttonAddNewClientApply;

    public TableColumn<Client, String> tableColumnWatchClientID;
    public TableColumn<Client, String> tableColumnWatchClientName;
    public TableColumn<Client, String> tableColumnWatchClientPhoneNum;
    public TableColumn<Client, String> tableColumnWatchClientTariff;
    public TableColumn<Client, String> tableColumnWatchClientBalance;
    public TableView<StringProprty.ClientStringProperty> tableViewClient;
    public TableView<StringProprty.TariffStringProperty> tableViewTariff;
    public TableColumn<Tariff, String> tableColumnWatchTariffID;
    public TableColumn<Tariff, String> tableColumnWatchTariffTitle;
    public TableColumn<Tariff, String> tableColumnWatchTariffType;
    public TableColumn tableColumnWatchTariffLicFee;
    public TableColumn<Tariff, String> tableColumnWatchTariffLicFeeYear;
    public TableColumn<Tariff, String> tableColumnWatchTariffLicFeeMonth;
    public TableColumn<Tariff, String> tableColumnWatchTariffLicFeeDay;
    public TableColumn tableColumnWatchTariffInternetFee;
    public TableColumn<Tariff, String> tableColumnWatchTariffInternetFeeYear;
    public TableColumn<Tariff, String> tableColumnWatchTariffInternetFeeMonth;
    public TableColumn<Tariff, String> tableColumnWatchTariffInternetFeeDay;
    public TableColumn tableColumnWatchTariffCost;
    public TableColumn<Tariff, String> tableColumnWatchTariffCostConnect;
    public TableColumn<Tariff, String> tableColumnWatchTariffCostCall;
    public TableColumn<Tariff, String> tableColumnWatchTariffCostMinute;
    public TableColumn<Tariff, String> tableColumnWatchTariffCost1Mb;
    public TableColumn<Tariff, String> tableColumnWatchTariffCost1Gb;
    public TableColumn<Tariff, String> tableColumnWatchTariffDescription;

    public ScrollPane pane_searchTariff;
    public AnchorPane anchorSearchTariffByParam;
    public TextField textFieldLicFeeYearDown;
    public TextField textFieldLicFeeYearUp;
    public TextField textFieldLicFeeMonthDown;
    public TextField textFieldLicFeeMonthUP;
    public TextField textFieldLicFeeDayDown;
    public TextField textFieldLicFeeDayUp;
    public TextField textFieldInternetFeeYearDown;
    public TextField textFieldInternetFeeYearUp;
    public TextField textFieldInternetFeeMonthDown;
    public TextField textFieldInternetFeeMonthUp;
    public TextField textFieldInternetFeeDayDown;
    public TextField textFieldInternetFeeDayUp;
    public TextField textFieldCostConnDown;
    public TextField textFieldCostConnUp;
    public TextField textFieldCostMinuteDown;
    public TextField textFieldCostMinuteUp;
    public TextField textFieldCostCallDown;
    public TextField textFieldCostCallUp;
    public TextField textFieldCost1MbDown;
    public TextField textFieldCost1MbUp;
    public TextField textFieldCost1GbDown;
    public TextField textFieldCost1GbUp;
    public ChoiceBox<TariffType> choiceBoxTariffType;
    public Button buttonSearch;

    public AnchorPane watchTariffSearch;
    public TableView<StringProprty.TariffStringProperty> tableViewTariffSearch;
    public TableColumn<Tariff, String> tableColumnSearchID;
    public TableColumn<Tariff, String> tableColumnSearchTitle;
    public TableColumn<Tariff, String> tableColumnSearchType;
    public TableColumn tableColumnSearchLicFee;
    public TableColumn<Tariff, String> tableColumnSearchLicFeeYear;
    public TableColumn<Tariff, String> tableColumnSearchLicFeeMonth;
    public TableColumn<Tariff, String> tableColumnSearchLicFeeDay;
    public TableColumn tableColumnSearchInternetFee;
    public TableColumn<Tariff, String> tableColumnSearchInternetFeeYear;
    public TableColumn<Tariff, String> tableColumnSearchInternetFeeMonth;
    public TableColumn<Tariff, String> tableColumnSearchInternetFeeDay;
    public TableColumn tableColumnSearchCost;
    public TableColumn<Tariff, String> tableColumnSearchCostConnect;
    public TableColumn<Tariff, String> tableColumnSearchCostCall;
    public TableColumn<Tariff, String> tableColumnSearchCostMinute;
    public TableColumn<Tariff, String> tableColumnSearchCost1Mb;
    public TableColumn<Tariff, String> tableColumnSearchCost1Gb;
    public TableColumn<Tariff, String> tableColumnSearchDescription;
    public Button searchButtonBack;

    public AnchorPane anchorStatistic;
    public ComboBox<String> statisticComboBoxTariff;
    public TextField statisticNumberofClient;
    public Button buttonstatisticApply;

    /**
     * removed all field that can consist mutable value
     */
    private void clearAllFields() {
        choiceBoxAddNewTariffType.getItems().clear();
        choiceBoxAddNewTariffType.getItems().addAll(TariffType.CONTRACT, TariffType.CORPORATION, TariffType.PAY_TO_CALL);

        textFieldAddNewTariffTitle.clear();
        textAreaAddNewTariffDescription.clear();
        textFieldAddNewTariffLicFeeYear.clear();
        textFieldAddNewTariffLicFeeMonth.clear();
        textFieldAddNewTariffLicFeeDay.clear();
        textFieldAddNewTariffCostCall.clear();
        textFieldAddNewTariffCostConnect.clear();
        textFieldAddNewTariffCostMinute.clear();
        textFieldAddNewTariffInternetFeeYear.clear();
        textFieldAddNewTariffInternetFeeMonth.clear();
        textFieldAddNewTariffInternetFeeDay.clear();
        textFieldAddNewTariffCost1Gb.clear();
        textFieldAddNewTariffCost1Mb.clear();

        textFieldAddNewClientName.clear();
        textFieldAddNewClientPhone.clear();
        textFieldAddNewClientBalance.clear();
        comboBoxAddNewClientTariff.getItems().clear();

        textFieldLicFeeYearDown.clear();
        textFieldLicFeeYearUp.clear();
        textFieldLicFeeMonthDown.clear();
        textFieldLicFeeMonthUP.clear();
        textFieldLicFeeDayDown.clear();
        textFieldLicFeeDayUp.clear();
        textFieldInternetFeeYearDown.clear();
        textFieldInternetFeeYearUp.clear();
        textFieldInternetFeeMonthDown.clear();
        textFieldInternetFeeMonthUp.clear();
        textFieldInternetFeeDayDown.clear();
        textFieldInternetFeeDayUp.clear();
        textFieldCostConnDown.clear();
        textFieldCostConnUp.clear();
        textFieldCostMinuteDown.clear();
        textFieldCostMinuteUp.clear();
        textFieldCostCallDown.clear();
        textFieldCostCallUp.clear();
        textFieldCost1MbDown.clear();
        textFieldCost1MbUp.clear();
        textFieldCost1GbDown.clear();
        textFieldCost1GbUp.clear();

        statisticComboBoxTariff.getItems().clear();
        statisticNumberofClient.clear();
    }

    /**
     * set all main anchors to .setVisible(false)
     */
    private void allAnchorsVisibleFalse() {
        anchorMain.setVisible(true);
        anchorAddTariffFirst.setVisible(false);
        anchorAddTariffSecond.setVisible(false);
        anchorAddClient.setVisible(false);
        pane_searchTariff.setVisible(false);
        anchorSearchTariffByParam.setVisible(false);
        tabPane.setVisible(false);
        watchTariffSearch.setVisible(false);
        anchorStatistic.setVisible(false);
    }


    /**
     * switch anchors to anchorAddTariffSecond
     *
     * @param actionEvent - button pressed
     */
    public void buttonAddNewTariffNext(ActionEvent actionEvent) {
        allAnchorsVisibleFalse();
        anchorAddTariffSecond.setVisible(true);
    }

    /**
     * read all fields of form add new tariff, add new tariff to array
     *
     * @param actionEvent - button pressed
     */
    public void buttonAddTariffApply(ActionEvent actionEvent) {
        Double licenceFeeYear = null, licenceFeeMonth = null, licenceFeeDay = null,
                costOfCall = null, connectionCost = null, costOfMinute = null,
                internetFeeYear = null, internetFeeMonth = null, internetFeeDay = null,
                internetCost1Gb = null, internetCost1Mb = null;

        licenceFeeYear = subController.textFieldToDouble(textFieldAddNewTariffInternetFeeYear);
        licenceFeeMonth = subController.textFieldToDouble(textFieldAddNewTariffLicFeeMonth);
        licenceFeeDay = subController.textFieldToDouble(textFieldAddNewTariffLicFeeDay);
        costOfCall = subController.textFieldToDouble(textFieldAddNewTariffCostCall);
        connectionCost = subController.textFieldToDouble(textFieldAddNewTariffCostConnect);
        costOfMinute = subController.textFieldToDouble(textFieldAddNewTariffCostMinute);
        internetFeeYear = subController.textFieldToDouble(textFieldAddNewTariffInternetFeeYear);
        internetFeeMonth = subController.textFieldToDouble(textFieldAddNewTariffInternetFeeMonth);
        internetFeeDay = subController.textFieldToDouble(textFieldAddNewTariffInternetFeeDay);
        internetCost1Gb = subController.textFieldToDouble(textFieldAddNewTariffCost1Gb);
        internetCost1Mb = subController.textFieldToDouble(textFieldAddNewTariffCost1Mb);

        Cost cost = new Cost(licenceFeeYear, licenceFeeMonth, licenceFeeDay,
                costOfCall, connectionCost, costOfMinute,
                internetFeeYear, internetFeeMonth, internetFeeDay,
                internetCost1Gb, internetCost1Mb);

        String title = "", description = "";
        title = textFieldAddNewTariffTitle.getText();
        description = textAreaAddNewTariffDescription.getText();
        TariffType tariffType = null;
        if (choiceBoxAddNewTariffType.getSelectionModel().getSelectedItem() != null)
            tariffType = TariffType.valueOf(choiceBoxAddNewTariffType.getSelectionModel().getSelectedItem().toString());
        operationCollection.addTariff(title, tariffType, cost, new GregorianCalendar(), description);
        watchTariff(null);
    }

    /**
     * switch anchors to anchorAddTariffSecond
     *
     * @param actionEvent - menuItem pressed
     */
    public void menuAddNewTariff(ActionEvent actionEvent) {
        allAnchorsVisibleFalse();
        clearAllFields();
        anchorAddTariffFirst.setVisible(true);
    }

    /**
     * @param actionEvent - menuItem pressed
     */
    public void menuAddTestValues(ActionEvent actionEvent) {
        operationCollection.addTestValues();
    }

    /**
     * @param actionEvent
     */
    public void menuAddNewClient(ActionEvent actionEvent) {
        allAnchorsVisibleFalse();
        clearAllFields();
        anchorAddClient.setVisible(true);
        for (Tariff tariff : operationCollection.tariffsArray()) {
            comboBoxAddNewClientTariff.getItems().add(tariff.toString());
        }
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        allAnchorsVisibleFalse();
        tabPane.setVisible(true);
        watchTariff(new Event(null));
    }

    /**
     * @param actionEvent - button pressed
     */
    public void addNewClientApply(ActionEvent actionEvent) {
        Long phoneNumber = 0l;
        String name = "", tariffChoiceString;
        Tariff tariff = null;

        try {
            phoneNumber = Long.parseLong(textFieldAddNewClientPhone.getText().toString());
        } catch (NumberFormatException e) {
        }
        String[] parts = new String[1];
        name = textFieldAddNewClientName.getText().toString();
        if (comboBoxAddNewClientTariff.getSelectionModel().getSelectedItem() != null) {
            tariffChoiceString = comboBoxAddNewClientTariff.getSelectionModel().getSelectedItem().toString();
            parts = tariffChoiceString.split("/");
        }
        Integer tariffChoiceID = -1;

        try {
            tariffChoiceID = Integer.parseInt(parts[0]);
        } catch (NumberFormatException e) {
        }

        if (tariffChoiceID > -1)
            tariff = operationCollection.getTariffById(tariffChoiceID);
        operationCollection.addClient(name, phoneNumber, tariff);
    }

    /**
     * @param actionEvent - button pressed
     */
    public void close(ActionEvent actionEvent) {
        System.exit(100);
    }

    /**
     * switch anchors to anchorWatchTariffs at tabPane
     *
     * @param event - button pressed
     */
    public void watchTariff(Event event) {
        allAnchorsVisibleFalse();
        tabPane.setVisible(true);
        ArrayList<Tariff> tariffs = operationCollection.tariffsArray();
        if (tariffs != null && !tariffs.isEmpty()) {
            ArrayList<StringProprty.TariffStringProperty> propertyArrayList = new ArrayList<StringProprty.TariffStringProperty>();

            for (Tariff tariff : tariffs) {
                propertyArrayList.add(new StringProprty.TariffStringProperty(tariff));
            }

            tableColumnWatchTariffID.setCellValueFactory(new PropertyValueFactory<Tariff, String>("id"));
            tableColumnWatchTariffTitle.setCellValueFactory(new PropertyValueFactory<Tariff, String>("title"));
            tableColumnWatchTariffType.setCellValueFactory(new PropertyValueFactory<Tariff, String>("type"));
            tableColumnWatchTariffLicFeeYear.setCellValueFactory(new PropertyValueFactory<Tariff, String>("licFeeYear"));
            tableColumnWatchTariffLicFeeMonth.setCellValueFactory(new PropertyValueFactory<Tariff, String>("licFeeMonth"));
            tableColumnWatchTariffLicFeeDay.setCellValueFactory(new PropertyValueFactory<Tariff, String>("licFeeDay"));
            tableColumnWatchTariffInternetFeeYear.setCellValueFactory(new PropertyValueFactory<Tariff, String>("internetFeeYear"));
            tableColumnWatchTariffInternetFeeMonth.setCellValueFactory(new PropertyValueFactory<Tariff, String>("internetFeeMonth"));
            tableColumnWatchTariffInternetFeeDay.setCellValueFactory(new PropertyValueFactory<Tariff, String>("internetFeeDay"));
            tableColumnWatchTariffCostConnect.setCellValueFactory(new PropertyValueFactory<Tariff, String>("costOfConnection"));
            tableColumnWatchTariffCostCall.setCellValueFactory(new PropertyValueFactory<Tariff, String>("costOfCall"));
            tableColumnWatchTariffCostMinute.setCellValueFactory(new PropertyValueFactory<Tariff, String>("costOfMinute"));
            tableColumnWatchTariffCost1Mb.setCellValueFactory(new PropertyValueFactory<Tariff, String>("internetCost1Mb"));
            tableColumnWatchTariffCost1Gb.setCellValueFactory(new PropertyValueFactory<Tariff, String>("internetCost1Gb"));
            tableColumnWatchTariffDescription.setCellValueFactory(new PropertyValueFactory<Tariff, String>("textDescription"));

            ObservableList<StringProprty.TariffStringProperty> data =
                    FXCollections.observableArrayList(propertyArrayList);
            tableViewTariff.setItems(data);
        }
    }

    /**
     * switch anchors to anchorWatchClient at tapPane
     *
     * @param event - button pressed
     */
    public void watchClient(Event event) {
        ArrayList<Client> clients = operationCollection.clientArray();
        if (clients != null && !clients.isEmpty()) {
            ArrayList<StringProprty.ClientStringProperty> propertyArrayList = new ArrayList<StringProprty.ClientStringProperty>();

            for (Client client : clients) {
                propertyArrayList.add(new StringProprty.ClientStringProperty(client));
            }

            tableColumnWatchClientID.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
            tableColumnWatchClientName.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
            tableColumnWatchClientPhoneNum.setCellValueFactory(new PropertyValueFactory<Client, String>("phoneNumber"));
            tableColumnWatchClientTariff.setCellValueFactory(new PropertyValueFactory<Client, String>("tariff"));
            tableColumnWatchClientBalance.setCellValueFactory(new PropertyValueFactory<Client, String>("balance"));

            ObservableList<StringProprty.ClientStringProperty> data =
                    FXCollections.observableArrayList(propertyArrayList);
            tableViewClient.setItems(data);
        }
    }

    /**
     * sorted tariffs array by cost
     *
     * @param actionEvent - button pressed
     */
    public void actionDBSortTariffByCost(ActionEvent actionEvent) {
        operationCollection.sortTariffByCost();
    }

    /**
     * switch tabePane to Visible true
     *
     * @param actionEvent - button pressed
     */
    public void watchingTabs(ActionEvent actionEvent) {
        allAnchorsVisibleFalse();
        tabPane.setVisible(true);
    }

    /**
     * switch anchors to anchorStatistic
     *
     * @param actionEvent - button pressed
     */
    public void clientStatisticByTariff(ActionEvent actionEvent) {
        allAnchorsVisibleFalse();
        anchorStatistic.setVisible(true);
        for (Tariff tariff : operationCollection.tariffsArray()) {
            statisticComboBoxTariff.getItems().add(tariff.toString());
        }
    }

    /**
     * switch anchors to anchorSearchTariffByParam
     *
     * @param actionEvent - button pressed
     */
    public void actionSearchTariff(ActionEvent actionEvent) {
        allAnchorsVisibleFalse();
        pane_searchTariff.setVisible(true);
        anchorSearchTariffByParam.setVisible(true);
        choiceBoxTariffType.getItems().clear();
        choiceBoxTariffType.getItems().addAll(TariffType.CONTRACT, TariffType.CORPORATION, TariffType.PAY_TO_CALL);

        for (Tariff tariff : operationCollection.tariffsArray()) {
            comboBoxAddNewClientTariff.getItems().add(tariff.toString());
        }
    }

    /**
     * Read all fields from form
     * Searching tariffs array that pass conditions
     *
     * @param actionEvent - button pressed
     */
    public void buttonSearch(ActionEvent actionEvent) {
        allAnchorsVisibleFalse();
        watchTariffSearch.setVisible(true);
        ValueInBound licenceFeeYear = null, licenceFeeMonth = null, licenceFeeDay = null,
                costOfCall = null, connectionCost = null, costOfMinute = null,
                internetFeeYear = null, internetFeeMonth = null, internetFeeDay = null,
                internetCost1Gb = null, internetCost1Mb = null;
        Double down = 0d, up = 0d;

        licenceFeeYear = subController.valueInBoundGen(textFieldLicFeeYearDown, textFieldLicFeeYearUp);
        licenceFeeMonth = subController.valueInBoundGen(textFieldLicFeeMonthDown, textFieldLicFeeMonthUP);
        licenceFeeDay = subController.valueInBoundGen(textFieldLicFeeDayDown, textFieldLicFeeDayUp);
        internetFeeYear = subController.valueInBoundGen(textFieldInternetFeeYearDown, textFieldInternetFeeYearUp);
        internetFeeMonth = subController.valueInBoundGen(textFieldInternetFeeMonthDown, textFieldInternetFeeMonthUp);
        internetFeeDay = subController.valueInBoundGen(textFieldInternetFeeDayDown, textFieldInternetFeeDayUp);
        costOfCall = subController.valueInBoundGen(textFieldCostCallDown, textFieldCostCallUp);
        connectionCost = subController.valueInBoundGen(textFieldCostConnDown, textFieldCostConnUp);
        costOfMinute = subController.valueInBoundGen(textFieldCostMinuteDown, textFieldCostMinuteUp);
        internetCost1Mb = subController.valueInBoundGen(textFieldCost1MbDown, textFieldCost1MbUp);
        internetCost1Gb = subController.valueInBoundGen(textFieldCost1GbDown, textFieldCost1GbUp);

        TariffType tariffType = null;
        if (choiceBoxTariffType.getSelectionModel().getSelectedItem() != null)
            tariffType = TariffType.valueOf(choiceBoxTariffType.getSelectionModel().getSelectedItem().toString());

        ArrayList<Tariff> tar = operationCollection.searchTariffByParam(licenceFeeYear, licenceFeeMonth, licenceFeeDay,
                costOfCall, connectionCost, costOfMinute, internetFeeYear, internetFeeMonth, internetFeeDay,
                internetCost1Gb, internetCost1Mb, tariffType);

        if (tar != null && !tar.isEmpty()) {
            ArrayList<StringProprty.TariffStringProperty> propertyArrayList = new ArrayList<StringProprty.TariffStringProperty>();

            for (Tariff tariff : tar) {
                propertyArrayList.add(new StringProprty.TariffStringProperty(tariff));
            }

            tableColumnSearchID.setCellValueFactory(new PropertyValueFactory<Tariff, String>("id"));
            tableColumnSearchTitle.setCellValueFactory(new PropertyValueFactory<Tariff, String>("title"));
            tableColumnSearchType.setCellValueFactory(new PropertyValueFactory<Tariff, String>("type"));
            tableColumnSearchLicFeeYear.setCellValueFactory(new PropertyValueFactory<Tariff, String>("licFeeYear"));
            tableColumnSearchLicFeeMonth.setCellValueFactory(new PropertyValueFactory<Tariff, String>("licFeeMonth"));
            tableColumnSearchLicFeeDay.setCellValueFactory(new PropertyValueFactory<Tariff, String>("licFeeDay"));
            tableColumnSearchInternetFeeYear.setCellValueFactory(new PropertyValueFactory<Tariff, String>("internetFeeYear"));
            tableColumnSearchInternetFeeMonth.setCellValueFactory(new PropertyValueFactory<Tariff, String>("internetFeeMonth"));
            tableColumnSearchInternetFeeDay.setCellValueFactory(new PropertyValueFactory<Tariff, String>("internetFeeDay"));
            tableColumnSearchCostConnect.setCellValueFactory(new PropertyValueFactory<Tariff, String>("costOfConnection"));
            tableColumnSearchCostCall.setCellValueFactory(new PropertyValueFactory<Tariff, String>("costOfCall"));
            tableColumnSearchCostMinute.setCellValueFactory(new PropertyValueFactory<Tariff, String>("costOfMinute"));
            tableColumnSearchCost1Mb.setCellValueFactory(new PropertyValueFactory<Tariff, String>("internetCost1Mb"));
            tableColumnSearchCost1Gb.setCellValueFactory(new PropertyValueFactory<Tariff, String>("internetCost1Gb"));
            tableColumnSearchDescription.setCellValueFactory(new PropertyValueFactory<Tariff, String>("textDescription"));

            ObservableList<StringProprty.TariffStringProperty> data =
                    FXCollections.observableArrayList(propertyArrayList);
            tableViewTariffSearch.setItems(data);
        }
    }

    /**
     * returned to anchorSearchTariffByParam to add conditions
     *
     * @param actionEvent - button pressed
     */
    public void searchButonBack(ActionEvent actionEvent) {
        watchTariffSearch.setVisible(false);
        pane_searchTariff.setVisible(true);
        anchorSearchTariffByParam.setVisible(true);
    }

    /**
     * calculated & showed statistic by tariff, number of clients on tariff
     *
     * @param actionEvent - button pressed
     */
    public void showStatistic(ActionEvent actionEvent) {
        statisticNumberofClient.setText("");
        String[] parts = new String[1];
        if (statisticComboBoxTariff.getSelectionModel().getSelectedItem() != null) {
            parts = statisticComboBoxTariff.getSelectionModel().getSelectedItem().toString().split("/");
        }
        Integer tariffChoiceID = -1;

        try {
            tariffChoiceID = Integer.parseInt(parts[0]);
        } catch (NumberFormatException e) {
        }
        statisticNumberofClient.setText(String.valueOf(operationCollection.statisticByTariff(operationCollection.getTariffById(tariffChoiceID))));
    }
}

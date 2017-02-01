package highball.action;

import highball.dao.CountryDAO;
import highball.daoImlp.CountryDaoImpl;
import highball.domain.Country;
import highball.domain.ResultSelection;
import highball.seletion.SelectDB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladimir on 22.01.2017.
 */
public class StartAction {

    private List<ResultSelection> listOrdersByCountry;
    private CountryDAO countryDAO;
    private List<String> listNamesCountries;
    private List<Country> listCountries;
    private String selectedCountry;

    public StartAction(){
        init();
    }

    public List<String> getListNamesCountries() {
        return listNamesCountries;
    }

    public List<ResultSelection> getListOrdersByCountry() {
        return listOrdersByCountry;
    }

    public String getSelectedCountry() {

        return selectedCountry;
    }

    public void setSelectedCountry(String selectedCountry) {
        this.selectedCountry = selectedCountry;
    }

    private void init() {
        countryDAO = new CountryDaoImpl();
        listCountries = countryDAO.getAllCountries();
        listNamesCountries = new ArrayList<>(listCountries.size());
        for (Country country : listCountries) {
            listNamesCountries.add(country.getName());
        }
    }

    private void getListOrdersBySelectedCountry(){
        SelectDB selectDB=new SelectDB();
        int idSelectedCountry=getIndexCountryByName(selectedCountry);
        listOrdersByCountry=selectDB.getOrdersByCountryId(idSelectedCountry);
    }

    private int getIndexCountryByName(String nameCountry){
        int idCountry=0;
        for (Country country: listCountries) {
            if(country.getName().equals(nameCountry)){
                idCountry=country.getId();
                break;
            }
        }
        return idCountry;
    }

    public String execute(){
        getListOrdersBySelectedCountry();
        return "success";
    }

    public String display(){
        return "none";
    }
}

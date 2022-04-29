package com.example.myapplication.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<String> permitName;
    private final MutableLiveData<String> permitInfo;
    private final MutableLiveData<String> permitLots;
    private final MutableLiveData<String> lot;
    private String usertype;

    public DashboardViewModel() {
        permitName = new MutableLiveData<>();
        permitInfo = new MutableLiveData<>();
        permitLots = new MutableLiveData<>();
        lot = new MutableLiveData<>();
        permitName.setValue("");
        permitInfo.setValue("");
        permitLots.setValue("");
        lot.setValue("You have no active permits");
    }

    public LiveData<String> getlot() {
        return lot;
    }
    public LiveData<String> getPermitName() {
        return permitName;
    }
    public LiveData<String> getPermitInfo() {
        return permitInfo;
    }
    public LiveData<String> getPermitLots() {
        return permitLots;
    }

    public void setPermit(String userType, String permitName) {
        if (userType.equals("Employee")) {
            switch (permitName){
                case "Commuter": employeeCommuterPermit();
                    break;
                case "Flex": employeeFlexPermit();
                    break;
                case "OffPeakCommuter": offPeakCommuterPermit();
                    break;
                case "Carpool" : carpoolPermit();
                    break;
            }
        } else if (userType.equals("Student")){
            switch (permitName){
                case "Orange": orangePermit();
                    break;
                case "Langsam": langsamPermit();
                    break;
                case "Commuter": studentCommuterPermit();
                    break;
                case "Flex": studentFlexPermit();
                    break;
                case "Evening": eveningPermit();
                    break;
            }
        }
        lot.setValue("Lots");
    }

    public void orangePermit(){
        permitName.setValue("Orange Permit");
        permitInfo.setValue("Price: \nStatus: Active\nExpires: 4/29/2022");
        permitLots.setValue("29-47 Buswell Street   Spaces: 22 \n2 -22 Buswell Street   Spaces: 17\n46 Mountfort Street     Spaces: 3 \n830-824 Mountfort Street    Spaces: 9");
    }
    public void langsamPermit(){
        permitName.setValue("Langsam Permit");
        permitInfo.setValue("Price: \nStatus: Active\nExpires: 4/29/2022 \nNO OVERNIGHT PARKING");
        permitLots.setValue("Langsam Garage");
    }
    public void studentCommuterPermit(){
        permitName.setValue("Commuter Permit");
        permitInfo.setValue("Price: \nStatus: Active\nExpires: 4/29/2022");
        permitLots.setValue("All times: \n   Agganis Arena \n   Langsam Garage \n   Essex Street Garage and Lot \n\nWeekdays after 3pm or weekends: \n   CAS Lot \n   Warren Towers Garage \n   Rafik B. Hariri Building Garage \n   Buick Street Lot \n   575 Commonwealth Avenue \n   730/750 Commonwealth Avenue \n   Upper Bridge Lot \n   Lower Bridge Lot \n   CFA Lot");
    }
    public void studentFlexPermit(){
        permitName.setValue("Flex Permit");
        permitInfo.setValue("Price: \nStatus: Active\nExpires: 4/29/2022");
        permitLots.setValue("All times: \n   Agganis Arena \n   Langsam Garage \n   Essex Street Garage and Lot \n\nWeekdays after 3pm or weekends: \n   CAS Lot \n   Warren Towers Garage \n   Rafik B. Hariri Building Garage ");

    }
    public void eveningPermit(){
        permitName.setValue("Evening Permit");
    }
    public void employeeCommuterPermit(){
        permitName.setValue("Commuter Permit");
        permitInfo.setValue("Price: \nStatus: Active\nExpires: 4/29/2022");
        permitLots.setValue("Agganis Arena \nLangsam Garage \nBuick Street Lot \nCFA Lot \nEssex Street Garage and Lot \nLower Bridge Lot \nUpper Bridge Lot \nCAS Lot \nWarren Towers Garage \n575 Commonwelath Avenue \nRafik B. Hariri Building Garage \nKenmore Lot \n730/750 Commonwealth Avenue \n766 Commonwealth Avenue \n890 Commonwealth Avenue");
    }
    public void employeeFlexPermit(){
        permitName.setValue("Flex Permit");
        permitInfo.setValue("Price: \nStatus: Active\nExpires: 4/29/2022");
        permitLots.setValue("Agganis Arena \nLangsam Garage \nBuick Street Lot \nCFA Lot \nEssex Street Garage and Lot \nLower Bridge Lot \nUpper Bridge Lot \nCAS Lot \nWarren Towers Garage \n575 Commonwelath Avenue \nRafik B. Hariri Building Garage \nKenmore Lot \n730/750 Commonwealth Avenue \n766 Commonwealth Avenue \n890 Commonwealth Avenue");
    }
    public void offPeakCommuterPermit(){
        permitName.setValue("Off-Peak Commuter Permit");
        permitInfo.setValue("Price: \nStatus: Active\nExpires: 4/29/2022");
        permitLots.setValue("Agganis Arena \nLangsam Garage \nBuick Street Lot \nCFA Lot \nEssex Street Garage and Lot \nLower Bridge Lot \nUpper Bridge Lot \nCAS Lot \nWarren Towers Garage \n575 Commonwelath Avenue \nRafik B. Hariri Building Garage \nKenmore Lot \n730/750 Commonwealth Avenue \n766 Commonwealth Avenue \n890 Commonwealth Avenue");
    }
    public void carpoolPermit(){
        permitName.setValue("Carpool Permit");
        permitInfo.setValue("Price: \nStatus: Active\nExpires: 4/29/2022");
        permitLots.setValue("Agganis Arena \nLangsam Garage \nEssex Street Garage and Lot \nCAS Lot \nWarren Towers Garage \nRafik B. Hariri Building Garage");
    }


}
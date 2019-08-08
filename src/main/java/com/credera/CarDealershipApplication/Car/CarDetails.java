package com.credera.CarDealershipApplication.Car;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarDetails {
    private String Make;
    private String Model;
    private String Transmission;
    private double City_Unadj_Conventional_Fuel;
    private double Hwy_Unadj_Conventional_Fuel;
    private String Air_AspirMethod;
    private int Num_of_Gears;
    private String Drive_Desc;
    private String Carline_Class_Desc;
    private String Car_Truck_Category_Cash_for_Clunkers_Bill;
    private String Oil_Viscosity;
    private int Comb_CO2_Rounded_Adjusted_as_shown_on_FE_Label;
}

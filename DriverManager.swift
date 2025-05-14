//
//  DriverManager.swift
//  UDLAPRide
//
//  Created by Eliud Ortiz Ponce on 28/04/25.
//


import Foundation

class DriverManager: ObservableObject {
    @Published var drivers: [Driver] = []

    func addDriver(name: String, carModel: String, availableTimes: String) {
        let newDriver = Driver(name: name, carModel: carModel, availableTimes: availableTimes)
        drivers.append(newDriver)
    }
}

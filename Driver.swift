//
//  Driver.swift
//  UDLAPRide
//
//  Created by Eliud Ortiz Ponce on 28/04/25.
//


import Foundation

struct Driver: Identifiable {
    var id = UUID()
    var name: String
    var carModel: String
    var availableTimes: String
}

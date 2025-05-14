//
//  DriverListView.swift
//  UDLAPRide
//
//  Created by Eliud Ortiz Ponce on 28/04/25.
//


import SwiftUI

struct DriverListView: View {
    @EnvironmentObject var driverManager: DriverManager

    var body: some View {
        List {
            ForEach(driverManager.drivers) { driver in
                VStack(alignment: .leading) {
                    Text(driver.name)
                        .font(.headline)
                    Text("Carro: \(driver.carModel)")
                    Text("Horario: \(driver.availableTimes)")
                        .font(.subheadline)
                        .foregroundColor(.gray)
                }
            }
        }
        .navigationTitle("Conductores Registrados")
    }
}

#Preview {
    DriverListView()
        .environmentObject(DriverManager())
}

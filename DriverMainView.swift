//
//  DriverMainView.swift
//  UDLAPRide
//
//  Created by Eliud Ortiz Ponce on 13/05/25.
//


import SwiftUI

struct DriverMainView: View {
    @State private var isAvailable = false
    @State private var selectedDestination: String = ""
    
    let destinos = ["Cholula", "Puebla Centro", "Angelópolis", "Lomas de Angelópolis", "San Andrés", "San Pedro"]

    var body: some View {
        NavigationView {
            VStack(spacing: 20) {
                Text("Panel del Conductor")
                    .font(.largeTitle)
                    .fontWeight(.bold)

                // Botón de disponibilidad
                Button(action: {
                    isAvailable.toggle()
                }) {
                    Text(isAvailable ? "🔴 No disponible" : "🟢 Ponerse disponible")
                        .frame(maxWidth: .infinity)
                        .padding()
                        .background(isAvailable ? Color.red : Color.green)
                        .foregroundColor(.white)
                        .cornerRadius(10)
                }

                // Picker de destino
                VStack(alignment: .leading) {
                    Text("Destino preferido:")
                        .font(.headline)

                    Picker("Destino", selection: $selectedDestination) {
                        ForEach(destinos, id: \.self) { destino in
                            Text(destino)
                        }
                    }
                    .pickerStyle(MenuPickerStyle())

                    if !selectedDestination.isEmpty {
                        Text("Destino elegido: \(selectedDestination)")
                            .foregroundColor(.blue)
                    }
                }

                Spacer()
            }
            .padding()
            .navigationTitle("Conductor")
        }
    }
}

#Preview {
    DriverMainView()
}

//
//  SearchingForDriverView.swift
//  UDLAPRide
//
//  Created by Eliud Ortiz Ponce on 05/05/25.
//


import SwiftUI

struct SearchingForDriverView: View {
    @Environment(\.dismiss) var dismiss
    @State private var isDriverFound = false

    var body: some View {
        VStack(spacing: 30) {
            Spacer()

            Text("Buscando conductor...")
                .font(.title2)
                .fontWeight(.medium)

            ProgressView()
                .scaleEffect(2)
                .progressViewStyle(CircularProgressViewStyle(tint: .black))

            Spacer()

            if isDriverFound {
                Text("🚗 ¡Conductor encontrado!")
                    .font(.title3)
                    .foregroundColor(.green)

                Button("Aceptar") {
                    dismiss()
                }
                .padding()
                .background(Color.black)
                .foregroundColor(.white)
                .cornerRadius(10)
            }
        }
        .padding()
        .onAppear {
            DispatchQueue.main.asyncAfter(deadline: .now() + 3.0) {
                isDriverFound = true
            }
        }
    }
}

#Preview {
    SearchingForDriverView()
}

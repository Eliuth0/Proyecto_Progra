//
//  ReportProblemView.swift
//  UDLAPRide
//
//  Created by Eliud Ortiz Ponce on 28/04/25.
//


import SwiftUI

struct ReportProblemView: View {
    @State private var problemDescription: String = ""
    @State private var submitted: Bool = false

    var body: some View {
        Form {
            Section(header: Text("Describe el problema")) {
                TextEditor(text: $problemDescription)
                    .frame(height: 150)
                    .overlay(RoundedRectangle(cornerRadius: 8)
                                .stroke(Color.gray.opacity(0.5), lineWidth: 1))
            }

            Button(action: {
                // Simular envío del problema
                submitted = true
                problemDescription = ""
            }) {
                Text("Enviar Reporte")
                    .frame(maxWidth: .infinity)
                    .padding()
                    .background(Color.red)
                    .foregroundColor(.white)
                    .cornerRadius(8)
            }

            if submitted {
                Section {
                    Text("¡Reporte enviado exitosamente!")
                        .foregroundColor(.green)
                        .font(.headline)
                }
            }
        }
        .navigationTitle("Reportar Problema")
    }
}

#Preview {
    ReportProblemView()
}

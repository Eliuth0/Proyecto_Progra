//
//  DriverRegisterView.swift
//  UDLAPRide
//
//  Created by Eliud Ortiz Ponce on 13/05/25.
//
import SwiftUI


struct DriverRegisterView: View {
    @AppStorage("driverEmail") var storedEmail = ""
    @AppStorage("driverPassword") var storedPassword = ""
    @State private var email = ""
    @State private var password = ""
    @Environment(\.dismiss) var dismiss

    var body: some View {
        VStack(spacing: 20) {
            Text("Registro de Conductor")
                .font(.title)

            TextField("Correo electrónico", text: $email)
                .textFieldStyle(RoundedBorderTextFieldStyle())

            SecureField("Contraseña", text: $password)
                .textFieldStyle(RoundedBorderTextFieldStyle())

            Button("Registrarse") {
                storedEmail = email
                storedPassword = password
                dismiss()
            }
            .padding()
            .background(Color.black)
            .foregroundColor(.white)
            .cornerRadius(10)

            Spacer()
        }
        .padding()
    }
}

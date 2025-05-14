//
//  DriverLoginView.swift
//  UDLAPRide
//
//  Created by Eliud Ortiz Ponce on 13/05/25.
//
import SwiftUI

struct DriverLoginView: View {
    @AppStorage("driverEmail") var storedEmail = ""
    @AppStorage("driverPassword") var storedPassword = ""
    @State private var email = ""
    @State private var password = ""
    @State private var loginSuccess = false

    var body: some View {
        VStack(spacing: 20) {
            Text("Login Conductor")
                .font(.title)

            TextField("Correo electrónico", text: $email)
                .textFieldStyle(RoundedBorderTextFieldStyle())

            SecureField("Contraseña", text: $password)
                .textFieldStyle(RoundedBorderTextFieldStyle())

            Button("Entrar") {
                if email == storedEmail && password == storedPassword {
                    loginSuccess = true
                }
            }
            .padding()
            .background(Color.black)
            .foregroundColor(.white)
            .cornerRadius(10)

            if loginSuccess {
                Text("✅ Sesión iniciada como conductor")
                    .foregroundColor(.green)
            }

            Spacer()
        }
        .padding()
    }
}

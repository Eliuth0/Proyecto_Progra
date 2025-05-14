import SwiftUI

struct RegisterView: View {
    @EnvironmentObject var auth: AuthManager
    @State private var email = ""
    @State private var password = ""
    @State private var isDriver = false
    @State private var registrationFailed = false

    var body: some View {
        VStack(spacing: 20) {
            Text("Crear cuenta")
                .font(.title)

            TextField("Correo electrónico", text: $email)
                .textFieldStyle(RoundedBorderTextFieldStyle())
                .autocapitalization(.none)

            SecureField("Contraseña", text: $password)
                .textFieldStyle(RoundedBorderTextFieldStyle())

            Toggle("Soy conductor", isOn: $isDriver)

            Button("Registrarse") {
                registrationFailed = !auth.register(email: email, password: password, isDriver: isDriver)
            }
            .padding()
            .background(Color.black)
            .foregroundColor(.white)
            .cornerRadius(10)

            if registrationFailed {
                Text("Este correo ya está registrado")
                    .foregroundColor(.red)
            }

            Spacer()
        }
        .padding()
    }
}

#Preview {
    RegisterView().environmentObject(AuthManager())
}

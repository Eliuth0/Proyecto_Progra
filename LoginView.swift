import SwiftUI

struct LoginView: View {
    @EnvironmentObject var auth: AuthManager
    @State private var email = ""
    @State private var password = ""
    @State private var loginFailed = false

    var body: some View {
        VStack(spacing: 20) {
            Text("Iniciar sesión")
                .font(.title)

            TextField("Correo electrónico", text: $email)
                .textFieldStyle(RoundedBorderTextFieldStyle())
                .autocapitalization(.none)

            SecureField("Contraseña", text: $password)
                .textFieldStyle(RoundedBorderTextFieldStyle())

            Button("Entrar") {
                loginFailed = !auth.login(email: email, password: password)
            }
            .padding()
            .background(Color.black)
            .foregroundColor(.white)
            .cornerRadius(10)

            if loginFailed {
                Text("Correo o contraseña incorrectos")
                    .foregroundColor(.red)
            }

            Spacer()
        }
        .padding()
    }
}

#Preview {
    LoginView().environmentObject(AuthManager())
}

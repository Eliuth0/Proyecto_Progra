import SwiftUI

struct WelcomeView: View {
    @EnvironmentObject var auth: AuthManager

    @State private var goToMain = false
    @State private var goToDriver = false
    @State private var goToAdmin = false
    
    var body: some View {
        NavigationStack {
            VStack(spacing: 30) {
                Spacer()

                Text("Bienvenido a UDLAP Ride")
                    .font(.largeTitle   )
                    .fontWeight(.bold)
                    .multilineTextAlignment(.center)

                Image(systemName: "car.fill")
                    .resizable()
                    .scaledToFit()
                    .frame(width: 100, height: 100)
                    .foregroundColor(.orange)

                VStack(spacing: 10) {
                    NavigationLink(destination: LoginView()) {
                        Text("Iniciar como Pasajero")
                            .frame(maxWidth: .infinity)
                            .padding()
                            .background(Color.black)
                            .foregroundColor(.white)
                            .cornerRadius(10)
                    }
                    NavigationLink(destination: RegisterView()) {
                        Text("Registrarse como Pasajero")
                            .frame(maxWidth: .infinity)
                            .padding()
                            .background(Color.black)
                            .foregroundColor(.white)
                            .cornerRadius(10)
                    }
                }
                .padding(.horizontal)

                Spacer()
            }
            .padding()
            .onChange(of: auth.currentUser) { newUser in
                if let user = newUser {
                    if user.email.lowercased() == "admin1" && user.password == "admin1" {
                        goToAdmin = true
                    } else if user.isDriver {
                        goToDriver = true
                    } else {
                        goToMain = true
                    }
                }
            }
            .navigationDestination(isPresented: $goToAdmin) {
                AdminUserListView()
            }
            .navigationDestination(isPresented: $goToDriver) {
                DriverMainView()
            }
            .navigationDestination(isPresented: $goToMain) {
                MainView()
            }
        }
    }
}

#Preview {
    WelcomeView().environmentObject(AuthManager())
}

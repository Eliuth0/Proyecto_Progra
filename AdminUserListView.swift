import SwiftUI

struct AdminUserListView: View {
    @EnvironmentObject var auth: AuthManager

    var body: some View {
        if auth.currentUser?.email.lowercased() == "admin1" && auth.currentUser?.password == "admin1" {
            NavigationView {
                VStack {
                    Text("Usuarios registrados")
                        .font(.title2)
                        .padding(.top)

                    List {
                        ForEach(auth.users) { user in
                            VStack(alignment: .leading, spacing: 4) {
                                Text(user.email)
                                    .font(.headline)
                                Text(user.isDriver ? "Conductor" : "Pasajero")
                                    .foregroundColor(.gray)
                                    .font(.subheadline)
                            }
                        }
                        .onDelete(perform: deleteUser)
                    }

                    Button("Eliminar todos los usuarios") {
                        auth.clearAllUsers()
                    }
                    .foregroundColor(.red)
                    .padding()

                    Spacer()
                }
                .navigationTitle("Panel de Admin")
            }
        } else {
            VStack {
                Text("Acceso restringido")
                    .font(.title)
                    .foregroundColor(.red)
                Text("No tienes permisos para ver esta página")
            }
            .padding()
        }
    }

    private func deleteUser(at offsets: IndexSet) {
        auth.users.remove(atOffsets: offsets)
    }
}

#Preview {
    AdminUserListView().environmentObject(AuthManager())
}

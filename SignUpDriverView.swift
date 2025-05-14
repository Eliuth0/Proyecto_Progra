import SwiftUI

struct SignUpDriverView: View {
    @EnvironmentObject var driverManager: DriverManager

    @State private var name: String = ""
    @State private var carModel: String = ""
    @State private var availableTimes: String = ""
    @State private var savedMessage: String?

    var body: some View {
        Form {
            Section(header: Text("Información del Conductor")) {
                TextField("Nombre", text: $name)
                TextField("Modelo del Carro", text: $carModel)
                TextField("Horarios Disponibles (ej. 3PM-5PM)", text: $availableTimes)
            }

            Button(action: {
                driverManager.addDriver(name: name, carModel: carModel, availableTimes: availableTimes)
                savedMessage = "¡Conductor registrado exitosamente!"
                name = ""
                carModel = ""
                availableTimes = ""
            }) {
                Text("Registrar")
                    .frame(maxWidth: .infinity)
                    .padding()
                    .background(Color.blue)
                    .foregroundColor(.white)
                    .cornerRadius(8)
            }

            if let message = savedMessage {
                Section {
                    Text(message)
                        .foregroundColor(.green)
                }
            }
        }
        .navigationTitle("Registro de Conductor")
    }
}

#Preview {
    SignUpDriverView()
        .environmentObject(DriverManager())
}

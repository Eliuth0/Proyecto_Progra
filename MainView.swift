import SwiftUI
import MapKit

struct MainView: View {
    @EnvironmentObject var locationManager: LocationManager

    let destinations = ["Cholula", "Puebla Centro", "Angelópolis", "Lomas de Angelópolis", "San Andrés", "San Pedro"]

    @State private var showDestinationPicker = false
    @State private var selectedDestination: String = ""
    @State private var showSearchingView = false

    @State private var cameraPosition = MapCameraPosition.region(
        MKCoordinateRegion(
            center: CLLocationCoordinate2D(latitude: 19.0514, longitude: -98.2811),
            span: MKCoordinateSpan(latitudeDelta: 0.05, longitudeDelta: 0.05)
        )
    )

    var body: some View {
        NavigationView {
            VStack(spacing: 0) {
                // 🔝 Título fijo
                Text("UDLAP Ride")
                    .font(.largeTitle)
                    .fontWeight(.bold)
                    .padding(.top, 50)
                    .padding(.bottom, 10)

                // 🗺️ Mapa con avatar y botón de centrado
                ZStack(alignment: .topTrailing) {
                    Map(position: $cameraPosition) {
                        // Avatar personalizado del usuario
                        if let userLoc = locationManager.userLocation {
                            Annotation("Tú", coordinate: userLoc) {
                                Image(systemName: "person.circle.fill")
                                    .resizable()
                                    .frame(width: 32, height: 32)
                                    .foregroundColor(.green)
                            }
                        }

                        // Marcador del destino
                        if !selectedDestination.isEmpty {
                            Marker("Destino: \(selectedDestination)", coordinate: destinationCoordinate(for: selectedDestination))
                                .tint(.blue)
                        }
                    }
                    .frame(height: 300)
                    .cornerRadius(12)
                    .padding(.horizontal)

                    // Botón de centrado
                    Button(action: centerOnUser) {
                        Image(systemName: "location.circle.fill")
                            .resizable()
                            .frame(width: 40, height: 40)
                            .foregroundColor(.white)
                            .background(Circle().fill(Color.black).shadow(radius: 4))
                            .padding()
                    }
                }

                // Scroll con botones y opciones
                ScrollView {
                    VStack(spacing: 16) {
                        // Botón para mostrar/ocultar picker
                        Button(action: {
                            showDestinationPicker.toggle()
                        }) {
                            Text(showDestinationPicker ? "Ocultar Destinos" : "Elegir Destino")
                                .frame(maxWidth: .infinity)
                                .padding()
                                .background(Color.black)
                                .foregroundColor(.white)
                                .cornerRadius(8)
                        }

                        // Picker y confirmación
                        if showDestinationPicker {
                            Picker("Destino", selection: $selectedDestination) {
                                ForEach(destinations, id: \.self) {
                                    Text($0)
                                }
                            }
                            .pickerStyle(WheelPickerStyle())
                            .frame(height: 100)

                            if !selectedDestination.isEmpty {
                                Text("Destino seleccionado: \(selectedDestination)")
                                    .foregroundColor(.blue)
                                    .font(.headline)

                                Button("Confirmar destino") {
                                    moveToSelectedDestination()
                                    showSearchingView = true
                                }
                                .padding()
                                .background(Color.black)
                                .foregroundColor(.white)
                                .cornerRadius(8)
                            }
                        }

                        // Navegación a otras vistas
                        NavigationLink(destination: SignUpDriverView()) {
                            Text("Registrarse como Conductor")
                                .frame(maxWidth: .infinity)
                                .padding()
                                .background(Color.black)
                                .foregroundColor(.white)
                                .cornerRadius(8)
                        }

                        NavigationLink(destination: ReportProblemView()) {
                            Text("Reportar un Problema")
                                .frame(maxWidth: .infinity)
                                .padding()
                                .background(Color.black)
                                .foregroundColor(.white)
                                .cornerRadius(8)
                        }

                        NavigationLink(destination: DriverListView()) {
                            Text("Ver Conductores Registrados")
                                .frame(maxWidth: .infinity)
                                .padding()
                                .background(Color.black)
                                .foregroundColor(.white)
                                .cornerRadius(8)
                        }

                        Spacer(minLength: 50)
                    }
                    .padding()
                }
            }
            .background(Color.white.ignoresSafeArea())
            .sheet(isPresented: $showSearchingView) {
                SearchingForDriverView()
            }
            .onReceive(Timer.publish(every: 1, on: .main, in: .common).autoconnect()) { _ in
                if let coord = locationManager.userLocation {
                    cameraPosition = .region(
                        MKCoordinateRegion(center: coord, span: MKCoordinateSpan(latitudeDelta: 0.01, longitudeDelta: 0.01))
                    )
                }
            }
        }
    }

    // Coordenadas por destino
    func destinationCoordinate(for destination: String) -> CLLocationCoordinate2D {
        switch destination {
        case "Cholula":
            return CLLocationCoordinate2D(latitude: 19.0642, longitude: -98.3031)
        case "Puebla Centro":
            return CLLocationCoordinate2D(latitude: 19.0414, longitude: -98.2063)
        case "Angelópolis":
            return CLLocationCoordinate2D(latitude: 19.0196, longitude: -98.2445)
        case "Lomas de Angelópolis":
            return CLLocationCoordinate2D(latitude: 18.9921, longitude: -98.2531)
        case "San Andrés":
            return CLLocationCoordinate2D(latitude: 19.0473, longitude: -98.3003)
        case "San Pedro":
            return CLLocationCoordinate2D(latitude: 19.0597, longitude: -98.3035)
        default:
            return CLLocationCoordinate2D(latitude: 19.0514, longitude: -98.2811)
        }
    }

    // Centrar en el usuario
    func centerOnUser() {
        if let userLocation = locationManager.userLocation {
            cameraPosition = .region(
                MKCoordinateRegion(
                    center: userLocation,
                    span: MKCoordinateSpan(latitudeDelta: 0.01, longitudeDelta: 0.01)
                )
            )
        }
    }

    // Mover al destino seleccionado
    func moveToSelectedDestination() {
        let coordinate = destinationCoordinate(for: selectedDestination)
        cameraPosition = .region(
            MKCoordinateRegion(center: coordinate, span: MKCoordinateSpan(latitudeDelta: 0.05, longitudeDelta: 0.05))
        )
    }
}

#Preview {
    MainView()
        .environmentObject(LocationManager())
        .environmentObject(DriverManager())
    
}

import SwiftUI
import MapKit

struct DestinationAnnotation: Identifiable, Equatable {
    let id = UUID()
    let coordinate: CLLocationCoordinate2D
    let name: String

    static func == (lhs: DestinationAnnotation, rhs: DestinationAnnotation) -> Bool {
        lhs.id == rhs.id &&
        lhs.coordinate.latitude == rhs.coordinate.latitude &&
        lhs.coordinate.longitude == rhs.coordinate.longitude &&
        lhs.name == rhs.name
    }
}

struct StudentDriver: Identifiable {
    let id = UUID()
    let name: String
    let currentLocation: CLLocationCoordinate2D
    let destinationName: String
}

struct ChooseDestinationView: View {
    let destinations = ["Cholula", "Puebla Centro", "Angelópolis", "Lomas de Angelópolis", "San Andrés", "San Pedro"]

    @EnvironmentObject var locationManager: LocationManager

    @State private var selectedDestination: String = ""
    @State private var cameraPosition = MapCameraPosition.region(
        MKCoordinateRegion(
            center: CLLocationCoordinate2D(latitude: 19.0514, longitude: -98.2811),
            span: MKCoordinateSpan(latitudeDelta: 0.05, longitudeDelta: 0.05)
        )
    )
    @State private var annotations: [DestinationAnnotation] = []
    @State private var drivers: [StudentDriver] = [
        StudentDriver(name: "Carlos", currentLocation: CLLocationCoordinate2D(latitude: 19.0580, longitude: -98.2990), destinationName: "Cholula"),
        StudentDriver(name: "Ana", currentLocation: CLLocationCoordinate2D(latitude: 19.0450, longitude: -98.2100), destinationName: "Puebla Centro"),
        StudentDriver(name: "Luis", currentLocation: CLLocationCoordinate2D(latitude: 19.0210, longitude: -98.2445), destinationName: "Angelópolis"),
        StudentDriver(name: "María", currentLocation: CLLocationCoordinate2D(latitude: 18.9921, longitude: -98.2531), destinationName: "Lomas de Angelópolis"),
        StudentDriver(name: "Jorge", currentLocation: CLLocationCoordinate2D(latitude: 19.0473, longitude: -98.3003), destinationName: "San Andrés")
    ]

    @State private var selectedDriver: StudentDriver?
    @State private var showingRideRequest = false

    var body: some View {
        VStack(spacing: 0) {
            Map(position: $cameraPosition) {
                ForEach(annotations) { annotation in
                    Marker(annotation.name, coordinate: annotation.coordinate)
                }
                ForEach(filteredDrivers) { driver in
                    Marker(driver.name, coordinate: driver.currentLocation)
                        .tint(.blue)
                }
                if let userLoc = locationManager.userLocation {
                    Marker("Tú", coordinate: userLoc)
                        .tint(.green)
                }
            }
            .frame(height: 300)
            .cornerRadius(12)
            .overlay(alignment: .topTrailing) {
                Button(action: centerOnUser) {
                    Image(systemName: "location.circle.fill")
                        .foregroundColor(.white)
                        .background(Circle().fill(Color.black).frame(width: 40, height: 40))
                        .padding()
                }
            }

            Form {
                Section(header: Text("Selecciona tu destino")) {
                    Picker("Destino", selection: $selectedDestination) {
                        ForEach(destinations, id: \.self) { destination in
                            Text(destination)
                        }
                    }
                    .pickerStyle(WheelPickerStyle())
                    .onChange(of: selectedDestination) {
                        updateAnnotations(for: selectedDestination)
                    }
                }

                if !selectedDestination.isEmpty {
                    Section {
                        Text("Destino seleccionado: \(selectedDestination)")
                            .font(.headline)
                            .foregroundColor(.blue)
                    }
                }
            }

            if !filteredDrivers.isEmpty {
                List(filteredDrivers) { driver in
                    Button {
                        selectedDriver = driver
                        showingRideRequest = true
                    } label: {
                        VStack(alignment: .leading) {
                            Text(driver.name)
                                .font(.headline)
                            Text("Destino: \(driver.destinationName)")
                                .font(.subheadline)
                                .foregroundColor(.gray)
                        }
                    }
                }
                .listStyle(InsetGroupedListStyle())
            }
        }
        .navigationTitle("Elegir Destino")
        .alert("Ride Solicitado", isPresented: $showingRideRequest) {
            Button("OK", role: .cancel) { }
        } message: {
            if let driver = selectedDriver {
                Text("Has solicitado un ride con \(driver.name).")
            }
        }
    }

    var filteredDrivers: [StudentDriver] {
        drivers.filter { $0.destinationName == selectedDestination }
    }

    func updateAnnotations(for destination: String) {
        var coordinate = CLLocationCoordinate2D(latitude: 19.0514, longitude: -98.2811)

        switch destination {
        case "Cholula": coordinate = CLLocationCoordinate2D(latitude: 19.0642, longitude: -98.3031)
        case "Puebla Centro": coordinate = CLLocationCoordinate2D(latitude: 19.0414, longitude: -98.2063)
        case "Angelópolis": coordinate = CLLocationCoordinate2D(latitude: 19.0196, longitude: -98.2445)
        case "Lomas de Angelópolis": coordinate = CLLocationCoordinate2D(latitude: 18.9921, longitude: -98.2531)
        case "San Andrés": coordinate = CLLocationCoordinate2D(latitude: 19.0473, longitude: -98.3003)
        case "San Pedro": coordinate = CLLocationCoordinate2D(latitude: 19.0597, longitude: -98.3035)
        default: break
        }

        annotations = [DestinationAnnotation(coordinate: coordinate, name: destination)]

        cameraPosition = .region(
            MKCoordinateRegion(center: coordinate, span: MKCoordinateSpan(latitudeDelta: 0.05, longitudeDelta: 0.05))
        )
    }

    func centerOnUser() {
        if let userLocation = locationManager.userLocation {
            cameraPosition = .region(
                MKCoordinateRegion(
                    center: userLocation,
                    span: MKCoordinateSpan(latitudeDelta: 0.03, longitudeDelta: 0.03)
                )
            )
        }
    }
}

#Preview {
    ChooseDestinationView()
        .environmentObject(LocationManager())
}

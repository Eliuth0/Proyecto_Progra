import SwiftUI

@main
struct UDLAPRideApp: App {
    @StateObject private var driverManager = DriverManager()
    @StateObject private var locationManager = LocationManager()
    @StateObject var auth = AuthManager()


    var body: some Scene {
        WindowGroup {
            AppEntryView()
                .environmentObject(driverManager)
                .environmentObject(locationManager)
                .environmentObject(auth)
            
        }
    }
}


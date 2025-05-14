//
//  AppEntryView.swift
//  UDLAPRide
//
//  Created by Eliud Ortiz Ponce on 13/05/25.
//


import SwiftUI

struct AppEntryView: View {
    @EnvironmentObject var auth: AuthManager

    var body: some View {
        if auth.isLoggedIn {
            if auth.isDriver {
                DriverMainView()
            } else {
                MainView()
            }
        } else {
            WelcomeView()
        }
    }
}

#Preview {
    AppEntryView().environmentObject(AuthManager())
}

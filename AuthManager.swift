import Foundation

struct User: Codable, Identifiable, Equatable {
    var id = UUID()
    var email: String
    var password: String
    var isDriver: Bool
}

class AuthManager: ObservableObject {
    @Published var currentUser: User? = nil
    @Published var users: [User] = [] {
        didSet {
            saveUsers()
        }
    }

    init() {
        loadUsers()
    }

    // MARK: Registro
    func register(email: String, password: String, isDriver: Bool) -> Bool {
        if users.contains(where: { $0.email == email }) {
            return false // Ya existe
        }

        let newUser = User(email: email, password: password, isDriver: isDriver)
        users.append(newUser)
        currentUser = newUser
        return true
    }

    // MARK: Login
    func login(email: String, password: String) -> Bool {
        if let foundUser = users.first(where: { $0.email == email && $0.password == password }) {
            currentUser = foundUser
            return true
        }
        return false
    }

    func logout() {
        currentUser = nil
    }

    // ✅ Nueva función para borrar todos los usuarios
    func clearAllUsers() {
        users = []
        currentUser = nil
        UserDefaults.standard.removeObject(forKey: "users")
    }

    // MARK: Persistencia
    private func saveUsers() {
        if let encoded = try? JSONEncoder().encode(users) {
            UserDefaults.standard.set(encoded, forKey: "users")
        }
    }

    private func loadUsers() {
        if let data = UserDefaults.standard.data(forKey: "users"),
           let decoded = try? JSONDecoder().decode([User].self, from: data) {
            users = decoded
        }
    }

    var isLoggedIn: Bool {
        currentUser != nil
    }

    var isDriver: Bool {
        currentUser?.isDriver ?? false
    }
}

import SwiftUI
import shared

struct ContentView: UIViewControllerRepresentable {
    
    func makeUIViewController(context: Context) -> UIViewController {
        return Main.shared.controller
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
    
    init() {
        DumpViewInjector.shared.setView {
            UIHostingController(rootView: DumpTextView()).view
        }
    }
    
}

struct DumpTextView: View {
    var body: some View {
        Text("Hi from SwiftUI")
    }
}



struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}


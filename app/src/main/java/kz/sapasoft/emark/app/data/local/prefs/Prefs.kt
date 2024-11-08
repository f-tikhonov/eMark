package kz.sapasoft.emark.app.data.local.prefs

interface Prefs {
    var active: String?
    var cookie: Set<String?>?
    var dateDB: String?
    var markerSize: Float
    var offline: Boolean
    var passive: String?
    var password: String?
    var server: String?
    var username: String?
}

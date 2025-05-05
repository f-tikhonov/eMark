package kz.sapasoft.emark.app.core

import java.util.UUID

interface UuidBluetoothServiceCallback {
    fun onSuccess(serviceId: UUID?, characteristicsId: UUID?)
    fun onError(message: String?)
}
package kz.sapasoft.emark.app.ui.about

import kz.sapasoft.emark.app.core.BaseViewModel
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl
import javax.inject.Inject

class AboutViewModel @Inject constructor(
    private val prefsImpl: PrefsImpl,
    private val baseCloudRepository: BaseCloudRepository
) : BaseViewModel() {

    private val TAG: String = this::class.java.simpleName
}
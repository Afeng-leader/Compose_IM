package github.leavesczy.compose_chat.ui.base

import android.content.Context
import androidx.lifecycle.ViewModel
import com.af.abner_af_im.provider.ContextProvider
import com.af.abner_af_im.provider.ToastProvider

open class BaseViewModel : ViewModel() {

    protected val context: Context
        get() = ContextProvider.context

    protected fun showToast(resId: Int) {
        ToastProvider.showToast(resId = resId)
    }

    protected fun showToast(msg: String) {
        ToastProvider.showToast(msg = msg)
    }

}
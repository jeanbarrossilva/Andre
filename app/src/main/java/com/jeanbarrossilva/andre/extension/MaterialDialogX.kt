package com.jeanbarrossilva.andre.extension

import android.content.Context
import com.afollestad.materialdialogs.MaterialDialog
import com.jeanbarrossilva.andre.R

object MaterialDialogX {
	fun showSendFeedbackErrorDialog(context: Context) =
		MaterialDialog(context).show {
			title(R.string.dialog_title_send_feedback_error)
			message(R.string.dialog_message_send_feedback_error)
			positiveButton { dismiss() }
		}
}
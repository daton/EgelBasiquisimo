package org.sierra.egel.ui.guiaB

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.webkit.WebView
import androidx.lifecycle.ViewModelProviders
import org.sierra.egel.R


class GuiaBFragment : Fragment() {

    private lateinit var guiaBViewModel: GuiaBViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        guiaBViewModel =
            ViewModelProviders.of(this).get(GuiaBViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_guiab, container, false)
        val webView: WebView = root.findViewById(R.id.webview)
        webView.loadUrl("file:///android_asset/indexb.html")


        return root
    }
}
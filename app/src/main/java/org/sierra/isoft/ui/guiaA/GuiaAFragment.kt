package org.sierra.isoft.ui.guiaA

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.webkit.WebView
import androidx.lifecycle.ViewModelProviders
import org.sierra.isoft.R


class GuiaAFragment : Fragment() {

    private lateinit var guiaAViewModel: GuiaAViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        guiaAViewModel =
            ViewModelProviders.of(this).get(GuiaAViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_send, container, false)
        val webView: WebView = root.findViewById(R.id.webview)
        webView.loadUrl("file:///android_asset/index.html")


        return root
    }
}
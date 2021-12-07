package com.example.footballnews.bottomfragments

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.example.footballnews.R
import com.example.footballnews.databinding.BottomshetUseraboutBinding
import com.example.footballnews.databinding.FragmentUserBinding
import com.github.angads25.toggle.interfaces.OnToggledListener
import com.github.angads25.toggle.model.ToggleableView
import com.google.android.material.bottomsheet.BottomSheetDialog
import eightbitlab.com.blurview.RenderScriptBlur

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class User : Fragment(), OnToggledListener {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var fragment: FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragment = FragmentUserBinding.inflate(inflater, container, false)

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
//            setTheme(R.style.ThemeOverlay_AppCompat_Dark)
        } else {
//            setTheme(R.style.Theme_FootballNews)
        }

        fragment.switch1.setOnToggledListener(this)
        fragment.switch1.isOn = true

        fragment.switch1.isOn =
            AppCompatDelegate.getDefaultNightMode() != AppCompatDelegate.MODE_NIGHT_YES

        fragment.share.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

        fragment.about.setOnClickListener {
            val bottomSheetDialog =
                BottomSheetDialog(requireContext(), R.style.BottomSheetStyle)
            val bottomDialogBinding: BottomshetUseraboutBinding =
                BottomshetUseraboutBinding.inflate(layoutInflater)

            bottomSheetDialog.window!!
                .setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            bottomSheetDialog.setCancelable(true)
            bottomSheetDialog.setContentView(bottomDialogBinding.root)

            val radius = 20f
            bottomSheetDialog.window!!
                .setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            container?.let { it1 ->
                bottomDialogBinding.blurViewDialog.setupWith(it1)
                    .setBlurAlgorithm(RenderScriptBlur(requireContext()))
                    .setBlurRadius(radius)
                    .setBlurAutoUpdate(true)
                    .setHasFixedTransformationMatrix(true)
            }
            bottomSheetDialog.show()
        }

        fragment.telgrambot.setOnClickListener {
            val intent =
                Intent(Intent.ACTION_VIEW, Uri.parse("tg://resolve?domain=futboluz_uz_bot"))
            startActivity(intent)
        }

        fragment.languagecard.setOnClickListener {

        }

        return fragment.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            User().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onSwitched(toggleableView: ToggleableView?, isOn: Boolean) {
        if (isOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            fragment.main.setBackgroundColor(Color.WHITE)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            fragment.main.setBackgroundColor(Color.BLACK)
        }
    }
}
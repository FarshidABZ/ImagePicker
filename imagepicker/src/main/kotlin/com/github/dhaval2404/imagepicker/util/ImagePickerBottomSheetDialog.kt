package com.github.dhaval2404.imagepicker.util

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.dhaval2404.imagepicker.constant.ImageProvider
import com.github.dhaval2404.imagepicker.databinding.BottomSheetImagePickerBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ImagePickerBottomSheetDialog : BottomSheetDialogFragment() {
    private lateinit var binding: BottomSheetImagePickerBinding

    private var onMenuSelectedItemListener: OnMenuSelectedItemListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetImagePickerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        configureViews()
    }

    private fun configureViews() {
        binding.chooseFromCamera.setOnClickListener {
            onMenuSelectedItemListener?.onMenuSelectedItem(ImageProvider.CAMERA)
            dismiss()
        }
        binding.chooseFromGallery.setOnClickListener {
            onMenuSelectedItemListener?.onMenuSelectedItem(ImageProvider.GALLERY)
            dismiss()
        }
    }

    override fun onCancel(dialog: DialogInterface) {
        onMenuSelectedItemListener?.onMenuSelectedItem(null)
        super.onCancel(dialog)
    }

    fun setOnMenuSelectedItemListener(onMenuSelectedItemListener: OnMenuSelectedItemListener) {
        this.onMenuSelectedItemListener = onMenuSelectedItemListener
    }

    interface OnMenuSelectedItemListener {
        fun onMenuSelectedItem(imageProvider: ImageProvider?)
    }
}
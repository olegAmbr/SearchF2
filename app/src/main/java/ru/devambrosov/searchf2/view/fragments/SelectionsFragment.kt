package ru.devambrosov.searchf2.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.devambrosov.searchf2.databinding.FragmentSelectionsBinding
import ru.devambrosov.searchf2.utils.AnimationHelper

class SelectionsFragment : Fragment() {

    private lateinit var _binding: FragmentSelectionsBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSelectionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AnimationHelper.AnimationHelper.performFragmentCircularRevealAnimation(
            binding.selectionsFragmentRoot,
            requireActivity(),
            4
        )
    }
}
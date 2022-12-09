package ru.devambrosov.searchf2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.devambrosov.searchf2.databinding.FragmentWatchLaterBinding


class WatchLaterFragment : Fragment() {

    private lateinit  var _binding: FragmentWatchLaterBinding
    private  val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWatchLaterBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AnimationHelper.AnimationHelper.performFragmentCircularRevealAnimation(binding.watchLaterFragmentRoot, requireActivity(), 4)
    }
}
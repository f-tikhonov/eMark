package kz.sapasoft.emark.app.ui.main_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.example.decompiledapk.R
import kz.sapasoft.emark.app.ui.MainActivity
import kz.sapasoft.emark.app.ui.about.AboutFragment
import kz.sapasoft.emark.app.ui.base.DaggerFragmentExtended
import kz.sapasoft.emark.app.ui.projects.ProjectsFragment
import kz.sapasoft.emark.app.ui.settings.SettingsFragment
import kz.sapasoft.emark.app.utils.Utils

class MainFragment : DaggerFragmentExtended(), OnChildFragmentClickListener {

    private val TAG = this::class.java.simpleName
    private var fragmentId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentId = requireArguments().getInt("id")
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragment = when (fragmentId) {
            FRAGMENT_1 -> ProjectsFragment.newInstance()
            FRAGMENT_2 -> SettingsFragment.newInstance()
            FRAGMENT_3 -> AboutFragment.newInstance()
            else -> ProjectsFragment.newInstance()
        }
        onFragmentAdd(fragment)
    }

    override fun onFragmentAdd(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .add(R.id.fl_content, fragment)
            .addToBackStack(fragment.tag)
            .commit()
    }

    override fun onBackPressed() {
        val childFragmentManager = childFragmentManager
        if (childFragmentManager.fragments.size == 1) {
            val fragment = childFragmentManager.fragments[0]
            val activity = activity as? MainActivity
            if (fragment is ProjectsFragment) {
                activity?.setCloseActivityFlag()
            } else {
                activity?.openProjectsFragment()
            }
        }
        childFragmentManager.popBackStack()
    }

    companion object {
        const val FRAGMENT_1 = 1
        const val FRAGMENT_2 = 2
        const val FRAGMENT_3 = 3

        fun newInstance(id: Int): Fragment {
            return MainFragment().apply {
                arguments = bundleOf("id" to id)
            }
        }
    }
}
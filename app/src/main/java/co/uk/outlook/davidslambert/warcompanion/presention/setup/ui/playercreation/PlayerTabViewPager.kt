package co.uk.outlook.davidslambert.warcompanion.presention.setup.ui.playercreation

import android.util.SparseArray
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PlayerTabViewPager(fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {

    private val registeredFragments = SparseArray<PlayerFragment>()

    var itemNumber : Long = 0L

    override fun getItem(pos: Int): Fragment = PlayerFragment.newInstance()

    override fun getCount(): Int = itemNumber.toInt()

    override fun getPageTitle(position: Int): CharSequence? = "Player ${position + 1}"

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position)
        registeredFragments.put(position, fragment as PlayerFragment?)
        return fragment
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        registeredFragments.remove(position)
        super.destroyItem(container, position, `object`)
    }

    fun getPlayerFragment(position: Int) : PlayerFragment? {
        return registeredFragments.get(position)
    }

}
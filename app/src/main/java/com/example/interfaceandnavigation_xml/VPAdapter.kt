package com.example.interfaceandnavigation_xml

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class VPAdapter(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior) {
    private final val fragmentArrayList: ArrayList<Fragment> = arrayListOf()
    private final val fragmentTitle: ArrayList<String> = arrayListOf()


    override fun getCount(): Int {
        return fragmentArrayList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentArrayList[position]
    }

    public fun addFragment(fragment: Fragment, title: String){
        fragmentArrayList.add(fragment)
        fragmentTitle.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return fragmentTitle[position]
    }

}
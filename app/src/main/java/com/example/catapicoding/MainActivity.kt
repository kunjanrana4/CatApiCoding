package com.example.catapicoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var tab : TabLayout
    lateinit var page : ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        setStatePageAdapter()
        tab.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabSelected(p0: TabLayout.Tab?) {
                page.currentItem = tab.selectedTabPosition
                val fragmentManager = supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                val count = fragmentManager.backStackEntryCount
                if(count >= 1)
                    supportFragmentManager.popBackStack()
                fragmentTransaction.commit()
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
                //TODO: setStatePageAdapter()
            }
        })
    }

    fun initViews(){
        tab = findViewById(R.id.tab_layout)
        page = findViewById(R.id.pager)
    }


    fun setStatePageAdapter(){
        val myViewPageStateAdapter:MyViewPageStateAdapter = MyViewPageStateAdapter(supportFragmentManager)
        myViewPageStateAdapter.addFragment(ImageFragment(),"Images")
        myViewPageStateAdapter.addFragment(BreedFragment(),"Breeds")
        page.adapter=myViewPageStateAdapter
        tab.setupWithViewPager(page,true)
    }
}
class MyViewPageStateAdapter(fm: FragmentManager):
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    val fragmentList:MutableList<Fragment> = ArrayList()
    val fragmentTitleList:MutableList<String> = ArrayList()
    override fun getItem(position: Int): Fragment {
        return fragmentList.get(position)
    }
    override fun getCount(): Int {
        return fragmentList.size
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList.get(position)
    }
    fun addFragment(fragment:Fragment,title:String){
        fragmentList.add(fragment)
        fragmentTitleList.add(title)

    }
}